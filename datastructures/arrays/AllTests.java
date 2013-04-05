package datastructures.arrays;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

public class AllTests {
	public static void main(String args[]) {
		org.junit.runner.JUnitCore.main(HighArrayModTest.class.getName(), OrderedArrayTest.class.getName());
	}
}