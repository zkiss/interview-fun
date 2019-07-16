package kissz;

/**
 * https://leetcode.com/problems/container-with-most-water/
 */
public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int maxA = Math.min(height[0], height[1]);
        for (int i = 2; i < height.length; i++) {
            if (height[i] == 0) continue;
            int minWidth = maxA / height[i] + 1;
            for (int preceding = 0; preceding <= i - minWidth; preceding++) {
                int h = Math.min(height[i], height[preceding]);
                int w = i - preceding;
                int areaWithPreceding = w * h;
                if (areaWithPreceding > maxA) {
                    maxA = areaWithPreceding;
                }
            }
        }
        return maxA;
    }
}
