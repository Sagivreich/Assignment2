import java.util.ArrayList;

/**
 *  Interface for a Queue data structure
 * @author sagiv
 *
 * @param <T>
 */
public class NotationQueue<T> implements QueueInterface<T> {


	private ArrayList<T> queue;
	private int points;

	NotationQueue() {
		queue = new ArrayList<>();
		points = 10;
	}

	NotationQueue(int points) {
		queue = new ArrayList<>(points);
		this.points = points;
	}

	/**
	 * Determines if Queue is empty
	 * @return true if Queue is empty, false if not
	 */
	@Override
	public boolean isEmpty() {
		if (queue.isEmpty()) {
			return true;
		}
		return false;
	}

	/**
	 * Determines of the Queue is full
	 * @return
	 */
	@Override
	public boolean isFull() {

		if (queue.size() == points) {
			return true;
		}
		return false;
	}

	
	/**
	 * Deletes and returns the element at the front of the Queue
	 * @return the element at the front of the Queue
	 */
	@Override
	public T dequeue() throws QueueUnderflowException {

		if (isEmpty()) {
			throw new QueueUnderflowException();
		}

		T next = queue.get(0);
		queue.remove(0);
		queue.trimToSize();

		return next;
	}
	/**
	 * Number of elements in the Queue
	 * @return the number of elements in the Queue
	 */
	@Override
	public int size() {

		return queue.size();
	}
	/**
	 * Adds an element to the end of the Queue
	 * @param e the element to add to the end of the Queue
	 * @return true if the add was successful, false if not
	 */
	@Override
	public boolean enqueue(T e) throws QueueOverflowException {

		if (queue.size() == points) {
			throw new QueueOverflowException();
		}

		queue.add(e);
		return true;
	}
	/**
	 * Returns the string representation of the elements in the Queue, 
	 * the beginning of the string is the front of the queue
	 * @return string representation of the Queue with elements
	 */
	@Override
	public String toString() {
		String s = "";
		
		for(T item: queue) {
			s += item.toString(); 
		}
		return s;
	}

	/**
	 * Returns the string representation of the elements in the Queue, the beginning of the string is the front of the queue
	 * Place the delimiter between all elements of the Queue
	 * @return string representation of the Queue with elements separated with the delimiter
	 */
	@Override
	public String toString(String delimiter) {
		String s = "";
		
		for(T item: queue) {
			s += item.toString();
			s += delimiter;
		}
		
		s = s.substring(0,s.length()-1);
		
		return s;
	}

	 /**
	  * Fills the Queue with the elements of the ArrayList, First element in the ArrayList
	  * is the first element in the Queue
	  * @param list elements to be added to the Queue
	  */
	@Override
	public void fill(ArrayList<T> list) {
		
		queue.clear();
		
		for (T item : list) {
			queue.add(item);
		}

	}

}