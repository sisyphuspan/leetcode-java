package StringProcessing;


import java.util.*;

public class Anagrams {

	public static String parseString(final String str){
		Integer[] counts = new Integer[26];
		for(int i=0; i<26; i++)
			counts[i] = 0;
		
		for(int i=0; i<str.length(); i++)
			if(Character.isLetter(str.charAt(i))){
				int index = (int)(Character.toLowerCase(str.charAt(i))-'a');
				counts[index] += 1;
			}
		StringBuffer sb = new StringBuffer();
		for(int i=0; i<26; i++)
			sb.append(counts[i]);
		return sb.toString();
	}
	
	
	public static ArrayList<String> anagrams(String[] strs) {
		ArrayList<String> solutions = new ArrayList<String>();
		Map<String, Integer> process = new HashMap<String, Integer>();
		
		for(int i=0; i<strs.length; i++){
			String temp = parseString(strs[i]);
	
			if(process.containsKey(temp)){
				if(process.get(temp) != -1){
					solutions.add(strs[process.get(temp)]);
					solutions.add(strs[i]);
					process.put(temp, -1);
				}else{
					solutions.add(strs[i]);
				}	
			}else{
				process.put(temp, i);
			}		
		}

		return solutions;	
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		String[] strs = {"abcd", "acdb", "abbd", "adcb"};
		ArrayList<String> re = new ArrayList<String>();
		re = anagrams(strs);
		
		for(int i=0; i<re.size(); i++)
			System.out.println(re.get(i));
	}

}
