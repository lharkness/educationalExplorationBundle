package datastructures.arrays;

public class HighArrayMod {
	private long[] data;
	private int numberOfElements;
	
	public HighArrayMod(int size) {
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
	
	public int find(long key) {
		
		for (int i = 0; i < data.length; i++) {
			if (data[i] == key) {
				return i;
			}
		}
		return -1;
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
	
	public long getMax() {
		if (numberOfElements < 1) {
			return -1;
		}
		
		// This is an unsorted array, so brute force is our only option
		long highest = Long.MIN_VALUE;
		for (long item : data) {
			if (item > highest) {
				highest = item;
			}
		}
		
		return highest;
	}

	public void removeMax() {
		long maxValue = getMax();
		delete(maxValue);
	}
	
	public int size() {
		return numberOfElements;
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