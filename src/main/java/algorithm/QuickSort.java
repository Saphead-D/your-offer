package algorithm;

import java.util.Random;

/**
 * @author: duke
 * @date: 2019/7/16 1:29 PM
 */
public class QuickSort {
    static void quickSort(int[] arr, int left, int right){
        if (arr == null || left >= right || arr.length <= 1){
            return;
        }
        //选择边界基数 （挖一个坑 方便存放数据）
        int base = arr[left];
        int ltemp = left;
        int rtemp = right;
        while (ltemp < rtemp){
            //从相反边界开始 寻找第一个小于基数的位置`
            while (ltemp < rtemp && arr[rtemp] >= base){
                rtemp--;
            }

            if (ltemp < rtemp){
                //将第一个小于基数的值 放入坑中 （把小于基数的值往左移， 这样存在2个 arr[rtemp]）
                arr[ltemp] = arr[rtemp];
                ltemp++;
            }
            printArr(arr, ltemp, rtemp);
            // 现在arr[rtemp]是一个坑 从基数边界方向寻找第一个大于基数的值
            while (ltemp < rtemp && arr[ltemp] <= base){
                ltemp++;
            }
            if (ltemp < rtemp){
                //将第一个大于基数的值 填arr[rtemp]的坑，(把大于基数的值往右移， 这样存在2个 arr[ltemp]）arr[ltemap]成为新坑
                arr[rtemp] = arr[ltemp];
                rtemp--;
            }
            printArr(arr, ltemp, rtemp);
        }
        //将一次循环内左指针的位置 设置为基数 这样以左是小于等于基数的值 以右是大约等于基数的值
        arr[ltemp] = base;
        printArr(arr, ltemp, rtemp);
        System.out.println("-----------------");
        quickSort(arr, left, ltemp);
        quickSort(arr, ltemp+ 1, right);
    }

    public static void main(String[] args) {
        int a = 5;
        int b = 5;
        a = a^b;
        b = a^b;
        a = a^b;
        System.out.println("a=" + a + ",b=" +b);
        Random random = new Random();
        int[] arr = new int[6];
        for (int i=0; i<arr.length; i++){
            arr[i] = random.nextInt(100);
        }
        System.out.print("before=");
        printArr(arr);

        System.out.println("-----------------");
        quickSort(arr, 0, arr.length - 1);

        System.out.print("after=");
        printArr(arr);
    }

    private static void printArr(int[] arr){
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }

    private static void printArr(int[] arr, int left, int right){
        System.out.print("ltemp=" + left + ", rtemp=" + right + ", arr=");
        for (int num : arr){
            System.out.print(num + " ");
        }
        System.out.println();
    }
}
