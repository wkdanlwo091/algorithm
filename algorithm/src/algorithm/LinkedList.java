package algorithm;

public class LinkedList {
	Node head;//��ũ�� ����Ʈ�� ��� 
	static class Node{//inner class 
		//inner class�� default�� static �̴�. 
		int data;//����� ������
		Node next;//���� ��带 ����Ű�� ����
		Node(int d){
			data = d;
			next = null;
		}
	}
	public static LinkedList insert(LinkedList list, int data) {
		Node new_node = new Node(data);// ���ο� ��� �Ҵ� 
		new_node.next = null;// ���� ���� �ϴ� null 
		
		if(list.head == null)//head�� empty �� �� ���ο� node�� head�� �Ҵ��Ѵ�. 
		{
			list.head = new_node;
		}else {//head�� ������ ������ ������ traverse �Ѵ�. �� �� ������ ����� next�� new_node�� �Ҵ��Ѵ�. 
			Node last = list.head;//node last�� list.head �� ù��° ��带 ����Ų��. 
			while(last.next != null) {
				last = last.next;//last�� ���� ���� �Ѿ��. 
			}
			last.next = new_node;//������ ����� next�� new_node�� �Ҵ��Ѵ�. 
		}
		return list;	
	}
	
	public static void printList(LinkedList list) {
		Node currNode = list.head;//���� ���� ��ũ�帮��Ʈ�� ��� �� ù��° �� 
		System.out.println("LinkedList : ");
		
		while(currNode != null) {
			System.out.println(currNode.data + "");
			currNode = currNode.next;
		}
	}
	public static LinkedList deleteByKey(LinkedList list, int key) {
		Node currNode = list.head;
		Node prev = null;
		//Ű ���� ��忡 ���� ��
		if(currNode.data == key) {
			list.head = currNode.next;//��带 �������� �������� �ű��. 
			return list;
		}
		
		//Ű���� ��尡 �ƴ� ���� ���� ��
		while(currNode != null && currNode.data != key) {
			prev = currNode;
			currNode = currNode.next;
		}
		//Ű���� ���� �� 
		
		if(currNode != null) {//garbage collector�� unreferenced�� �޸𸮸� �����Ѵ�. 
			System.out.println("found key and deleted");
			prev.next = currNode.next;
		}
	
		//Ű���� ���� �� 
		
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