package datastructures.arrays;

public class HighArrayClient {
	public static void main(String[] args) {
		HighArray highArray = new HighArray(10);
		
		highArray.insert(2);
		highArray.insert(5);
		highArray.insert(10);
		highArray.insert(1);
		highArray.insert(200);
		highArray.insert(3);
		highArray.insert(-1);
		
		System.out.println(highArray);
		System.out.println("Array contains 2? " + highArray.contains(2));
		highArray.delete(2);
		System.out.println("Array contains 2? " + highArray.contains(2));
		System.out.println(highArray);
		
	}
}