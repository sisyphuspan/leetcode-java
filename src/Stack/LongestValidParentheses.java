package Stack;

import java.util.Stack;
public class LongestValidParentheses {

	public static int longestValidParentheses(String s){
		Stack<Integer> lefts = new Stack<Integer>();
		int lastRight = -1;
		int maxlen = 0;
		
		for(int i=0; i<s.length(); i++){
			if(s.charAt(i) == '(')
				lefts.push(i);
			else{   // right bracket
				if(lefts.empty())  // no left bracket matches for this right bracket
					lastRight = i;
				else{
					lefts.pop();
					if(lefts.empty())  // i��lastRight֮���ǺϷ��Ĳ���
						maxlen = (maxlen >= i-lastRight) ? maxlen : i-lastRight;
					else   //  i��ջ������������֮���ǺϷ��Ĳ���
						maxlen = (maxlen >= i-lefts.peek()) ? maxlen : i-lefts.peek();			
				}		
			}
		}
		
		return maxlen;
		
	}
	
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String s = ")()()((()()())";
		System.out.println(longestValidParentheses(s));
	}

}
