package Stack;

import java.util.Stack;
public class EvaluateRPN {

    public static int evalRPN(String[] tokens) {
    	Stack<Integer> operands = new Stack<Integer>() ;
    
    	for(int i=0; i<tokens.length; i++){
    		if(tokens[i].equals("+")){
    			int a = operands.pop();
    			int b = operands.pop();
    			operands.push(a+b);
    		}else if(tokens[i].equals("-")){
        			int a = operands.pop();
        			int b = operands.pop();
        			operands.push(b-a);
    		}else if(tokens[i].equals("*")){
    			int a = operands.pop();
    			int b = operands.pop();
    			operands.push(b*a);
		   }else if(tokens[i].equals("/")){
   		    	int a = operands.pop();
   		    	int b = operands.pop();
   		    	operands.push((int)(b/a));
		   }else{
			   operands.push(Integer.parseInt(tokens[i]));
		   }
    	}
    	
    	return operands.peek();
        
    }
    
    
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] rpn = {"4", "13", "5", "/", "+"};
		
		System.out.println(evalRPN(rpn));
	}

}
