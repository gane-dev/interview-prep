package com.javadroider.interviewprep.leetcode.medium;

public class _0033_SearchInRotatedSortedArray {

    //https://www.youtube.com/watch?v=oTfPJKGEHcc
    public int search(int[] nums, int target) {
        /**
         0 1 2 3 4 5 6
         [4,5,6,7,0,1,2], target = 0
         lo = 0;
         hi = 6;
         mid = ((6-0)+0)/2 = 3

         0 > n[3](7)

         [5, 1, 3]


         **/
        //https://www.youtube.com/watch?v=oTfPJKGEHcc
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int lo = 0;
        int hi = nums.length - 1;

        while (lo <= hi) {
            int mid = (lo + hi) / 2;
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] >= nums[lo]) {
                if (target >= nums[lo] && target <= nums[mid]) {
                    hi = mid - 1;
                } else {
                    lo = mid + 1;
                }
            } else {
                if (target >= nums[mid] && target <= nums[hi]) {
                    lo = mid + 1;
                } else {
                    hi = mid - 1;
                }
            }
        }

        return -1;
    }
}
