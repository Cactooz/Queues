import java.util.Arrays;
import static java.lang.System.out;

public class ArrayQueue {
	private final int length;
	private int first, last;
	private Integer[] array;
	
	public ArrayQueue(Integer length) {
		this.length = length;
		array = new Integer[length];
		first = 0;
		last = 0;
	}
	
	public void add(int value) {
		if(last == first && array[first] != null)
			throw new ArrayStoreException("The array is full");
			
		if(last == length) {
			if(first == 0 && array[first] != null)
				throw new ArrayStoreException("The array is full");
			last = 0;
		}
		array[last++] = value;
	}
	
	public Integer remove() {
		if(first == last)
			return null;
		
		Integer value;
		
		if(first == length - 1) {
			value = array[first];
			array[first] = null;
			first = 0;
		} else {
			value  = array[first];
			array[first++] = null;
		}
		return value;
	}
	
	public void print() {
		out.println(Arrays.toString(array));
	}
	
}
