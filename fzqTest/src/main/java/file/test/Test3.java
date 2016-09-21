package file.test;

import java.io.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Administrator on 2016/7/8 0008.
 */
public class Test3 {


    public static void test() {
        BufferedReader br = null;
        Map<String, List<School>> map = new HashMap<String, List<School>>();
        map.put("幼儿园", new ArrayList<School>());
        map.put("小学", new ArrayList<School>());
        map.put("初中", new ArrayList<School>());
        map.put("高中", new ArrayList<School>());
        map.put("中职", new ArrayList<School>());
        map.put("九义校", new ArrayList<School>());

        try {
            br = new BufferedReader(new FileReader(new File("D:/test.txt")));
            String line = br.readLine();
            String type = "";
            String master = "";

            while (null != line) {
                line = line.trim();
                if (!"".equals(line)) {
                    if (line.contains("教育局")) {
                        master = line;
                    } else if (map.containsKey(line)) {
                        type = line;
                    } else {
                        String[] arr = line.split("\t\t");
                        for (String s : arr) {
                            School school = new School();
                            school.setName(s);
                            school.setMaster(master);
                            school.setType(type);
                            map.get(type).add(school);
                        }
                    }
                }

                line = br.readLine();
            }

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
        }
        for (Map.Entry<String, List<School>> entry : map.entrySet()) {
            for (School school : entry.getValue()) {
                System.out.println(school.getName() + "," + school.getType() + "," + school.getMaster());
            }
        }
    }

    public static void main(String[] args) {
        test();
    }

}
