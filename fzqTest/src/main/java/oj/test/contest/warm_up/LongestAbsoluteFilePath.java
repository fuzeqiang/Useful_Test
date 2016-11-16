package oj.test.contest.warm_up;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by fuzeqiang(100918) on 2016/9/29 0029.
 */
public class LongestAbsoluteFilePath {

    public static final char SLASH = '\\';
    public static final char ENTER = 'n';
    public static final char TAB = 't';
    public static final char DOT = '.';

    public int lengthLongestPath(String input) {
        int length = 0;
        int deep = 0;
        String[] arr = input.split("\\\\n");
        int arrLength = arr.length;

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arrLength; i++) {
            String temp = arr[i];
            if (0 == sb.length()) {
                int tempDeep = temp.lastIndexOf("\\t");
                tempDeep = -1 == tempDeep ? 0 : tempDeep;
                temp = temp.replaceAll("\\t", "");

                if (deep < tempDeep) {//深度变大，拼接目录文件
                    sb.append("/" + temp);
                } else {//深度变小或不变，往前替换目录文件
                    int upCount = tempDeep - deep;
                    String reverse = sb.reverse().toString();
                    for (int j = 0; j <= upCount; j++) {
                        reverse = reverse.replaceFirst(".*/", "");
                    }
                }

                if(temp.contains(".")) {
                    int tempLentgh = sb.length();
                    length = length > tempLentgh ? length : tempLentgh;
                }
            } else {
                sb.append(temp);
            }
        }

        return length;
    }

    public int test(String input) {
        int length = 0;
        boolean isFile = false;
        int arrLength = input.length();

        List<StringBuilder> list = new ArrayList<StringBuilder>();
        StringBuilder dirOrFile = new StringBuilder();
        int currentDeep = 0;
        for (int i = 0; i < arrLength; i++) {
            char ch = input.charAt(i);
            switch (ch) {
                case SLASH :
                    ch = input.charAt(++i);
                    if (ENTER == ch) {
                        if (list.isEmpty()) {
                            list.add(dirOrFile);
                        } else {
                            if (currentDeep <= list.size() && list.size() > 1) {//目录回退
                                int backDeep = list.size() - currentDeep;
                                while (0 <= backDeep) {
                                    list.remove(list.size() - 1);
                                }
                            }
                            list.add(dirOrFile);

                            if (isFile) {
                                int tempLength = 0;
                                for (StringBuilder sb : list) {
                                    tempLength += sb.length();
                                }
                                tempLength = tempLength + list.size() - 1;
                                length = length > tempLength ? length : tempLength;
                            }
                        }

                        dirOrFile = new StringBuilder();
                        currentDeep = 0;
                        isFile = false;
                    } else {
                        currentDeep++;
                    }
                    break;
                case DOT :
                    isFile = true;
                    dirOrFile.append(DOT);
                    break;
                default:
                    dirOrFile.append(ch);
                    break;
            }
        }

        return length;
    }

    public static void main(String[] args) {
        String s = "dir\\n\\tsubdir1\\n\\t\\tfile1.ext\\n\\t\\tsubsubdir1\\n\\tsubdir2\\n\\t\\tsubsubdir2\\n\\t\\t\\tfile2.ext";
        System.out.println(new LongestAbsoluteFilePath().test(s));
//        System.out.println(Arrays.toString(s.split("\\\\n")));
//        System.out.println("\\t\\tfile1.ext".replace("\\t", ""));
//        System.out.println("\\t\\tfile1.ext".lastIndexOf("\\t"));
//        System.out.println("\\t\\tfile1.ext".contains("."));
//        System.out.println("dir/test1/test2/tx.txt".replaceFirst("/.*$", ""));
    }
}
