package intlists;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IntListTest {
	
	IntList L = IntList.emptyList();

	@Test
	void testConstructor() {
		assertEquals(L.getLength(),0);
		Arrays.equals(L.toIntArray(), new int[] {});
	}
	
	@Test
	void testAppend() {
		L.append(1);
		L.append(2);
		L.append(3);
		
		assertEquals(L.intAt(0), 1);
		assertEquals(L.intAt(1), 2);
		assertEquals(L.intAt(2), 3);
		assertEquals(L.getLength(), 3);
		Arrays.equals(L.toIntArray(), new int[] {1,2,3});
		
		// Test op representation exposure
		int getal = 9;
		L.append(getal);
		assertEquals(L.intAt(3), 9);
		getal = 8;
		assertEquals(L.intAt(3), 9);
		
		
	}
	
	@Test
	void testRemoveLast() {
		L.append(1);
		L.append(2);
		L.append(3);
		L.removeLast();
		L.removeLast();
		
		assertEquals(L.intAt(0), 1);
		assertEquals(L.getLength(), 1);
		Arrays.equals(L.toIntArray(), new int[] {1});
	}

}
