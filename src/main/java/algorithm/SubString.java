package algorithm;

import java.util.*;

/**
 * 最长不重复子串
 */
public class SubString {
    /**
     * 动态规划法：定义函数f(i)为：以第i个字符为结尾的不含重复字符的子字符串的最大长度。
     * 　　（1）当第i个字符之前未出现过，则有：f(i)=f(i-1)+1
     * 　　（2）当第i个字符之前出现过，记该字符与上次出现的位置距离为d
     * 　　　　1）如果d<=f(i-1)，则有f(i)=d；
     * 　　　　2）如果d>f(i-1)，则有f(i)=f(i-1)+1；
     * 我们从第一个字符开始遍历，定义两个int变量preLength和curLength来分别代表f(i-1)和f(i)，
     * 再创建一个长度为26的pos数组来存放26个字母上次出现的位置，即可根据上述说明进行求解。
     * 注意：每次最大长度和字母出现位置要记得更新。
     * @param str
     * @return
     */
    public static int  maxLength(String str) {
        if (str == null || str.length() <= 0){
            return 0;
        }
        int preLength = 0;//即fi(i-1)
        int curLength = 0;//即fi(i)
        int maxLength = 0;
        int[] pos= new int[26];  //用于存放字母上次出现的位置
        Arrays.fill(pos, -1);
        Set<String> set = new LinkedHashSet<>();
        StringBuilder builder = new StringBuilder("");
        for (int i=0; i<str.length(); i++){
            int letterNum = str.charAt(i) - 'a';//字母在pos中的下标
            if (pos[letterNum] <0 || i - pos[letterNum] > preLength){
                curLength = preLength + 1;
                builder.append(str.charAt(i));
            }else {
                curLength = i - pos[letterNum];
                //将上一次无重复子串保存
                set.add(builder.toString());
                //以fi(i)子串为起始
                builder = new StringBuilder(str.substring(pos[letterNum] + 1, i+1));
                set.add(str.substring(pos[letterNum] + 1, i+1));
            }
            pos[letterNum] = i;//更新字母出现位置
            if (curLength > maxLength){
                maxLength = curLength;
            }
            preLength = curLength;
        }
        //加入最后的子串
        set.add(builder.toString());
        for (String s : set){
            System.out.println(s);
        }
        return maxLength;
    }

    public static void main(String[] args) {
        System.out.println(maxLength("arabcacfr")==4);
    }
}
