package com.company.dsalgo;

import java.util.Arrays;
/*
Given an array of integers, find the length of the longest sub-sequence such that elements in the subsequence are consecutive integers, the consecutive numbers can be in any order.

Input: arr[] = {1, 9, 3, 10, 4, 20, 2}
Output: 4
Explanation:
The subsequence 1, 3, 4, 2 is the longest
subsequence of consecutive elements

Input: arr[] = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42}
Output: 5
Explanation:
The subsequence 36, 35, 33, 34, 32 is the longest
subsequence of consecutive elements.
*/

//https://www.geeksforgeeks.org/longest-consecutive-subsequence/

/*
{100, 180, 260, 310, 40, 535, 695}
Find the max profit that you can make by buying and selling in those days. The maximum profit can earned by buying on day 0, selling on day 3. Again buy on day 4 and sell on day 6.

{100, 180, 120, 130, 125, 120, 100}
*/
//https://www.geeksforgeeks.org/stock-buy-sell/

/*
Given an unsorted array of positive integers, find the number of triangles that can be formed with three different array elements as three sides of triangles.

Input: arr= {4, 6, 3, 7}
Output: 3
Explanation: There are three triangles
possible {3, 4, 6}, {4, 6, 7} and {3, 6, 7}.
Note that {3, 4, 7} is not a possible triangle.

Input: arr= {10, 21, 22, 100, 101, 200, 300}.
Output: 6
*/
//https://www.geeksforgeeks.org/find-number-of-triangles-possible/
public class Set1 {

    public static void main(String[] args) {
        int[] arr = {36, 41, 56, 35, 44, 33, 34, 92, 43, 32, 42, 45, 40, 39};
        System.out.println(maxProfit());
    }

    // region Answer 1
    static int count = 0;

    static int findSequence(int[] arr) {
        int tempCount = 1;
        Arrays.sort(arr);
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] == arr[i] + 1) {
                tempCount++;
            } else {
                tempCount = 1;
            }
            if (tempCount > count) {
                count = tempCount;
            }
        }
        return count;
    }

    //endregion


    // region Answer 2
    static int maxProfit() {
        int[] arr = {5, 2, 7, 3, 6, 1, 2, 4, 2};
        //int[] arr = {5, 4, 3, 8, 9};
        int profit = 0;
        int[] right = new int[arr.length];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        for (int i = 1; i < arr.length; i++) {
            int diff = right[i] - arr[i];
            if (diff > profit) profit = diff;
        }

        return profit;
    }

    /**
     * 1st approach is to find local minima and check if next day price is
     * more.
     * 
     */
    static int totalProfit() {
        int[] arr = {5, 2, 7, 3, 6, 1, 2, 4, 2};
        //int[] arr = {5, 4, 3, 8, 9};
        int profit = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i + 1] > arr[i]) {
                profit = profit + (arr[i + 1] - arr[i]);
            }
        }
        return profit;
    }
    //endregion

    // region Answer 3
    static int calculateTotalTriangles(int[] arr) {
        Arrays.sort(arr);
        int count = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] > arr[k]) {
                        count++;
                    }
                }
            }
        }
        return count;
    }
    //endregion

}
