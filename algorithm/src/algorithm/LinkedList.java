package algorithm;

public class LinkedList {
	Node head;//링크드 리스트의 헤드 
	static class Node{//inner class 
		//inner class는 default가 static 이다. 
		int data;//노드의 데이터
		Node next;//다음 노드를 가르키는 변수
		Node(int d){
			data = d;
			next = null;
		}
	}
	public static LinkedList insert(LinkedList list, int data) {
		Node new_node = new Node(data);// 새로운 노드 할당 
		new_node.next = null;// 다음 노드는 일단 null 
		
		if(list.head == null)//head가 empty 일 때 새로운 node를 head로 할당한다. 
		{
			list.head = new_node;
		}else {//head가 있으면 마지막 노드까지 traverse 한다. 그 후 마지막 노드의 next에 new_node를 할당한다. 
			Node last = list.head;//node last는 list.head 즉 첫번째 노드를 가리킨다. 
			while(last.next != null) {
				last = last.next;//last는 다음 노드로 넘어간다. 
			}
			last.next = new_node;//마지막 노드의 next에 new_node를 할당한다. 
		}
		return list;	
	}
	
	public static void printList(LinkedList list) {
		Node currNode = list.head;//현재 노드는 링크드리스트의 헤드 즉 첫번째 값 
		System.out.println("LinkedList : ");
		
		while(currNode != null) {
			System.out.println(currNode.data + "");
			currNode = currNode.next;
		}
	}
	public static LinkedList deleteByKey(LinkedList list, int key) {
		Node currNode = list.head;
		Node prev = null;
		//키 값이 헤드에 있을 때
		if(currNode.data == key) {
			list.head = currNode.next;//헤드를 현재노드의 다음으로 옮긴다. 
			return list;
		}
		
		//키값이 헤드가 아닌 곳에 있을 때
		while(currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}
		//키값이 있을 때 
		
		if(currNode != null) {//garbage collector가 unreferenced된 메모리를 수거한다. 
			System.out.println("found key and deleted");
			prev.next = currNode.next;
		}
	
		//키값이 없을 때 
		
		if(currNode == null) {
			System.out.println("key not found");
		}
		
		return list;
	}
	
	public static LinkedList deleteByPosition(LinkedList list, int position) {
		Node currNode = list.head;
		Node prev = null;
		
		int idx = 0;
		if(position == 0) {
			if(currNode != null) {
				list.head = currNode.next;
			}
		}else {
			while(currNode != null) {
				if(idx == position) {
					prev.next = currNode.next;
					System.out.println("found position and deleted");
					break;
				}
				prev = currNode;
				currNode = currNode.next;
				if(currNode == null) {
					System.out.println("didn't find position");
				}
				idx++;
			}
		}
		
		return list;
	}
	
	
	public static void main(String[] args) {
		LinkedList linkedList = new LinkedList();
		
		linkedList = insert(linkedList, 3);
		linkedList = insert(linkedList, 4);
		linkedList = insert(linkedList, 5);
		linkedList = insert(linkedList, 6);
		linkedList = insert(linkedList, 7);
		linkedList = insert(linkedList, 8);
		
		linkedList = deleteByKey(linkedList, 5);
		linkedList = deleteByPosition(linkedList, 1);
		
		printList(linkedList);
	
	}

}
