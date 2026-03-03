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
	
	/**
	 * @representationObject
	 * @invar | intA != null
	 */
	private int[] intA;
	
	/**
	 * @post | result >= 0
	 */
	public int getLength() {
		return intA.length;
	}
	
	/**
	 * @throws IllegalArgumentException
	 *  | 0 > index || index > getLength()
	 */
	public int intAt(int index) {
		if (getLength() == 0)
			throw new IllegalArgumentException("`getLength()` is equal to zero");
		if (0 > index || index >= getLength())
			throw new IllegalArgumentException("`index` is not in range");
		return intA[index];
	}
	
	/**
	 * 
	 * @post | result != null
	 * @post | result.length == getLength()
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intAt(i) == result[i])
	 */
	public int[] toIntArray() {
		return intA.clone();
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
		this.intA = intArray.clone();
	}
	
	/**
	 * @post | result.getLength() == 0
	 */
	static IntList emptyList() {
		return new IntList(new int[] {});
	}
	
	/**
	 * @mutates | this
	 * @post | getLength() == old(getLength() + 1)
	 * @post | intAt(getLength() - 1) == newInt
	 * @post | IntStream.range(0, old(getLength())).allMatch(i -> intAt(i) == old(toIntArray().clone())[i])
	 */
	public void append(int newInt) {
		int[] result = new int[getLength()+1];
		System.arraycopy(intA, 0, result, 0, getLength());
		result[result.length-1] = newInt;
		intA = result;
	}
	
	/**
	 * @throws IllegalArgumentException | getLength() == 0
	 * @mutates | this
	 * @post | getLength() == old(getLength() + -1)
	 * @post | IntStream.range(0, getLength()).allMatch(i -> intAt(i) == old(toIntArray().clone())[i])
	 */
	public void removeLast() {
		if (getLength() == 0)
			throw new IllegalArgumentException("list is already empty");
		int[] result = new int[getLength()-1];
		System.arraycopy(intA, 0, result, 0, getLength()-1);
		intA = result;

	}

}
