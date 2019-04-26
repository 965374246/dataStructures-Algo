package com.hjl.binarySearch;

/**
 * @author jiale.he
 * @date 2019/04/23
 * @email jiale.he@mail.hypers.com
 */
public class BinarySearch1 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 6, 6, 8, 8, 8, 8, 8, 9, 9, 10};

        System.out.println(binarySearch3(arr, 8));

    }


    /**
     * 查找第一个大于等于给定值的元素
     *
     * @param arr
     * @param key
     * @return
     */
    static int binarySearch3(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int middle = min + ((max - min) >> 1);
            if (arr[middle] < key) {
                min = middle + 1;
            } else if (arr[middle] > key) {
                max = middle - 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] != key) return middle + 1;
                else min = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找最后一个值等于给定值的元素
     *
     * @param arr
     * @param key
     */
    static int binarySearch2(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int middle = min + ((max - min) >> 1);
            if (arr[middle] < key) {
                min = middle + 1;
            } else if (arr[middle] > key) {
                max = middle - 1;
            } else {
                if (middle == arr.length - 1 || arr[middle + 1] != key) return middle;
                else min = middle + 1;
            }
        }
        return -1;
    }

    /**
     * 查找第一个值等于给定值的元素
     *
     * @param arr
     * @param key
     * @return
     */
    private static int binarySearch1(int[] arr, int key) {
        int min = 0;
        int max = arr.length - 1;
        while (min <= max) {
            int middle = min + ((max - min) >> 1);
            if (arr[middle] < key) {
                min = middle + 1;
            } else if (arr[middle] > key) {
                max = middle - 1;
            } else {
                if (middle == 0 || arr[middle - 1] != key) return middle;
                else max = middle - 1;
            }
        }
        return -1;
    }

}
