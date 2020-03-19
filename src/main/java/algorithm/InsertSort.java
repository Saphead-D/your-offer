package algorithm;

/**
 * 插入排序
 */
public class InsertSort {
    public static void sort(int[] arr){
        for (int i=1; i < arr.length; i++){
            int insertVal = arr[i];//插入的数
            int index = i - 1;//被插入的位置，准备和前一个数比较
            //如果插入的数比被插入位置的数小
            while (index >= 0 && insertVal < arr[index]){
                //arr[index]向后移动
                arr[index + 1] = arr[index];
                //index向前移动
                index--;
            }
            //把插入的数放入合适的位置
            arr[index + 1] = insertVal;
        }
    }

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 6, 11, 4, 1, 15, 5};
        sort(arr);
        for (int a : arr){
            System.out.print(a + " ");
        }
        System.out.println();
    }
}
