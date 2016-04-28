package StringProcessing;

public class LongestPalindromicSubstring {

	public static String longestPalindromicSubstring(String s){
		int len = s.length();
		int maxSubLength = 0;
		int index = 0;
		
		for(int i=0; i<len; i++){
			int tmpLen = 1;
			int begin = i;
			int end = i+1;
			while(begin>=0 && end<len){
				if(s.charAt(begin) == s.charAt(end)){
					begin--;
					end++;
					tmpLen += 2;
				}else{
					begin--;
					if(begin>=0 && s.charAt(begin) == s.charAt(end)){
						begin--;
						end++;
						tmpLen += 2;
					}else{
						break;
					}	
				}
			}
			
			if(tmpLen>maxSubLength){
				maxSubLength = tmpLen;
				index = i;
			}	
		}
		
		String substring = s.substring(index-maxSubLength/2, index-maxSubLength/2+1);
		return substring;
	}
	public static void main(String[] args) {
		String s = "aabb";
		System.out.println(longestPalindromicSubstring(s));

	}

}
