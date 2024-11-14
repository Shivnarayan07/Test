package Fresher;

import java.util.HashSet;
	class ListNode {
	    int value;
	    ListNode next;

	    ListNode(int value) {
	        this.value = value;
	        this.next = null;
	    }
	}

	public class logistics1 {

	    public static boolean hasCycle(ListNode head) {
	       
	        HashSet<ListNode> visitedNodes = new HashSet<>();
	        
	        ListNode current = head;
	        while (current != null) {
	            
	            if (visitedNodes.contains(current)) {
	                return true;
	            }
	            
	            visitedNodes.add(current);
	            current = current.next;
	        }
	        
	       
	        return false;
	    }

	    public static void main(String[] args) {
	       
	        ListNode head1 = new ListNode(20);
	        ListNode node2 = new ListNode(30);
	        ListNode node3 = new ListNode(40);
	        ListNode node4 = new ListNode(60);
	        ListNode node5 = new ListNode(80);
	        
	        head1.next = node2;
	        node2.next = node3;
	        node3.next = node4;
	        node4.next = node5;
	        node5.next = node3; 

	     
	        System.out.println(hasCycle(head1));  

	        
	        ListNode head2 = new ListNode(6);
	        ListNode nodeB = new ListNode(4);
	        ListNode nodeC = new ListNode(2);
	        ListNode nodeD = new ListNode(8);
	        
	        head2.next = nodeB;
	        nodeB.next = nodeC;
	        nodeC.next = nodeD;

	        System.out.println(hasCycle(head2));  
	    }
}
