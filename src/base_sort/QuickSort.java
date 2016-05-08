/**
 * Created by sisyphuspan on 16/4/23.
 */
public class QuickSort {

    public static void main(String[] args) {
        int[] nums = {6,3,7,2,5,11,1,9,10};
        quickSort(nums);
        System.out.print("sort end...");
    }

    public static void quickSort(int[] nums) {
        if(nums == null || nums.length <= 1)
            return;
        part(nums, 0, nums.length-1);
    }

    public static void part(int[] nums, int i, int j) {
        if(i >= j)
            return;
        int p = partition(nums, i, j);
        part(nums, i, p-1);
        part(nums, p+1, j);
    }


    // 小在前, 大在后
    public static int partition(int[] nums, int i, int j) {
        int base = nums[i];
        int p = j;
        int idx = j;
        while(idx > i) {
            if(nums[idx] > base) {
                swap(nums, p, idx);
                p--;
            }
            idx--;
        }
        swap(nums, i, p);
        return p;
    }

    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}
