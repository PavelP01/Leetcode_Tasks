package leetcode.array.sum3;

import java.util.*;

public class Sum3 {
    public static void main(String[] args) {
        //int[] nums = {-1,0,1,2,-1,-4};
        int[] nums = {0,0,0};
        List<List<Integer>> result = threeSum2(nums);
        System.out.println(result);
    }

    public static List<List<Integer>> threeSum2(int[] nums) {
        Set<List<Integer>> uniqueTriplets = new HashSet<>();
        Map<Integer, Set<List<Integer>>> targetToTwoSumMap = new HashMap<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int secondAndThirdSum = -first;

            Set<List<Integer>> twoSumSet = twoSum(nums, i + 1, nums.length, secondAndThirdSum);

            Set<List<Integer>> existedTwoSumSet = targetToTwoSumMap.get(first);
            if (existedTwoSumSet != null) {
                existedTwoSumSet.addAll(twoSumSet);
            } else {
                targetToTwoSumMap.put(first, twoSumSet);
            }
        }

        targetToTwoSumMap.forEach((key, twoSumSet) -> twoSumSet.forEach(ts -> {
            List<Integer> triplet = new ArrayList<>();
            triplet.add(key);
            triplet.addAll(ts);
            Collections.sort(triplet);
            uniqueTriplets.add(triplet);
        }));
        return new ArrayList<>(uniqueTriplets);
    }

    public static Set<List<Integer>> twoSum(int[] nums, int first, int last, int target) {
        Set<List<Integer>> twoSumSet = new HashSet<>();
        Map<Integer, Integer> expDiffToIndex = new HashMap<>();

        for (int i = first; i < last; i++) {
            if (target > 0 && nums[i] < -100000 + target) {
                continue;
            }
            if (target < 0 && nums[i] > 100000 + target) {
                continue;
            }
            int expectedDiff = target - nums[i];
            if (expDiffToIndex.containsKey(expectedDiff)) {
                twoSumSet.add(
                        List.of(
                                nums[i],
                                nums[expDiffToIndex.get(expectedDiff)]
                        )
                );
            }
            expDiffToIndex.put(nums[i], i);
        }
        return twoSumSet;
    }


    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> uniqueTriplets = new HashSet<>();

        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            int secondAndThirdSum = -first;
            for (int j = i + 1; j < nums.length - 1; j++) {
                int second = nums[j];
                int third = secondAndThirdSum - second;

                List<Integer> triplet = new ArrayList<>();
                triplet.add(first);
                triplet.add(second);
                triplet.add(third);
                Collections.sort(triplet);

                if (!uniqueTriplets.contains(triplet)){
                    for (int k = j + 1; k < nums.length; k++) {
                        if (nums[k] == third) {
                            uniqueTriplets.add(triplet);
                            break;
                        }
                    }
                }
            }
        }
        return new ArrayList<>(uniqueTriplets);
    }

    private static void populate(Set<List<Integer>> triplets, int first, int second, int third) {
        int min = Math.min(first, Math.min(second, third));
        if (first == min) {
            int middle = Math.min(second, third);
            if (middle == second) {
                triplets.add(List.of(first, second, third));
            } else {
                triplets.add(List.of(first, third, second));
            }
        } else if (second == min) {
            int middle = Math.min(first, third);
            if (middle == first) {
                triplets.add(List.of(second, first, third));
            } else {
                triplets.add(List.of(second, third, first));
            }
        } else {
            int middle = Math.min(first, second);
            if (middle == first) {
                triplets.add(List.of(third, first, second));
            } else {
                triplets.add(List.of(third, second, first));
            }
        }
    }
}
