package base;

import java.util.Iterator;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Queue<Item> implements Iterable<Item>{
	private Node first; // ָ��������ӵĽ�������
	private Node last;  // ָ�������ӵĽ�������
	private int N;  // �����е�Ԫ������
	private class Node{  // �����˽���Ƕ����
		Item item;
		Node next;
	}
	public boolean isEmpty() { return first == null; } // ��N == 0
	public int size() { return N; }
	public void enqueue(Item item) { // ���β���Ԫ��
		Node oldlast = last;
		last = new Node();
		last.item = item;
		last.next = null;
		if(isEmpty()) first = last;
		else oldlast.next = last;
		N++;
	}
	public Item dequeue() {  // �ӱ�ͷɾ��Ԫ��
		Item item = first.item;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return item;
	}
	public Iterator<Item> iterator()  {
        return new ListIterator();  
    }

    private class ListIterator implements Iterator<Item> {
        private Node current = first;

        public boolean hasNext()  { return current != null;                     }
        public void remove()      {  }

        public Item next() {
            Item item = current.item;
            current = current.next; 
            return item;
        }
    }
	public static void main(String[] args) { 
		// ����һ�����в������ַ�����ӻ����
		Queue<String> q = new Queue<String>();
		while(!StdIn.isEmpty()) { 
			String item = StdIn.readString();
			if(!item.equals("-"))
				q.enqueue(item);
			else if(!q.isEmpty()) StdOut.print(q.dequeue() + " ");
		}
		StdOut.println("(" + q.size() + " left on queue)");
	}

}
