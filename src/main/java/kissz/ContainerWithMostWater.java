package kissz;

import java.util.Arrays;

public class ContainerWithMostWater {

    public int maxArea(int[] height) {
        int[] maxHeightToLeft = new int[height.length];
        int[] maxHeightToLeftIndex = new int[height.length];
        int[] maxHeightToRight = new int[height.length];
        int[] maxHeightToRightIndex = new int[height.length];
        int maxHeight = 0;
        int maxHeightIndex = 0;
        for (int i = 0; i < height.length; i++) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
            maxHeightToLeft[i] = maxHeight;
            maxHeightToLeftIndex[i] = maxHeightIndex;
        }

        maxHeight = 0;
        for (int i = height.length - 1; i >= 0; i--) {
            if (height[i] > maxHeight) {
                maxHeight = height[i];
                maxHeightIndex = i;
            }
            maxHeightToRight[i] = maxHeight;
            maxHeightToRightIndex[i] = maxHeightIndex;
        }

        int maxVolume = 0;
        for (int i = 0; i < height.length; i++) {
            int volume = Math.min(maxHeightToLeft[i], maxHeightToRight[i])
                    * (maxHeightToRightIndex[i] - maxHeightToLeftIndex[i]);
            if (volume > maxVolume) maxVolume = volume;
        }
        return maxVolume;
    }
}
