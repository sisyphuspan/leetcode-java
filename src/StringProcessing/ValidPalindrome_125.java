package StringProcessing;
public class ValidPalindrome_125 {

	public static boolean isPalindrome(String s) {
		if (s.length() == 0)
			return true;
		s = s.toLowerCase();
		int begin = 0;
		int end = s.length() - 1;
		while (begin < end) {
			while (!Character.isLetterOrDigit(s.charAt(begin)) && begin < end)
				begin++;
			while (!Character.isLetterOrDigit(s.charAt(end)) && end > begin)
				end--;

			if (s.charAt(begin) != s.charAt(end))
				return false;
			else {
				begin++;
				end--;
			}

		}
		return true;
	}

	public static void main(String[] args) {
		String str1 = "A man, a plan, a canal: Panama";

		int len = str1.length();
		System.out.println(len);
		if (isPalindrome(str1))
			System.out.println("yes, it's palindrome!");
		else
			System.out.println("no, it's not palindrome!");

	}

}
