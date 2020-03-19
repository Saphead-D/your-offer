package algorithm;

/**
 * 二分查找  要求待查找的序列有序
 */
public class BiSearch {

    /**
     * 二分查找
     * @param arr 序列有序
     * @param a 待查找的数
     * @return
     */
    public static int biSearch(int [] arr, int a){
        int low = 0;
        int high = arr.length - 1;
        int mid;
        while (low <= high){
            mid = (low + high) / 2;
            if (arr[mid] == a){
                return mid;
            }else if (arr[mid] < a){
                low = mid + 1;
            }else {
                high = mid - 1;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int [] arr = new int[]{1,3,4,5,6,7};
        int a = 5;
        System.out.println( biSearch(arr, a));
    }
}
