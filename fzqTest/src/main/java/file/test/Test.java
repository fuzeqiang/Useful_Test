package file.test;

import java.io.*;

/**
 * Created by Administrator on 2016/7/6 0006.
 */
public class Test {

    public static void main(String[] args) throws  Exception{
        File file = new File("D:/111.js");
        BufferedReader br = new BufferedReader(new FileReader(file));
        String line = br.readLine();
        PrintWriter pw = new PrintWriter(new FileOutputStream(new File("D:/222.txt")));
        int count = 0;
        while (null != line) {
            if (!"".equals(line)) {
                if (0 == count) {
                    pw.print(line + ",");
                    count++;
                } else if (1 == count) {
                    String[] arr = line.split(" ");
                    pw.print(arr[arr.length - 1] + ",");
                    count++;
                } else {
                    String[] arr = line.split(":");
                    pw.println(arr[arr.length - 1] );
                    count = 0;
                }
            }
            line = br.readLine();
        }
        br.close();
        pw.flush();;
        pw.close();
    }

}
