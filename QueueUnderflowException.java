/**
 * This class throws an exception to the method QueueUnderflowException
 * 
 * @author sagiv
 * 
 *
 */


public class QueueUnderflowException extends Exception {

/**
 * this exception will constract an excetion 	
 */
	QueueUnderflowException(){
		super("Queue is empty.");
	}
}