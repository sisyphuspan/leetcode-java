

import java.util.ArrayList;
import java.util.List;

/**
 * Created by sisyphuspan on 16/4/13.
 */
public class GrayCode_89 {
    // gray code: 格雷码, n-bit 二进制码
    // 本题中要求前后两个格雷码只有二进制的一位不同
    // 找规律: 依次在上一次的前面加0 (值不变), 依次在前面加1 (逆序开始)
    public static ArrayList<Integer> grayCode(int n) {
        ArrayList<Integer> result = new ArrayList<Integer>();
        result.add(0);

        for(int i=1; i<=n; i++) {
            int count = result.size();
            int prefix = 1 << (i-1);
            for(int j=count-1; j>=0; j--) {
                result.add(prefix + result.get(j));
            }
        }

        return result;
    }

    public static void main(String[] args) {
        ArrayList<Integer> result = grayCode(4);
        System.out.print(result.size());
    }
}
