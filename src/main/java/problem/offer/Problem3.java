package problem.offer;

/**
 * 二维数组查找指定数
 * @author: duke
 * @date: 2019/9/23 5:51 PM
 */
public class Problem3 {

    public static void main(String[] args) {
        int[][] a = new int[4][4];
        a[0][0]=1;
        a[0][1]=2;
        a[0][2]=8;
        a[0][3]=9;
        a[1][0]=2;
        a[1][1]=4;
        a[1][2]=9;
        a[1][3]=12;
        a[2][0]=4;
        a[2][1]=7;
        a[2][2]=10;
        a[2][3]=13;
        a[3][0]=6;
        a[3][1]=8;
        a[3][2]=11;
        a[3][3]=15;
        System.out.println(find(a, 7));
    }

    public static boolean find(int[][] arr, int num){
        if (arr == null || arr.length <= 0){
            return false;
        }
        int row = 0;//第一行
        int column = arr[0].length - 1;//最后一列
        while (row < arr.length && column >= 0){
            if (arr[row][column] == num){
                return true;
            }else if (arr[row][column] > num){
                column--;
            }else {
                row++;
            }
        }
        return false;
    }
}
