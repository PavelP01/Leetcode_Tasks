package leetcode.dynamic.subarray;

public class MaxSubarray {
    public static void main(String[] args) {
        int[] nums = new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4};
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        return findMaximumSum(nums);
    }

    private static int findMaximumSum(int[] nums, int left, int right) {
        if (right == left) {
            return nums[left];
        }

        int mid = (left + right) / 2;

        int leftMax = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftMax) {
                leftMax = sum;
            }
        }

        int rightMax = Integer.MIN_VALUE;
        sum = 0;    // reset sum to 0
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightMax) {
                rightMax = sum;
            }
        }

        int maxLeftRight = Integer.max(findMaximumSum(nums, left, mid),
                findMaximumSum(nums, mid + 1, right));
        return Integer.max(maxLeftRight, leftMax + rightMax);
    }

    private static int findMaximumSum(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        return findMaximumSum(nums, 0, nums.length - 1);
    }
}
