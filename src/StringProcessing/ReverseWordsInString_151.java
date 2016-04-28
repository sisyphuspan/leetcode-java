package StringProcessing;


import java.util.ArrayList;
public class ReverseWordsInString_151 {

	
	public static String reverseWords(String s){
		String result = "";
		String[] words = s.split(" ");
		ArrayList<String> temp = new ArrayList<String>();
		if(words.length==0)
			return "";
		for(int i=words.length-1; i>=0; i--){
			if(!words[i].equals(""))  
	    		temp.add(words[i]);
		}
		
		for(int i=0; i<temp.size()-1; i++)
			result += temp.get(i) + " ";
		if(temp.size()>0)
	    	result += temp.get(temp.size()-1);
		
		return result;
		
	}
	
	
	public static void main(String[] args) {
		String s = " the sky is     blue  a ";
		System.out.println(reverseWords(s));

	}

}
