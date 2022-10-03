public class Main {
	public static void main(String[] args) {
		Queue queue = new Queue();
		queue.add(1);
		queue.add(2);
		queue.add(3);
		queue.add(4);
		queue.add(5);
		queue.print();
		
		queue.remove();
		queue.print();
		
		queue.remove();
		queue.remove();
		queue.remove();
		queue.remove();
		queue.print();
	}
}
