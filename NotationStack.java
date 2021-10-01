import java.util.ArrayList;
/** Interface for a generic Stack data structure
 * 
 * @author sagiv
 *
 * @param <T>
 */
public class NotationStack<T> implements StackInterface<T>{

	private ArrayList<T> stack;
	private int point; 
	
	public NotationStack() {

		stack = new ArrayList<>();
		point = 10;
	}
	
	public NotationStack(int point) {

		stack = new ArrayList<>(point);
		this.point = point;

	}
	/**
	 * Determines if Stack is empty
	 * @return true if Stack is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		
		if (stack.isEmpty()) {
			return true;
		}
		
		return false;
	}
	
	/**
	 * Determines if Stack is full
	 * @return true if Stack is full, false if not
	 */
	@Override
	public boolean isFull() {
		if (stack.size() == point) {
			return true;
		}
		return false;
	}

	/**
	 * Returns the element at the top of the Stack, does not pop it off the Stack
	 * @return the element at the top of the Stack
	 */
	@Override
	public T pop() throws StackUnderflowException {
		if(stack.size() == 0) {
			throw new StackUnderflowException();
		}

		T top = stack.get(stack.size() - 1);
		stack.remove(stack.size() - 1);
		return top;
	}
	
	/**
	 * Number of elements in the Stack
	 * @return the number of elements in the Stack
	 */
	@Override
	public T top() throws StackUnderflowException{
		if (stack.size() == 0) {
			throw new StackUnderflowException();
		}
		return stack.get(stack.size()-1);
	}

	@Override
	public int size() {
		return stack.size();
	}

	/**
	 * Adds an element to the top of the Stack
	 * @param e the element to add to the top of the Stack
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean push(T item) throws StackOverflowException {
		if (stack.size() == point) {
			throw new StackOverflowException();
		}
		
		stack.add(item);
		
		return true;
	}
	
	/**
	 * Returns the elements of the Stack in a string from bottom to top, the beginning 
	 * of the String is the bottom of the stack
	 * @return an string which represent the Objects in the Stack from bottom to top
	 */
	@Override
	public String toString() {
	String s = "";
		
		for(T item: stack) {
			s += item.toString(); 
		}
		return s;
		
	}
	
	/**
	 * Returns the string representation of the elements in the Stack, the beginning of the 
	 * string is the bottom of the stack
	 * Place the delimiter between all elements of the Stack
	 * @return string representation of the Stack from bottom to top with elements 
	 * separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String s = "";
		
		for(T item: stack) {
			s += item.toString();
			s += delimiter;
		}
		
		s = s.substring(0,s.length()-1);
		
		return s;
	}
	
	 /**
	  * Fills the Stack with the elements of the ArrayList, First element in the ArrayList
	  * is the first bottom element of the Stack
	  * YOU MUST MAKE A COPY OF LIST AND ADD THOSE ELEMENTS TO THE STACK, if you use the
	  * list reference within your Stack, you will be allowing direct access to the data of
	  * your Stack causing a possible security breech.
	  * @param list elements to be added to the Stack from bottom to top
	  */
	@Override
	public void fill(ArrayList<T> list) {
		
		stack.clear();

		for (T item : list) {
		
			stack.add(item);
		}

		
	}




}