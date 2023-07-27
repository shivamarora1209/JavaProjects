import java.util.Scanner;

public class AppendLinkedList {
    public static void main(String args[]) {
		
		AppendLinkedList list = new AppendLinkedList();
		Scanner scn = new Scanner(System.in);
		int capacity = scn.nextInt();
		
		for(int i = 0 ; i < capacity ; i++) {
			int  data = scn.nextInt();
			list.addLast(data);
		}
		
		int back = scn.nextInt();
		
		scn.close();
		
		list.AppendLL(back);
		System.out.println();
		//list.AppendLL1(back);
		
	}
	
	private class Node{
		int data ;
		Node next ;
	}
	
	private Node head ;
	private Node tail ;
	private int size ;
	
	public  void addLast(int item) {
		
		Node nn = new Node();
		nn.data = item ;
		nn.next = null ;
			
		if(this.size >= 1) {
			this.tail.next = nn ;
		}
		
		if(this.size == 0) {
			this.head = nn ;
			this.tail = nn ;
			this.size++ ;
		}else {
			this.tail = nn ;
			this.size++ ;
		}
	}

	public Node getNodeAt(int back) {
	
		if(back >= this.size) {
			back = back - this.size ;
		}
		
		int index = this.size - back;
		
		Node temp = this.head ;
		for(int i = 1 ; i < index ; i++) {
			temp = temp.next ;
		}
		
		return temp ;
	}
	
	//This is the First Method
	public void AppendLL(int back) {
		
		Node prev = getNodeAt(back);
		Node curr = prev.next ;
		
		//Modify LinkedList
		if(back == this.size) {
			this.tail.next = this.head ;
			prev.next = null ;
			this.tail = prev ;
		}else {
			this.tail.next = this.head ;
			prev.next = null ;
			this.head = curr ;
			this.tail = prev ;
		}
		display();
	}
	
	//This is the Second Method	
	public void AppendLL1(int back) {
		
		Node prev = this.head ;
		Node curr = this.head.next ;
			
		if(back >= this.size) {
			back = back - this.size ;
		}
		
		for(int i = 1 ; i < this.size - back ; i++) {
			prev = prev.next ;
			curr = curr.next ;
		}
		
		//Modify LinkedList
		//Here we separated two LinkedList.
		this.tail = prev ;
		this.tail.next = null ;
		
		Node temp = curr ;
		while(temp.next != null) {
			temp = temp.next ;
		}
		
		temp.next = this.head ;
		this.head = curr ;
		
		display();
		
	}
	
	public void display() {
		
		Node temp = this.head ;
		for(int i = 0 ; i < this.size ; i++) {
			if(i < this.size - 1) {
				System.out.print(temp.data + " ");
				temp = temp.next ;
			}else {
				System.out.print(temp.data);
				temp = temp.next ;
			}
		}
    }
}



