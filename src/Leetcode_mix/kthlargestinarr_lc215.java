package Leetcode_mix;

import java.util.Collections;
import java.util.PriorityQueue;

public class kthlargestinarr_lc215 {
    public static void main(String[] args) {
        int[] nums = {3,2,3,1,2,4,5,5,6};
        int k = 5;

        kthlargestinarr_lc215 sol = new kthlargestinarr_lc215();
        int result = sol.findKthLargest(nums, k);

        System.out.println(result); // expected: 5
    }

//    public int findKthLargest(int[] nums, int k) {
//        PriorityQueue<Integer> queue = new PriorityQueue<>(Collections.reverseOrder());//max  heap
//        for (int i = 0; i < nums.length; i++) {
//            queue.add(nums[i]);
//        }
//
//        for (int i = 1; i < k ; i++) {
//            queue.poll();
//        }
//
//        return queue.poll();
//    }


    //min heap
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> queue = new PriorityQueue<>();

        for ( int num : nums) {
            queue.add(num);

            if (queue.size() > k ) {  //if the k value is lower than the queue size then you can remove elements
                queue.poll();
            }
        }
        return queue.peek();
    }
}
