//{ Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;

class Node
{
    int data;
    Node next;
    Node(int key)
    {
        data = key;
        next = null;
    }
}

class Driverclass
{
    public static void main (String[] args) 
    {
        Scanner sc= new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            int n = sc.nextInt();
            Node head = new Node(sc.nextInt());
            Node tail = head;
            while(n-- > 1){
		        tail.next = new Node(sc.nextInt());
		        tail = tail.next;
		    }
		   
		      head = new Solution().segregate(head);
		     printList(head);
		    System.out.println();
        }
    }
    
    public static void printList(Node head)
    {
        if(head == null)
           return;
           
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.data + " ");
            temp = temp.next;
        }
    }
    
    
}




// } Driver Code Ends


//User function Template for Java

/*
class Node
{
    int data;
    Node next;
    Node(int data)
    {
        this.data = data;
        next = null;
    }
}
*/
class Solution
{
    //Function to sort a linked list of 0s, 1s and 2s.
    static Node segregate(Node head)
    {
        // add your code here
        Node dummy0=new Node(0);
        Node dummy1=new Node(1);
        Node dummy2=new Node(2);
        
        Node current0=dummy0;
        Node current1=dummy1;
        Node current2=dummy2;
        
        Node current=head;
        while (current != null) {
            if (current.data == 0) {
                current0.next = current;
                current0 = current0.next;
            } else if (current.data == 1) {
                current1.next = current;
                current1 = current1.next;
            } else {
                current2.next = current;
                current2 = current2.next;
            }
            current = current.next;
        }
        
        current0.next = dummy1.next != null ? dummy1.next : dummy2.next;
        current1.next = dummy2.next;
        current2.next = null;
        
        return dummy0.next;
    }
}


