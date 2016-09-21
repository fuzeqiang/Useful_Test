package xml.test;

import org.dom4j.Document;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;

/**
 * Created by Administrator on 2016/7/12 0012.
 */
public class Test {

    public static void main(String[] args) throws Exception{
//        BufferedReader br = new BufferedReader(new FileReader(new File("D:/test.xml")));
//        String xml = null;
//        String line = br.readLine();
//        while (null != line) {
//            xml += line;
//            line = br.readLine();
//        }
//
//        br.close();

        Document doc = new SAXReader().read(new File("D:/test.xml"));
        List<Element> elements = doc.getRootElement().elements();
        for (Element e : elements) {
            Element element = e.element("a");
            if (null == element) {
                System.out.println(e.getData());
            } else {
                System.out.println(element.getData());
            }
        }
    }

}
