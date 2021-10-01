/**
 *  This class throws an exception to the method StackUnderflowException
 * @author sagiv
 *
 */
public class StackUnderflowException extends Exception {


/**
 * this exception will constract an excetion 	
 */
	StackUnderflowException(){
		super("Stack is empty");
	}
}