package algorithm.array;

import org.junit.jupiter.api.Test;

/**
 * @program: algorithm
 * @description: 快排
 * @author: szm
 * @create: 2020-02-17 15:50
 **/
public class QuickSort {
    // [2,0,2,1,1,0]
    @Test
    public void test() {
        System.out.println("----------start-----------");
        int[] input = {2, 0, 2, 1, 1, 3};
        int[] res = quickSort(input, 0, 5);
        for (int i : res) {
            System.out.println(i);
        }
    }

    public static int[] quickSort(int[] arr, int low, int high) {
        int i, j, temp, t;
        if (low > high) {
            return arr;
        }
        i = low;
        j = high;
        //temp就是基准位
        temp = arr[low];

        while (i < j) {
            //先看右边，依次往左递减
            while (temp <= arr[j] && i < j) {
                j--;
            }
            arr[i] = arr[j];
            // 再看左边，依次往右递增
            while (temp >= arr[i] && i < j) {
                i++;
            }
            arr[j] = arr[i];
//            //如果满足条件则交换
//            if (i < j) {
//                t = arr[j];
//                arr[j] = arr[i];
//                arr[i] = t;
//            }

        }
        //最后将基准为与i和j相等位置的数字交换
//        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low,  j - 1);
        //递归调用右半数组
        quickSort(arr, j + 1, high);
        return arr;
    }

}
