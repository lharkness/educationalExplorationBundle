package datastructures.arrays;

import org.junit.Test;
import org.junit.Before;
import junit.framework.TestSuite;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class OrderedArrayTest {
	
	private OrderedArray target;
	
	@Before
	public void setup() {
		target = new OrderedArray(10);
		target.insert(1);
		target.insert(100);
		target.insert(5);
		target.insert(8);
		target.insert(101);
	}
	
	@Test
	public void testThatContainsReturnsFalseOnEmptyArray() {
		OrderedArray target = new OrderedArray(10);
		
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
	public void testThatFindReturnsZeroOnEmptyArray() {
		OrderedArray target = new OrderedArray(10);
		
		assertTrue(target.find(42) == 0);
	}
	
	@Test
	public void testThatFindReturnsNegativeValueWhenArrayDoesNotContainTargetValue() {
		
		assertTrue(target.find(42) < 0);	
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
	public void testThatMergeWorksAsExpected() {
		OrderedArray thisArray = new OrderedArray(10);
		thisArray.insert(1);
		thisArray.insert(3);
		thisArray.insert(8);
		thisArray.insert(10);
		thisArray.insert(12);
		
		OrderedArray otherArray = new OrderedArray(10);
		otherArray.insert(4);
		otherArray.insert(6);
		otherArray.insert(7);
		otherArray.insert(9);
		
		OrderedArray mergedArray = thisArray.merge(otherArray);
		
		assertTrue(mergedArray.size() == thisArray.size() + otherArray.size());
		
		assertTrue(mergedArray.get(0) == 1);
		assertTrue(mergedArray.get(2) == 4);
		assertTrue(mergedArray.get(5) == 8);
		assertTrue(mergedArray.get(8) == 12);
	}
	
}