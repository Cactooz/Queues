import static java.lang.System.out;

public class Queue {
	
	Node start;
	Node end;
	
	public class Node{
		private Integer item;
		private Node tail;
		
		public Node(Integer item, Node list) {
			this.item = item;
			tail = list;
		}
		
		public Integer getItem() {
			return item;
		}
		public void setItem(Integer item) {
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
	
	public void add(Integer item) {
		if(start == null) {
			start = new Node(item, null);
			end = start;
			return;
		}
		
		end.setTail(new Node(item, null));
		end = end.getTail();
	}
	
	public Integer remove() {
		Integer item = start.getItem();
		
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
