package algorithm.leetcode.notType;

import java.util.*;

/**
 * @author Shawn
 * @title: SortByBits
 * @projectName studyDemo
 * @description: TODO
 * @date 2020/11/6
 */
public class SortByBits {
    public static void main(String[] args) {
        //System.out.println(Arrays.toString(sortByBits(new int[]{1,8,9,4,5,6,7,8,9})));

        new HashMap<>();
        System.out.println(Arrays.toString(sortByBits2(new int[]{1,8,9,4,5,6,7,8,9})));
    }

    public static int[] sortByBits(int[] arr) {
        int[] bit = new int[10001];
        List<Integer> list = new ArrayList<Integer>();
        for (int x : arr) {
            list.add(x);
            bit[x] = get(x);
        }
        Collections.sort(list, new Comparator<Integer>() {
            public int compare(Integer x, Integer y) {
                if (bit[x] != bit[y]) {
                    return bit[x] - bit[y];
                } else {
                    return x - y;
                }
            }
        });
        for (int i = 0; i < arr.length; ++i) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public static int get(int x) {
        int res = 0;
        while (x != 0) {
            res += x % 2;
            x /= 2;
        }
        return res;
    }

    public static int[] sortByBits2(int[] arr) {
        int[] intArrays = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            intArrays[i] = Integer.bitCount(arr[i]) * 10000000 + arr[i];
        }
        Arrays.sort(intArrays);
        for (int i = 0; i < intArrays.length; i++) {
            intArrays[i] = intArrays[i] % 10000000;
        }
        return intArrays;
    }

}
