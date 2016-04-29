package divide_conquer;

/**
 * Created by sisyphuspan on 16/4/23.
 */
public class KthLargestElement_215 {

    public static void main(String[] args) {
        int[] nums = {6,3,7,2,5};
        int m = findKthLargest(nums, 3);
        System.out.print(m);

    }

    public static int findKthLargest(int[] nums, int k) {
        if(nums == null || nums.length < k)
            return -1;

        return findRecursive(nums, 0, nums.length-1, k);
    }

    public static int findRecursive(int[] nums, int i, int j, int k) {
        if(i>j || i+1 > k)
            return -1;
        int p = partition(nums, i, j);
        if(k == p+1)
            return nums[p];
        else if(k < p+1)
            return findRecursive(nums, i, p-1, k);
        else
            return findRecursive(nums, p+1, j, k);
    }

    // 大的放在左边, 小的放右边, 返回中间值index
    public static int partition(int[] nums, int i, int j) {
        int base = nums[i]; // 选取base
        int p  = j; // base最后存放的位置, 开始默认base是最小的,放在最后
        int index = j;
        while(index > i) {
            if(nums[index] < base) {
                swap(nums, p, index);
                p--; // 有比base小的,base位置前移
            }
            index--;
        }
        swap(nums, p, i); // 把base移到最终的位置上
        return p;
    }

    public static void swap(int[] nums, int i, int m) {
        int temp = nums[i];
        nums[i] = nums[m];
        nums[m] = temp;
    }
}
