package datastructures.arrays;

public class CrudeArraySorter {
	public static void main(String[] args) {
		HighArrayMod highArray = new HighArrayMod(10);
		
		highArray.insert(2);
		highArray.insert(5);
		highArray.insert(10);
		highArray.insert(1);
		highArray.insert(200);
		highArray.insert(3);
		highArray.insert(-1);
		
		HighArrayMod sortedArray = new HighArrayMod(10);

		for (int i = 0; i < highArray.size(); i++) {
			sortedArray.insert(highArray.getMax());
			highArray.removeMax();
		}
		
		System.out.println(sortedArray);
		
	}
}