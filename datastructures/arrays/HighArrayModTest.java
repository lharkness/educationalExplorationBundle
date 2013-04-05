package datastructures.arrays;

import org.junit.Test;
import org.junit.Before;
import junit.framework.TestSuite;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class HighArrayModTest {
	
	private HighArrayMod target;
	
	@Before
	public void setup() {
		target = new HighArrayMod(10);
		target.insert(1);
		target.insert(100);
		target.insert(5);
		target.insert(8);
		target.insert(101);
	}
	
	@Test
	public void testThatContainsReturnsFalseOnEmptyArray() {
		HighArrayMod target = new HighArrayMod(10);
		
		assertTrue(!target.contains(42));
	}
	
	@Test
	public void testThatContainsReturnsFalseWhenArrayDoesNotContainTargetValue() {
		assertTrue(!target.contains(42));	
	}
	
	@Test
	public void testThatContainsReturnsTrueWhenArrayDoesContainTargetValue() {		
		assertTrue(target.contains(8));	
	}
	
	@Test
	public void testThatFindReturnsNegativeOneOnEmptyArray() {
		HighArrayMod target = new HighArrayMod(10);
		
		assertTrue(target.find(42) == -1);
	}
	
	@Test
	public void testThatFindReturnsNegativeOneWhenArrayDoesNotContainTargetValue() {
		assertTrue(target.find(42) == -1);	
	}
	
	@Test
	public void testThatFindReturnsCorrectValueWhenArrayDoesContainTargetValue() {		
		assertTrue(target.find(8) != -1);	
	}
	
	@Test
	public void testThatInsertInsertsValue() {
		assertTrue(!target.contains(42));
		target.insert(42);
		assertTrue(target.contains(42));
	}
	
	@Test
	public void testThatDeleteDeletesValue() {
		target.insert(42);
		assertTrue(target.contains(42));
		target.delete(42);
		assertTrue(!target.contains(42));
	}
	
	@Test
	public void testThatGetMaxReturnsNegativeOneForEmptyArray() {
		HighArrayMod target = new HighArrayMod(10);
		
		assertTrue(target.getMax() == -1);
	}
	
	@Test
	public void testThatGetMaxReturnsMaxValue() {
		HighArrayMod target = new HighArrayMod(10);
		target.insert(1);
		target.insert(100);
		target.insert(5);
		target.insert(8);
		target.insert(101);
		
		assertTrue(target.getMax() == 101);
	}
	
	@Test
	public void testThatRemoveMaxRemovesMax() {
		HighArrayMod target = new HighArrayMod(10);
		target.insert(1);
		target.insert(100);
		target.insert(5);
		target.insert(8);
		target.insert(101);
		
		target.removeMax();
		
		assertTrue(!target.contains(101));
	}
	
	@Test
	public void testThatCopyConstructorWorkdAsExpected() {
		HighArrayMod original = new HighArrayMod(target);
		
		for (int i = 0; i < target.size(); i++) {
			assertTrue(original.get(i) == target.get(i));
		}
	}
	
	
	@Test
	public void testThatRemoveDupsWorksWithAnArrayWithNoDups() {
		HighArrayMod original = new HighArrayMod(target);
		target.removeDups();
		
		for (int i = 0; i < target.size(); i++) {
			assertTrue(original.get(i) == target.get(i));
		}
	}
	
	@Test
	public void testThatRemoveDupsDoesInFactRemoveDups() {
		HighArrayMod arrayWithDups = new HighArrayMod(11);
		arrayWithDups.insert(1);
		arrayWithDups.insert(2);
		arrayWithDups.insert(1);
		arrayWithDups.insert(3);
		arrayWithDups.insert(4);
		arrayWithDups.insert(5);
		arrayWithDups.insert(3);
		arrayWithDups.insert(4);
		arrayWithDups.insert(5);
		arrayWithDups.insert(1);
		
		arrayWithDups.removeDups();
		
		System.out.println(arrayWithDups.size());
		System.out.println(arrayWithDups);
		
		assertTrue(arrayWithDups.size() == 5);
		
	}
	
	
}