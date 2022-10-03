import static java.lang.System.out;

public class Queue {
	
	Node start;
	Node end;
	
	public class Node{
		private BinaryTree.Node item;
		private Node tail;
		
		public Node(BinaryTree.Node item, Node list) {
			this.item = item;
			tail = list;
		}
		
		public BinaryTree.Node getItem() {
			return item;
		}
		public void setItem(BinaryTree.Node item) {
			this.item = item;
		}
		public Node getTail() {
			return tail;
		}
		public void setTail(Node tail) {
			this.tail = tail;
		}
	}
	
	public Queue() {
		start = null;
		end =  null;
	}
	
	public void add(BinaryTree.Node item) {
		if(start == null) {
			start = new Node(item, null);
			end = start;
			return;
		}
		
		end.setTail(new Node(item, null));
		end = end.getTail();
	}
	
	public BinaryTree.Node remove() {
		BinaryTree.Node item = start.getItem();
		
		start = start.getTail();
		
		return item;
	}
	
	public void print() {
		if(start == null)
			out.println("Empty queue");
		else {
			out.print("{ ");
			out.print(start.getItem());
			
			Node pointer = start;
			
			while(pointer.getTail() != null) {
				pointer = pointer.getTail();
				out.print(", " + pointer.getItem());
			}
			
			out.println(" }");
		}
	}
	
}
