/**
 *   This class throws an exception to the method StackOverflowException
 * @author sagiv
 *
 */
public class StackOverflowException extends Exception {
	

/**
 * this exception will constract an excetion 	
 */	
	StackOverflowException(){
		super("Stack is full.");
	}
}