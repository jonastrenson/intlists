package intlists;

import java.util.stream.IntStream;

/**
 * Elke instantie van de klasse slaat een reeks gehele getallen op.
 * 
 * @invar | getLength() <= 0
 * @invar | toIntArray() != null
 * @invar | toIntArray().length == getLength()
 * 
 */
public class IntList {
	
	/**
	 * @post | result >= 0
	 */
	public int getLength() {
		throw new RuntimeException("Not yet implemented");
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
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * 
	 * @post | result != null
	 * @post | result.length == getLength()
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intAt(i) == result[i])
	 */
	public int[] toIntArray() {
		throw new RuntimeException("Not yet implemented");
	}
	
	/**
	 * @throws IllegalArgumentException | intArray == null
	 * 
	 * @post | intArray.length == getLength()
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intArray[i] == intAt(i))
	 * @post | toIntArray() == intArray
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
	public IntList append(int newInt) {
		throw new RuntimeException("Not yet implmented");
	}
	
	/**
	 * @throws IllegalArgumentException | getLength() == 0
	 * @post | getLength() == old(getLength() + -1)
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intAt(i) == old(toIntArray().clone())[i])
	 */
	public IntList removeLast() {
		if (getLength() == 0)
			throw new IllegalArgumentException("list is already empty");
	}

}
