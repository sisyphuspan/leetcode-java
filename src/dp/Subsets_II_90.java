

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sisyphuspan on 16/4/17.
 */
public class Subsets_II_90 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 2};
        List<List<Integer>> res = subsetsWithDup(nums);
        System.out.println(res.size());
    }

    public static List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result.add(set);

        if(nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);
        int i = 0;
        while(i < nums.length) {
            int count = result.size();
            int base = nums[i]; // 当前元素
            int num = 1; // 当前元素重复的个数
            while(i+1 < nums.length && nums[i+1] == nums[i]) { // 求重复个数
                num++;
                i++;
            }

            for(int k=1; k<=num; k++) { // 分别向原来subset加入k个base
                for (int j = 0; j < count; j++) {
                    List<Integer> temp = new ArrayList<Integer>(result.get(j));
                    for(int t=1; t<=k; t++) // 加入k个base
                        temp.add(base);
                    result.add(temp);
                }
            }

            i++;
        }

        return result;
    }
}
