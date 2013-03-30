package datastructures.arrays;

public class HighArrayModClient {
	public static void main(String[] args) {
		HighArrayMod highArray = new HighArrayMod(10);
		
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
		System.out.println(highArray.getMax());
	}
}