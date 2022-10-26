package com.company.dsalgo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*
Q -> Given two sorted arrays of size m and n respectively, you are tasked with finding the element
that would be at the k’th position of the final sorted array.

Input : Array 1 - 2 3 6 7 9
        Array 2 - 1 4 8 10
        k = 5
Output : 6
Explanation: The final sorted array would be -
1, 2, 3, 4, 6, 7, 8, 9, 10
The 5th element of this array is 6.

Input : Array 1 - 100 112 256 349 770
        Array 2 - 72 86 113 119 265 445 892
        k = 7
Output : 256
Explanation: Final sorted array is -
72, 86, 100, 112, 113, 119, 256, 265, 349, 445, 770, 892
7th element of this array is 256.



Q -> Count number of triplets in an array having sum in the range [a, b]

Input : arr[] = {8, 3, 5, 2}
        range = [7, 11]
Output : 1
There is only one triplet {2, 3, 5}
having sum 10 in range [7, 11].

Input : arr[] = {2, 7, 5, 3, 8, 4, 1, 9}
        range = [8, 16]
Output : 36

Q -> Given a 2D array, print it in spiral form. See the following examples.

Input:  1    2   3   4
        5    6   7   8
        9   10  11  12
        13  14  15  16
Output: 1 2 3 4 8 12 16 15 14 13 9 5 6 7 11 10
Explanation: The output is matrix in spiral format.

Input:  1   2   3   4  5   6
        7   8   9  10  11  12
        13  14  15 16  17  18
Output: 1 2 3 4 5 6 12 18 17 16 15 14 13 7 8 9 10 11
Explanation :The output is matrix in spiral format.

 */
public class Set2 {

    public static void main(String[] args) {
        int[] arr1 = {2, 3, 6, 7, 9};
        int[] arr2 = {1, 4, 8, 10};

        System.out.println(printSpiral2());
        //System.out.println(findKthElement(arr1, arr2, 5));
    }

    static class User {
        String name;
        Integer age;

        public User() {
            //setObject(new User());
        }

        public User(String name, Integer age) {
            this.name = name;
            this.age = age;
            setObject(new SuperUser());
        }

        public String getName() {
            return name;
        }

        public void setObject(User o) {
            System.out.println("User");
        }
    }


    static class SuperUser extends User {

    }


    static int findKthElement(int[] arr1, int[] arr2, int k) {
        int m = 0;
        int n = 0;
        int count = 0;
        List<Integer> list = new ArrayList<>();
        while (count < k) {
            if (arr1[m] < arr2[n]) {
                list.add(arr1[m]);
                m++;
            }
            if (arr1[m] > arr2[n]) {
                list.add(arr2[n]);
                n++;
            }
            count++;
        }
        return list.get(count);
    }

    static String printSpiral(int[][] arr) {

        ArrayList<Integer> list = new ArrayList<>();

        int r = 4, c = 4;
        int k = 0, l = 0;

        int lastRow = r - 1;
        int lastCollum = c - 1;

        while (l < lastRow && l < lastCollum) {

            for (int i = l; i <= lastCollum; i++) {
                list.add(arr[k][i]);
            }
            k++;

            for (int i = k; i <= lastRow; i++) {
                list.add(arr[i][lastCollum]);
            }
            lastCollum--;

            if (k <= lastRow) {
                for (int i = lastCollum; i > l; i--) {
                    list.add(arr[lastRow][i]);
                }
            }

            lastRow--;

            if (l <= lastCollum) {
                for (int i = lastRow; i > k; i--) {
                    list.add(arr[i][l]);
                }
            }
            l++;
        }
        return list.toString();
    }


    static String printSpiral2() {
        ArrayList<Integer> list = new ArrayList<>();
        int k = 0; //
        int l = 0; // 1
        int arr[][] = {{1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}};
        int last_row = arr.length - 1; // 2
        int last_collum = arr[0].length - 1; // 2


        while (k < last_row && l < last_collum) {


            for (int i = k; i <= last_row; i++) {
                list.add(arr[i][l]);
            }
            l++;
            for (int i = l; i <= last_collum; i++) {
                list.add(arr[last_row][i]);
            }
            last_row--;
            if (l <= last_collum) {
                for (int i = last_row; i >= k; i--) {
                    list.add(arr[i][last_collum]);
                }
            }
            last_collum--;
            if (k <= last_row) {
                for (int i = last_collum; i >= l; i--) {
                    list.add(arr[k][i]);
                }

            }
            k++;
        }
        return list.toString();
    }
}
