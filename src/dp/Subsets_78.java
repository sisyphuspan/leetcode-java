package dp;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by sisyphuspan on 16/4/17.
 */
public class Subsets_78 {

    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        List<List<Integer>> res = subsets(nums);
        System.out.println(res.size());
    }

    public static List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        List<Integer> set = new ArrayList<Integer>();
        result.add(set);

        if(nums == null || nums.length == 0) {
            return result;
        }

        Arrays.sort(nums);

        for(int i=0; i<nums.length; i++) {
            int count = result.size();
            for(int j=0; j<count; j++) {
                List<Integer> temp = new ArrayList<Integer>(result.get(j));
                temp.add(nums[i]);
                result.add(temp);
            }
        }

        return result;
    }
}
