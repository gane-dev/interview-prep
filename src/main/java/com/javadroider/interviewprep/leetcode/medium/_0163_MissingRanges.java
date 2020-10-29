package com.javadroider.interviewprep.leetcode.medium;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class _0163_MissingRanges {

    //https://leetcode.com/problems/missing-ranges/solution/
    public List<String> findMissingRanges(int[] nums, int lower, int upper) {
        int n = nums.length;

        if (n == 0) {
            return Collections.singletonList(formatRange(lower, upper));
        }

        List<String> missingRanges = new ArrayList<>();

        // Edge case 1) Missing ranges at the beginning
        if (nums[0] > lower) {
            //nums = [3,50,75], lower = 0, upper = 99
            missingRanges.add(formatRange(lower, nums[0] - 1));
        }

        // Missing ranges between array elements
        for (int i = 1; i < n; ++i) {
            if (nums[i] - nums[i - 1] > 1) {
                missingRanges.add(formatRange(nums[i - 1] + 1, nums[i] - 1));
            }
        }

        // Edge case 2) Missing ranges at the end
        if (nums[n - 1] < upper) {
            //nums = [0,1,3,50,75], lower = 0, upper = 99
            missingRanges.add(formatRange(nums[n - 1] + 1, upper));
        }

        return missingRanges;
    }

    // formats range in the requested format
    private String formatRange(int lower, int upper) {
        if (lower == upper) {
            return String.valueOf(lower);
        } else {
            return lower + "->" + upper;
        }
    }
}
