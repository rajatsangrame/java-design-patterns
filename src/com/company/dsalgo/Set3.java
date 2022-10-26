package com.company.dsalgo;

import java.util.*;

class Set3 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(removeOccurrenceAndShift()));
    }


    static int[] removeOccurrenceAndShift() {
        int[] arr = {11, 5, 7, 5, 7, 8};
        int x = 5;
        int n = arr.length;

        int[] newArr = new int[n];
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != x) {
                newArr[count] = arr[i];
                count++;
            }
        }

        for (int i = 0; i < n; i++) {
            if (newArr[i] == x) {
                newArr[i] = 1;
            }
        }
        return newArr;
    }

    static int paintHouse() {

        int[][] arr = {{1, 5, 7}, {5, 8, 4}, {3, 2, 9}, {1, 2, 4}};
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            arr[i][0] = arr[i][0] + Math.min(arr[i - 1][1], arr[i - 1][2]);
            arr[i][1] = arr[i][1] + Math.min(arr[i - 1][0], arr[i - 1][2]);
            arr[i][2] = arr[i][2] + Math.min(arr[i - 1][0], arr[i - 1][1]);
        }

        return Math.min(arr[n - 1][0], Math.min(arr[n - 1][1], arr[n - 1][2]));
    }

    static int findTriplets() {
        // int[] arr = {2, 7, 5, 3, 8, 4, 1, 9};
        int[] arr = {8, 3, 5, 2};
        int a = 7, b = 11;
        int count = 0;

        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 2; i++) {
            int j = i + 1;
            int k = arr.length - 1;

            while (j != k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (a <= sum && sum <= b) {
                    count++;
                    j++;
                } else if (sum > b) {
                    k--;
                } else {
                    j++;
                }
            }
        }
        return count;
    }

    static int rainWaterTappingProblem() {
        int[] arr = {3, 1, 2, 4, 0, 1, 3, 2};
        int result = 0;

        int[] lef = new int[arr.length];
        int[] right = new int[arr.length];
        lef[0] = arr[0];
        right[arr.length - 1] = arr[arr.length - 1];
        for (int i = 1; i < arr.length; i++) {
            lef[i] = Math.max(arr[i], lef[i - 1]);
        }
        for (int i = arr.length - 2; i >= 0; i--) {
            right[i] = Math.max(arr[i], right[i + 1]);
        }
        for (int i = 0; i < arr.length; i++) {
            result += Math.min(lef[i], right[i]) - arr[i];
        }
        return result;
    }

    static int possibleTriangle() {
        int[] arr = {10, 21, 22, 100, 101, 200, 300};
        Arrays.sort(arr);
        int count = 0;
        for (int k = arr.length - 1; k > 1; k--) {
            for (int i = 0, j = k - 1; i < j; ) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += j - i;
                    j--;
                } else {
                    i++;
                }
            }
        }
        return count;
    }

    static boolean findSumExist() {
        int[] arr = {2, 3, 4, 6, 8, 9, 11};
        int k = 11;
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            if (arr[start] + arr[end] == k) {
                return true;
            } else if (arr[start] + arr[end] < k) {
                start++;
            } else if (arr[start] + arr[end] > k) {
                end--;
            }
        }
        return false;
    }

    static boolean findSumExist2() {
        int[] arr = {2, 3, 4, 6, 8, 9, 11};
        int k = 11;
        HashSet<Integer> hashSet = new HashSet<>();
        for (int j : arr) {
            hashSet.add(j);
        }
        for (int j : arr) {
            int num = Math.abs(j - k);
            if (hashSet.contains(num)) return true;
        }
        return false;
    }

    static int timesArrayIsRotated() {
        int[] arr = {12, 15, 18, 19, 20, 2, 4};
        int start = 0;
        int end = arr.length - 1;
        int mid = -1;
        while (start <= end) {
            mid = (start + end) / 2;
            if (mid == arr.length - 1 && arr[mid] < arr[mid - 1]) {
                return arr.length - mid;
            } else if (arr[mid - 1] > arr[mid] && arr[mid] < arr[mid + 1]) {
                return arr.length - mid;
            } else if (arr[start] <= arr[mid]) {
                start = mid + 1;
            } else if (arr[end] >= arr[mid]) {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int findIndex() {
        int[] arr = {-4, -1, 3, 7, 8, 10, 11};
        int n = -1;
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            if (arr[mid] == n) return mid;
            if (arr[mid] < n) {
                start = mid + 1;
            }
            if (arr[mid] > n) {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int findFirstOccurrence() {
        int[] arr = {-4, -1, 3, 7, 8, 8, 8, 10, 11};
        int n = 8;
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start < end) {
            int mid = (end + start) / 2;
            if (arr[mid] == n && mid != 0 && arr[mid - 1] == n) {
                end = mid - 1;
            } else if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                start = mid + 1;
            } else if (arr[mid] > n) {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int findLasOccurrence() {
        int[] arr = {-4, -1, 3, 7, 8, 8, 8, 10, 11};
        int n = 8;
        int start = 0;
        int end = arr.length - 1;
        int count = 0;
        while (start < end) {
            int mid = (end + start) / 2;
            if (arr[mid] == n && mid != 0 && arr[mid + 1] == n) {
                start = mid + 1;
            } else if (arr[mid] == n) {
                return mid;
            } else if (arr[mid] < n) {
                start = mid + 1;
            } else if (arr[mid] > n) {
                end = mid - 1;
            }
        }
        return -1;
    }

    static int findLength() {
        int start = findFirstOccurrence();
        int end = findLasOccurrence();
        return end - start + 1;
    }
}
