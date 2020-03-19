package algorithm;

public class ShellSort {

    public static void sort(int [] arr){
        //增量gap，初始为数组一半，并逐步缩小增量
        for (int gap = arr.length / 2; gap > 0; gap = gap / 2){
            //从第gap个元素，逐个对其所在组进行直接插入排序操作
            for (int i = gap; i<arr.length; i++){
                int insertVal = arr[i];//插入数
                int index = i - gap;//被插入的位置，准备和前gap数比较
                while (index >= 0 && insertVal < arr[index]){
                    arr[index + gap] = arr[index];
                    index -= gap;
                }
                arr[index + gap] = insertVal;
            }
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 11, 4, 1, 15, 5, 0};
        sort(arr);
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
