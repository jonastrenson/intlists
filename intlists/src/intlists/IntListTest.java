package intlists;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class IntListTest {
	
	IntList L = IntList.emptyList();

	@Test
	void testConstructor() {
		assertEquals(L.getLength(),0);
		assertArrayEquals(L.toIntArray(), new int[] {});
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
		assertArrayEquals(L.toIntArray(), new int[] {1,2,3});
		
		// Test op representation exposure
		L.append(10);
		int[] myElementen = L.toIntArray();
		myElementen[0] = 100;
		assertEquals(10, L.intAt(0));
		
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
		assertArrayEquals(L.toIntArray(), new int[] {1});
	}

}
