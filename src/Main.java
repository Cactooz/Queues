import static java.lang.System.out;

public class Main {
	public static void main(String[] args) {
		ArrayQueue queue = new ArrayQueue(20);
		for (int i = 0; i < 20; i++) {
			queue.add(i);
		}
		queue.print();
		
		for (int i = 0; i < 20; i++) {
			queue.remove();
		}
		
		queue.print();
		
		queue.add(20);
		queue.add(21);
		queue.add(22);
		queue.add(23);
		queue.add(24);
		
		out.println(queue.remove());
		out.println(queue.remove());
		out.println(queue.remove());
		
		queue.add(25);
		queue.add(26);
		
		queue.print();
		
	}
}
