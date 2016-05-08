

/**
 * Created by sisyphuspan on 16/4/23.
 */

public class RangeSumQuery_303 {
    private int sum[][];
    public RangeSumQuery_303(int[] nums) {
        //if(nums == null || nums.length == 0)
        this.sum = new int[nums.length][nums.length];
        for(int i=0; i<nums.length; i++)
            sum[i][i] = nums[i];
        for(int i=0; i<nums.length; i++){
            for(int j=i+1; j<nums.length; j++) {
                sum[i][j] = sum[i][j-1] + nums[j];
            }
        }
    }

    public int sumRange(int i, int j) {
        return sum[i][j];
    }
}
