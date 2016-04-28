package StringProcessing;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
    	String[] words = s.split(" ");
    	int n = words.length;
    	int len = 0;
    	if(n>=1)  // 防止越界
        	len = words[n-1].length(); // words.length字段返回数组的元素个数
    	return len;
        
    }
	public static void main(String[] args) {
		String s = "  ";
		int len = lengthOfLastWord(s);
		System.out.println(len);

	}

}
