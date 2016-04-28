package Stack;

import java.util.Stack;
public class ValidParentheses {

	public static boolean isValid(String s){
		String tokens1 = "([{";
		String tokens2 = ")]}";
		Stack<Character>  brackets = new Stack<Character>();
		for(int i=0; i<s.length(); i++){
			if(brackets.empty()) 
				brackets.push(s.charAt(i));
			
			else{
				int index = tokens2.indexOf(s.charAt(i));
				
				if( index>=0 && tokens1.charAt(index)==brackets.peek())
					brackets.pop();
				else
					brackets.push(s.charAt(i));
			}
		}
		
		return brackets.empty();	
	}
	
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = "()[]{()}";
		System.out.println(isValid(s));
	}

}
