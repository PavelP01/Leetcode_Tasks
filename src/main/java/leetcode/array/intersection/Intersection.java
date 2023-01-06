package leetcode.array.intersection;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Intersection {
    public static void main(String[] args) {

    }

    private int[] calc2(int[] nums1, int[] nums2){
        List<Integer> secondList = Arrays.stream(nums2).boxed().collect(Collectors.toList());


        return Arrays.stream(nums1)
                .boxed()
                .filter(
                        o -> secondList.remove(o)
                )
                .mapToInt(Integer::intValue)
                .toArray();
    }
}
