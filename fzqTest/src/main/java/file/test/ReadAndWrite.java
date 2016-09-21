package file.test;

import java.io.*;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class ReadAndWrite {

    public static void test1() {
        File file = new File("D:/test.txt");
        try {
            BufferedReader br = new BufferedReader(new FileReader(file));
            PrintWriter pw = new PrintWriter(new FileOutputStream("D:/test2.txt"));
            String line = br.readLine();
            while (null != line) {
                if (!"".equals(line)) {
                    pw.println(line);
                }
                line = br.readLine();
            }

            br.close();
            pw.flush();
            pw.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        test1();
    }

}
