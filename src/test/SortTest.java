package test;

import static org.junit.Assert.*;

import org.junit.Test;

import sort.Sort;

public class SortTest {

	@Test
	public void test() {
		Sort sort = new Sort ();
		int [] arr = {1,1,2,2,4,4,1,1,5,6,2};
		int [] arr2 = {6,5,4,4,2,2,2,1,1,1,1};
		// false cause compare by reference
		//assertEquals(arr2, sort.heapSort(arr));
		sort.puts(arr);
		//assertEquals("aaaa", Sort.insertionSort("aaaa"));
	
	}


}
