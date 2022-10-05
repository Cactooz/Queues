import java.util.Arrays;
import static java.lang.System.out;

public class ArrayQueue {
	private int length;
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
			expandArray();
			
		if(last == length) {
			if(first == 0 && array[first] != null)
				expandArray();
			else
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
	
	private void expandArray() {
		Integer[] newArray = new Integer[length*2];
		
		for(int i = 0; i < length; i++) {
			newArray[i] = array[first++];
			if(first == length)
				first = 0;
		}
		
		array = newArray;
		first = 0;
		last = length;
		length *= 2;
	}
	
	public void print() {
		out.println(Arrays.toString(array));
	}
	
}
