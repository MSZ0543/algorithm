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
        int[] input = {2, 0, 2, 1, 1, 0};
        quickSort(input, 0, 5);
        for (int i : input) {
            System.out.println(i);
        }
    }

    public static void quickSort(int arr[], int left, int right) {
        int l = left;
        int r = right;
        int temp = 0;
        if (l <= r) {   //待排序的元素至少有两个的情况
            temp = arr[l];  //待排序的第一个元素作为基准元素
            while (l != r) {   //从左右两边交替扫描，直到l = r

                while (r > l && arr[r] >= temp)
                    r--;        //从右往左扫描，找到第一个比基准元素小的元素
                arr[l] = arr[r];  //找到这种元素arr[r]后与arr[l]交换

                while (l < r && arr[l] <= temp)
                    l++;         //从左往右扫描，找到第一个比基准元素大的元素
                arr[r] = arr[l];  //找到这种元素arr[l]后，与arr[r]交换

            }
            arr[r] = temp;    //基准元素归位
            quickSort(arr, left, l - 1);  //对基准元素左边的元素进行递归排序
            quickSort(arr, r + 1, right);  //对基准元素右边的进行递归排序
        }
    }
}
