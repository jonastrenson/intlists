package intlists;

import java.util.Arrays;
import java.util.stream.IntStream;

/**
 * Elke instantie van de klasse slaat een reeks gehele getallen op.
 * 
 * @invar | getLength() >= 0
 * @invar | toIntArray() != null
 * @invar | toIntArray().length == getLength()
 * 
 */
public class IntList {
	
	
	private Node head;
	
	/**
	 * @post | result >= 0
	 */
	public int getLength() {
		if (head == null)
			return 0;
		int i = 1;
		Node current = head;
		while (current.next != null) {
			i++;
			current = current.next;
		}
		return i;
	}
	
	/**
	 * @throws IllegalArgumentException
	 *  | 0 > index || index > getLength()
	 * 
	 */
	public int intAt(int index) {
		if (getLength() == 0)
			throw new IllegalArgumentException("IntList is empty");
		if (0 > index || index > getLength())
			throw new IllegalArgumentException("`index` is not in range");
		Node current = head;
		int i = 0;
		while (current.next != null) {
			if (i == index)
				return current.value;
			i++;
			current = current.next;
		}
		return current.value;
	}
	
	/**
	 * 
	 * @post | result != null
	 * @post | result.length == getLength()
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intAt(i) == result[i])
	 */
	public int[] toIntArray() {
		int[] result = new int[getLength()];
		Node current = head;
		for (int i = 0; i < getLength(); i++) {
			result[i] = current.value;
			current = current.next;
		}
		return result;
	}
	
	/**
	 * @throws IllegalArgumentException | intArray == null
	 * 
	 * @post | intArray.length == getLength()
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intArray[i] == intAt(i))
	 * @post | Arrays.equals(toIntArray(), intArray)
	 */
	private IntList(int[] intArray) {
		if (intArray == null)
			throw new IllegalArgumentException("`intArray` is null");
	}
	
	/**
	 * @post | result.getLength() == 0
	 */
	static IntList emptyList() {
		return new IntList(new int[] {});
	}
	
	/**
	 * @post | getLength() == old(getLength() + 1)
	 * @post | intAt(getLength() - 1) == newInt
	 * @post | IntStream.range(0, old(getLength())).allMatch(i -> intAt(i) == old(toIntArray().clone())[i])
	 * 
	 */
	public void append(int newInt) {
		if (head == null) {
			head = new Node(newInt, null);
		}
		else {
			Node current = head;
			while (current.next != null) {
				current = current.next;
			}
			current.next = new Node(newInt, null);
		}
	}
	
	/**
	 * @throws IllegalArgumentException | getLength() == 0
	 * @post | getLength() == old(getLength()) - 1
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intAt(i) == old(toIntArray().clone())[i])
	 */
	public void removeLast() {
		if (getLength() == 0)
			throw new IllegalArgumentException("list is already empty");
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		current.next = null;
	}

}
