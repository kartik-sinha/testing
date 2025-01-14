package DynamicProgramming;
import java.util.*;

public class LIS {
    public static int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int[] LIS = new int[n];
        Arrays.fill(LIS, 1); // Initialize all elements to 1

        for (int i = n - 2; i >= 0; i--) {
            for (int j = i + 1; j < n; j++) {
                if (nums[i] < nums[j]) {
                    LIS[i] = Math.max(LIS[i], 1 + LIS[j]);
                }
            }
        }

        int maxLIS = 0;
        for (int len : LIS) {
            maxLIS = Math.max(maxLIS, len);
        }

        return maxLIS;
    }

    public static void main(String[] args) {
        System.out.println(lengthOfLIS(new int[]{1, 3, 2, 1}));
    }
}