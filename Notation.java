/**
 * Notation class is implemented to convert infix to postfix and other way round and evaluate invalid exceptions
 * @author sagiv
 *
 */
public class Notation {
	/**
	 * Converts infix to postfix expressions
	 * @param infix is a String, String to be converted to postfix
	 * @return String, the postfix expression
	 * @throws InvalidNotationFormatException
	 */
	public static String convertInfixToPostfix(String infix) throws InvalidNotationFormatException {

		NotationQueue<Character> queue = new NotationQueue<>(infix.length());
		NotationStack<Character> stack = new NotationStack<>(infix.length());
		char[] str = infix.toCharArray();

		try {
			for (char current : str) {
				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					queue.enqueue(current);
					continue;
				}
				if (current == '(') {
					stack.push(current);
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (!queue.isEmpty()) {
						char top = stack.top();
						if (top == '*' || top == '/' || current == '-' && top == '-' || current == '-' && top == '+'
								|| current == '+' && top == '-' || current == '+' && top == '+') {
							queue.enqueue(stack.pop());

						}
					}
					stack.push(current);
					continue;
				}
				if (current == ')') {
					while (stack.top() != '(') {
						queue.enqueue(stack.pop());
						if (stack.top() == null) {
							throw new InvalidNotationFormatException();
						}
					}
					stack.pop();
				}

			}
		} catch (QueueOverflowException | StackOverflowException | StackUnderflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		return queue.toString();

	}
	/**
	 * 
	 * @param postfix -  this method will convert postfix to infix.
	 * @return String - return a string of valid or invalid exception of infix  .
	 * @throws InvalidNotationFormatException
	 */
	public static String convertPostfixToInfix(String postfix) throws InvalidNotationFormatException {

		NotationStack<String> stack = new NotationStack<>(postfix.length());

		try {
			for (int i = 0; i < postfix.length(); i++) {
				char current = postfix.charAt(i);

				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current)) {
					stack.push(Character.toString(current));
					continue;
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					String first = stack.pop();
					String second = stack.pop();
					String s = "(" + second + current + first + ")";
					stack.push(s);

				}
			}

		} catch (StackUnderflowException | StackOverflowException ignore) {
			throw new InvalidNotationFormatException();
		}
		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}
		return stack.toString();
	}
	
	/**
	 * 
	 * The method will evaluate postfix expression and will tell the program if it valid or not.
	 * 
	 * @param postfixExpr - postfix is an expression to be evaluated
	 * @return double - it will return a double data type 
	 * @throws InvalidNotationFormatException 
	 * 
	 */
	public static double evaluatePostfixExpression(String postfixExpr) throws InvalidNotationFormatException {

		NotationStack<Double> stack = new NotationStack<>(postfixExpr.length());
		char[] str = postfixExpr.toCharArray();

		try {
			for (char current : str) {
				if (current == ' ') {
					continue;
				}
				if (Character.isDigit(current) || current == '(') {
					stack.push(Double.parseDouble(Character.toString(current)));
					continue;
				}
				if (current == '*' || current == '/' || current == '+' || current == '-') {
					if (stack.size() < 2) {
						throw new InvalidNotationFormatException();
					}
					double right = stack.pop();
					double left = stack.pop();

					switch (current) {
					case '*':
						stack.push(left * right);
						break;
					case '/':
						stack.push(left / right);
						break;
					case '+':
						stack.push(left + right);
						break;
					case '-':
						stack.push(left - right);
					}

				}

			}

		} catch (StackOverflowException | StackUnderflowException ignore) {
			throw new InvalidNotationFormatException();
		}

		if (stack.size() > 1) {
			throw new InvalidNotationFormatException();
		}

		return Double.parseDouble(stack.toString());

	}
	/**
	 * 
	 * @param infixExpr  - infxExpr is an expression to be evaluated
	 * @return double - it will return a double data type 
	 * @throws InvalidNotationFormatException
	 */
	public static double evaluateInfixExpression(String infixExpr) throws InvalidNotationFormatException {
		return evaluatePostfixExpression(convertInfixToPostfix(infixExpr));
	}

}