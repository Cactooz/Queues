public class Queue {
	
	Node head;
	
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
	
	
	
}
