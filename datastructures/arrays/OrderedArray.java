package datastructures.arrays;

public class OrderedArray {
	private long[] data;
	private int numberOfElements;
	
	public OrderedArray(int size) {
		data = new long[size];
		numberOfElements = 0;
	}
	
	public int size() {
		return numberOfElements;
	}
	
	/**
	 *  Following code is from java source
	 */
	public int find(long key) {
		
	    int low = 0;
	    int high = numberOfElements - 1;

	    while (low <= high) {
	        int mid = (low + high) >>> 1;
	        long midVal = data[mid];

	        if (midVal < key)
	            low = mid + 1;
	        else if (midVal > key)
	            high = mid - 1;
	        else
	            return mid; // key found
	    }
		// key not found
		return -(low);

	}
	
	public boolean contains(long target) {
		return (find(target) > 0);
	}

	public synchronized void insert(long value) {
		// assume array does not contain value
		int insertionPoint = -(find(value));
		for (int i = numberOfElements; i > insertionPoint; i--) {
			data[i] = data[i - 1];
		}
		data[insertionPoint] = value;
		numberOfElements++;
	}
	
	public synchronized boolean delete(long value) {
		int foundIndex = find(value);
		if (foundIndex > 0) {
			for (int j = foundIndex; j < numberOfElements; j++) {
				data[j] = data[j + 1];
			}
			numberOfElements--;
				return true;
		}
			
		return false;
	}
	
	public long get(int index) {
		return data[index];
	}
	
	public OrderedArray merge(OrderedArray otherArray) {
		OrderedArray mergedArray = new OrderedArray(this.size() + otherArray.size());
		int thisArrayPos = 0;
		int otherArrayPos = 0;
		while (thisArrayPos < this.size() && otherArrayPos < otherArray.size()) {
			if (this.get(thisArrayPos) < otherArray.get(otherArrayPos)) {
				mergedArray.data[mergedArray.numberOfElements] = this.get(thisArrayPos);
				mergedArray.numberOfElements++;
				thisArrayPos++;	
			}
			else {
				mergedArray.data[mergedArray.numberOfElements] = otherArray.get(otherArrayPos);
				mergedArray.numberOfElements++;
				otherArrayPos++;
			}
		}
		
		if (thisArrayPos < this.size()) {
			for (int i = thisArrayPos; i < this.size(); i++) {
				mergedArray.data[mergedArray.numberOfElements] = this.get(i);
				mergedArray.numberOfElements++;
			}
		}
		if (otherArrayPos < otherArray.size()) {
			for (int i = otherArrayPos; i < otherArray.size(); i++) {
				mergedArray.data[mergedArray.numberOfElements] = otherArray.get(i);
				mergedArray.numberOfElements++;
			}
		}
		
		return mergedArray;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		for (long item : data) {
			sb.append(item + " ");
		}
		
		return sb.toString();
	}
	
	public static void main(String[] args) {
		System.out.println("***");
		OrderedArray target = new OrderedArray(10);
		System.out.println(target.find(1));
		target.insert(1);
		System.out.println(target);
		System.out.println(target.find(8));
		target.insert(8);
		System.out.println(target);
		System.out.println(target.find(5));
		target.insert(5);
		System.out.println(target);
	}
}