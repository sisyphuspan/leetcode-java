package StringProcessing;

public class LengthOfLastWord {

    public static int lengthOfLastWord(String s) {
    	String[] words = s.split(" ");
    	int n = words.length;
    	int len = 0;
    	if(n>=1)  // ��ֹԽ��
        	len = words[n-1].length(); // words.length�ֶη��������Ԫ�ظ���
    	return len;
        
    }
	public static void main(String[] args) {
		String s = "  ";
		int len = lengthOfLastWord(s);
		System.out.println(len);

	}

}
