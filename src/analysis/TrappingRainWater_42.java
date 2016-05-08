/**
 * Created by sisyphuspan on 16/4/22.
 */
public class TrappingRainWater_42 {

    public static void main(String[] args) {
        int[] h = {0,1,0,2,1,0,1,3,2,1,2,1};
        int area = trap(h);
        System.out.println(area);
    }

    public static int trap(int[] height) {
        if(height == null || height.length <= 2)
            return 0;
        int max = 0;
        int maxIndex = -1;
        for(int i=0; i<height.length; i++) {
            if(height[i] > max) {
                max = height[i];
                maxIndex = i;
            }
        }

        int secHigh = height[0];
        int area = 0;
        for(int i=0; i<maxIndex; i++) {
            if(height[i] >= secHigh)
                secHigh = height[i];
            else {
                area += (secHigh - height[i]);
            }
        }

        secHigh=height[height.length-1];
        for(int i=height.length-1; i > maxIndex; i--) {
            if(height[i] >= secHigh)
                secHigh = height[i];
            else {
                area += (secHigh - height[i]);
            }
        }
        return area;
    }
}
