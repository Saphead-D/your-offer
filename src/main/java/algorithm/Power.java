package algorithm;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * 数值的整数次方
 * @author: duke
 * @date: 2019/7/29 6:27 PM
 */
public class Power {

    public static void main(String[] args) {
        double power = powerWithExponent(4, 3);
        System.out.println(power);
        ArrayList<Object> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        ArrayList<Object> list2 = list;
        list2.set(0, 4);
        System.out.println(list);
        System.out.println(list2);

        new HashMap<>(16);
        System.out.println(1 | 2);
        System.out.println(1 ^ 2);
    }

    private static double powerWithExponent(double base, int exponent){
        if (exponent == 0){
            return 1;
        }
        if (exponent == 1){
            return base;
        }
        double result = powerWithExponent(base, exponent >> 1);
        result *= result;
        //判断是否是奇数
        if ((exponent & 0x1) == 1){
            result *= base;
        }
        return result;
    }
}
