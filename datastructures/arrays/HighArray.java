package datastructures.arrays;

public class HighArray {
	private long[] data;
	private int numberOfElements;
	
	public HighArray(int size) {
		data = new long[size];
		numberOfElements = 0;
	}
	
	public boolean contains(long key) {
		for (long item : data) {
			if (item == key) {
				return true;
			}
		}
		return false;
	}
	
	public synchronized void insert(long value) {
		data[numberOfElements] = value;
		numberOfElements++;
	}
	
	public synchronized boolean delete(long value) {
		if (contains(value)) {
			for (int i = 0; i < numberOfElements; i++) {
				if (data[i] == value) {
					for (int j = i; j < numberOfElements; j++) {
						data[j] = data[j + 1];
					}
					numberOfElements--;
					return true;
				}
			}
		}
		
		return false;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (long item : data) {
			sb.append(item + " ");
		}
		
		return sb.toString();
	}
}