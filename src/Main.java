import java.util.*;
import java.io.*;

class Node{ // structure of linked list nodes
	int val;
	Node next;
	Node(int val, Node next){
		this.val = val;
		this.next = next;
	}
	Node(int val){
		this.val = val;
		this.next = null;
	}
}
class LinkedList{
	Node head; //first node of list
	Node tail; //last noed of list
	LinkedList(){ 
		head = null;
		tail = null;
	}
	public void add(int val){ //funtion to add elements to the last of linkedList
		Node node = new Node(val);
		if(head == null){
			head = tail = node;
		}
		else{
			tail.next = node;
			tail = tail.next;
		}
	}
	public Node reverse(int left, int right){
		if(left == right) return head;
		int k = 1;
		Node prev = null, cur = head, next = null;
		while(k < left){
			k++;
			prev = cur;
			cur = cur.next;
		}
		Node prev_node = prev, cur_node = cur;
		/*  prev_node = node before left position
			cur_node  = node at left position
		*/
		prev = null;
		while(k <= right){
			k++;
			next = cur.next;
			cur.next = prev;
			prev = cur;
			cur = next;
		}
		/*	prev = node at right position
			cur = node after right position
		*/
		if(prev_node != null) prev_node.next = prev;
		cur_node.next = cur;
		if(left == 1) return prev; //return node at right position
		return head;
	}
}
public class Main{
	public static void main(String args[]){
		try{
			//read file which consists of test cases
			File file = new File("testCases.txt");
			Scanner sc = new Scanner(file);

			while(sc.hasNextLine()){
				LinkedList list = new LinkedList(); // create new linkedlist

				//elements of list 
				String arr[] = sc.nextLine().split(" ");
				
				for(int i = 0; i < arr.length; i++){
					//add elements in linkedlist
					int val = Integer.parseInt(arr[i]);
					list.add(val);
				}
				//take left and right value
				arr = sc.nextLine().split(" ");
				int left = Integer.parseInt(arr[0]);
				int right = Integer.parseInt(arr[1]);

				// Print original list
				System.out.println("------- original list -------");
				Node temp = list.head;
				while(temp != null){
					System.out.print(temp.val + " ");
					temp = temp.next;
				}
				System.out.println();
				// Function to reverse linkedList from left to right position
				list.head = list.reverse(left, right); 

				/* Print reversed list */
				System.out.println("------- Reversed List from " + left + " to " + right + " -------");
				temp = list.head;
				while(temp != null){
					System.out.print(temp.val + " ");
					temp = temp.next;
				}
				System.out.println();
			}
			sc.close();//close reader
		}
		catch(FileNotFoundException e){
			System.out.println("An error occurred.");
      		e.printStackTrace();
		}

		/* For custom Input
		System.out.println("Enter the number of elements to insert in the linked list");
		int n = sc.nextInt(); // n = number of elements in linkedList
		for(int i = 0; i < n; i++){
			System.out.println("Enter element " + i + ": ");
			int val = sc.nextInt(); 
			list.add(val); // add element to last of linkedlist 
		}
		*/
	}
}