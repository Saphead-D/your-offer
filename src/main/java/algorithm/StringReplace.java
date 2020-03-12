package algorithm;

/**
 * 字符串替换
 * @author: duke
 * @date: 2019/7/9 10:25 PM
 */
public class StringReplace {

    public static void main(String[] args) {
        String str = "we are happy";
        char[] chars = str.toCharArray();
        char[] newChars = new char[16];
        for (int i = 0; i < chars.length; i++) {
            newChars[i] = chars[i];
        }
        System.out.println("old chars:" + toString(chars));
        System.out.println("new chars:" + toString(newChars));
        replaceBlank(newChars, ' ', "%20");
        System.out.println("after new  chars:" + toString(newChars));
        replaceBlank(newChars, 'e', "_");
        System.out.println("after new  chars:" + toString(newChars));
    }

    private static String toString(char[] chars){
        StringBuilder builder = new StringBuilder();
        for (char c : chars){
            if (c == '\u0000'){
                break;
            }
            builder.append(c);
        }
        return builder.toString();
    }

    /**
     * 字符替换
     * @param chars 容量较大的连续字符数组
     * @param replace 需要替换的字符
     * @param source 替换后字符
     */
    private static void replaceBlank(char[] chars, char replace, String source){
        if (chars == null){
            return;
        }
        int count = 0;
        int oldLen = 0;
        int i = 0;
        while ( i < chars.length && chars[i] != '\u0000'){
            oldLen++;
            if (chars[i] == replace){
                count++;
            }
            i++;
        }

        //新数组长度
        int newStrLen = oldLen + count * (source.length() - 1);

        if (newStrLen > chars.length){
            return;
        }

        int oldIndex = oldLen - 1;
        int newIndex = newStrLen - 1;
        char[] tem = source.toCharArray();
        while (oldIndex >= 0) {
            if (chars[oldIndex] == replace) {
                for (int index = tem.length - 1; index >= 0; index--) {
                    chars[newIndex--] = tem[index];
                }
            } else {
                chars[newIndex--] = chars[oldIndex];
            }
            oldIndex--;
        }
    }
}
