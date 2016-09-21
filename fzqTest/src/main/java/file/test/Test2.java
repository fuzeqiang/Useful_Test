package file.test;

import java.io.*;
import java.lang.annotation.Annotation;

/**
 * Created by Administrator on 2016/7/7 0007.
 */
public class Test2 {

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new FileReader(new File("D:/test.txt")));
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("D:/test.csv")));
        String line = br.readLine();
        int lineNum = 0;
        while (null != line) {
            if (!"".equals(line.trim())) {
//                if (line.indexOf("地址：") != -1) {
//                    addr = line.split("地址：")[1];
//                }
                if (lineNum % 2 == 0) {
                    pw.print(line.trim() + ",");
                } else {
                    pw.println(line.trim());
                }
            }
            line = br.readLine();
            lineNum++;
        }

        pw.flush();
        br.close();
        pw.close();
    }

}
