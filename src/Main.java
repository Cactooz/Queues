public class Main {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(20);
		for (int i = 0; i < 15; i++) {
			queue.add(i);
		}
		
		queue.print();
		
		for (int i = 0; i < 10; i++) {
			queue.remove();
		}
		
		queue.print();
		
		for (int i = 15; i < 40; i++) {
			queue.add(i);
		}
		
		queue.print();
		
	}
}
