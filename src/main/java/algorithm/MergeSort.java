package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * 归并排序
 */
public class MergeSort {
    public static void sort(int [] arr, int left, int right){
        if (left >= right){
            return;
        }
        int mid = (left + right) / 2;
        sort(arr, left, mid);
        sort(arr, mid+1, right);
        merge(arr, left, mid, right);
        Collections.sort(new ArrayList<>());
    }

    private static void merge(int[] arr, int left, int mid, int right) {
        int lIndex = left;//左序列第一个元素下标
        int rIndex = mid + 1;//右序列第一个元素下标
        int tIndex = 0;//临时数组下标
        int [] temp = new int[arr.length];
        while (lIndex <= mid && rIndex <= right){
            if (arr[lIndex] <= arr[rIndex]){
                temp[tIndex++] = arr[lIndex++];
            }else {
                temp[tIndex++] = arr[rIndex++];
            }
        }
        //如果左序列有剩余，将剩余填充至temp中
        while (lIndex <= mid){
            temp[tIndex++] = arr[lIndex++];
        }
        //如果右序列有剩余，将剩余填充至temp
        while (rIndex <= right){
            temp[tIndex++] = arr[rIndex++];
        }
        tIndex = 0;
        //将temp中的元素全部拷贝到原数组中
        while (left <= right){
            arr[left++] = temp[tIndex++];
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 11, 4, 1, 15, 5, 0, 7, 10, 14};
        sort(arr, 0, arr.length-1);
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
