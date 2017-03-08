package LinkedList;

/** Interpret a string as a formula and evaluate it.
*
* Formulas consist of a series of numbers separated by the
* operators '+' or '-'.  Formulas may  contain space characters
* between the numbers and the operators.
*
* Precondition: s is a valid formula and contain at least one number
*
* Examples: evaluate("3")             returns 3
*           evaluate("3 + 4")         returns 7
*           evaluate("100 - 25+50")   returns 125
*           evaluate("9")             returns 9
*           evaluate("   7   +   7   +    7  ") returns 21
*/
public static int evaluate(String s) {
	
	String num = "0123456789";     // all possibilities of numbers
	String op = "+-";              // all possibilities of operators
	String numStr = "";			   // numbers to extract
	String realOp = "+";           // operators to extract, initialize as +
	int result = 0;  			   // result to calculate
	char[] array_s = s.toCharArray();
	for (int i = 0 ; i < s.length() ; i++) {
		if (num.contains(s.substring(i, i+1))){  // if is numbers
			numStr = numStr + array_s[i];        // extract and compile
			if (i == s.length()-1) {             // if is the last in s
   			if (realOp.equals("+")) {
   				result = result + Integer.parseInt(numStr);
   			} 
   			else if (realOp.equals("-")){
   				result = result - Integer.parseInt(numStr);
   			}
			}
		} 
		else if (op.contains(s.substring(i, i+1))) {// if is operator
			if (realOp.equals("+")) {				// if is "+" --> add
				result = result + Integer.parseInt(numStr);
			} 
			else if (realOp.equals("-")){			// if is "-" --> deduct
				result = result - Integer.parseInt(numStr);
			}
			realOp = s.substring(i, i+1);           // update operator
			numStr = "";							// reinitialize numStr
		} 
		else if (i == s.length()-1) {            //if is blank and the last
			if (realOp.equals("+")) {
				result = result + Integer.parseInt(numStr);
			} 
			else if (realOp.equals("-")){
				result = result - Integer.parseInt(numStr);
			}
		}
	}
	return result;
}
}
