const API_URL = "http://localhost:8080/api";  
let token = localStorage.getItem("token");

document.getElementById('signup-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const username = document.getElementById('username').value;
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch(`${API_URL}/auth/signup`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ username, email, password }),
    });

    if (response.ok) {
        window.location.href = 'login.html';
    }
});

document.getElementById('login-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const email = document.getElementById('email').value;
    const password = document.getElementById('password').value;

    const response = await fetch(`${API_URL}/auth/login`, {
        method: 'POST',
        headers: { 'Content-Type': 'application/json' },
        body: JSON.stringify({ email, password }),
    });

    const data = await response.json();
    if (data.token) {
        localStorage.setItem('token', data.token);
        window.location.href = 'expenses.html';
    }
});

document.getElementById('expense-form')?.addEventListener('submit', async (event) => {
    event.preventDefault();
    const category = document.getElementById('category').value;
    const amount = document.getElementById('amount').value;
    const comments = document.getElementById('comments').value;

    const response = await fetch(`${API_URL}/expenses`, {
        method: 'POST',
        headers: {
            'Content-Type': 'application/json',
            'Authorization': `Bearer ${token}`,
        },
        body: JSON.stringify({ category, amount, comments }),
    });

    if (response.ok) {
        loadExpenses();
    }
});

document.getElementById('logout-button')?.addEventListener('click', () => {
    localStorage.removeItem('token');
    window.location.href = 'index.html';
});

async function loadExpenses() {
    const response = await fetch(`${API_URL}/expenses`, {
        headers: { 'Authorization': `Bearer ${token}` },
    });

    const expenses = await response.json();
    const tbody = document.getElementById('expense-table').querySelector('tbody');
    tbody.innerHTML = '';

    expenses.forEach((expense) => {
        const row = document.createElement('tr');
        row.innerHTML = `
            <td>${expense.category}</td>
            <td>${expense.amount}</td>
            <td>${expense.comments}</td>
            <td><button onclick="deleteExpense('${expense.id}')">Delete</button></td>
        `;
        tbody.appendChild(row);
    });
}

async function deleteExpense(id) {
    const response = await fetch(`${API_URL}/expenses/${id}`, {
        method: 'DELETE',
        headers: { 'Authorization': `Bearer ${token}` },
    });

    if (response.ok) {
        loadExpenses();
    }
}

if (token) {
    loadExpenses();
}
