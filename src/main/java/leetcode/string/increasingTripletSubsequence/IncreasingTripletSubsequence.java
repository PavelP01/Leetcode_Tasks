package leetcode.string.increasingTripletSubsequence;

public class IncreasingTripletSubsequence {
    public static void main(String[] args) {
        int[] nums = {20, 100, 10, 12, 5, 13};
        boolean res = new IncreasingTripletSubsequence().increasingTriplet(nums);
        System.out.println(res);
    }

    public boolean increasingTriplet(int[] nums) {
        if (nums == null || nums.length < 3) {
            return false;
        }

        int minOne = Integer.MAX_VALUE;
        int minTwo = Integer.MAX_VALUE;

        for (int num : nums) {
            if (num < minOne) {
                minOne = num;
            }

            if (num > minOne) {
                minTwo = Math.min(num, minTwo);
            }

            if (num > minTwo) {
                return true;
            }
        }
        return false;
    }
}
