package algorithm;

/**
 * @author: duke
 * @date: 2019/7/9 9:46 PM
 */
public class ErArraySelect {

    public static void main(String[] args) {
        int arr[][] = {{2, 3, 4, 5, 6}, {12, 13, 14, 15, 16}, {22, 23, 24, 25, 26}, {32, 33, 34, 35, 36}};
        System.out.println(arr[0].length + ":" + arr.length);
        boolean num = findNum(arr, arr.length, arr[0].length, 34);
        System.out.println(num);
    }

    /**
     * 规则二位数组查找数字是否存在
     * @param arr 二位数组
     * @param rows 数组行数
     * @param columns 列数
     * @param num 查找的数字
     * @return
     */
    public static boolean findNum(int arr[][], int rows, int columns, int num){
        int row = 0;
        int column=  columns - 1;
        if (arr != null && rows > 0 && columns > 0){
            while (row < rows && column >= 0){
                if (arr[row][column] == num){
                    return true;
                }else if (arr[row][column] > num){
                    --column;
                }else {
                    ++row;
                }
            }
        }
        return false;
    }
}
