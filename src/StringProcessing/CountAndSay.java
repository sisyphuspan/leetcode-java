package StringProcessing;

// Count and Say  Accepted

public class CountAndSay {

	public static String countAndSay(int n){
		String s = new String("1");
		while(n>1){
			s = getNext(s);
			n--;
		}
		return s;
	}
	
	public static String getNext(String s){
		StringBuffer sb = new StringBuffer();
		char currDigit = s.charAt(0);
		int count = 1;
		for(int i=1; i<s.length(); i++){
			if(s.charAt(i) == currDigit)
				count++;
			else{
				sb.append(count);
				sb.append(currDigit);
				currDigit = s.charAt(i);
				count = 1;
			}
		}
		sb.append(count);
		sb.append(currDigit);
			
		return sb.toString();
	}
	
	public static void main(String[] args) {
		int n = 5;
		String s = countAndSay(n);
		System.out.println(s);

	}

}
