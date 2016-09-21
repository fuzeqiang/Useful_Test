package file.test;

import java.io.*;

/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class Test4 {

    public static void main(String[] args) {
        test("D:/test.txt", "D:/test-re4.txt");
    }

    public static void test(String path, String des) {
        BufferedReader br = null;
        PrintWriter pw = null;

        try {
            br = new BufferedReader(new FileReader(new File(path)));
            pw = new PrintWriter(new FileOutputStream(des));

            String line = br.readLine();
            String master = "";
            int count = 0;
            String name = "";
            String addr = "";
            while (null != line) {
                line = line.trim();
                if (!"".equals(line)) {
                    if (line.startsWith("（")) {
                        master = line.substring(1, line.length() - 1);
                        pw.println(master);
                        count = 0;
                        line = br.readLine();
                        continue;
                    }
                }

                if (0 == count % 2) {
                    name = line;
                    if (line.contains("：")) {
                        name = name.split("：")[1];
                    }
                    if (line.contains(":")) {
                        name = name.split(":")[1];
                    }
                    pw.print(name + ",");
                } else {
                    addr = line;
                    if (addr.contains("：")) {
                        addr = addr.split("：")[1];
                    }
                    if (addr.contains(":")) {
                        addr = addr.split(":")[1];
                    }
                    pw.println(addr);
                }

                line = br.readLine();
                count++;
            }
            pw.flush();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                br.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            pw.close();
        }
    }

}
