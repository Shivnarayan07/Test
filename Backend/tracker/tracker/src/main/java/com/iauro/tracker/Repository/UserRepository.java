package com.iauro.tracker.Repository;






import org.springframework.data.jpa.repository.JpaRepository;

import com.iauro.tracker.Model.User;

public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
