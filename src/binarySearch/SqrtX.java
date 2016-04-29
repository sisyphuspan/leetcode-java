package binarySearch;

/**
 * Created by sisyphuspan on 16/4/7.
 */
public class SqrtX {

    public int mySqrt(int x) {
        int low = 0;
        int high= x;
        while(low <= high) {
            int mid = (low + high) / 2;
            int temp = mid * mid;
            if(temp == x) {
                return mid;
            }else if(temp > x) {
                high = mid - 1;
            }else {
               low = mid + 1;
            }
        }
        return 0;
    }

    public int mySqrt2(int x) {
        int t = x;
        while(t * t > x)
            t = (int)(t / 2.0 + x / (2.0 * t));
        return t;
    }
}
