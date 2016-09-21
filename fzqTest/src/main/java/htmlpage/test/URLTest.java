package htmlpage.test;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.io.SAXReader;

import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by Administrator on 2016/7/5 0005.
 */
public class URLTest {

    public static final String PROTOCOL = "<?xml version=\"1.0\" encoding=\"UTF-8\"?>";

    public static String getHtml(String urlString) {
        try {
            StringBuffer html = new StringBuffer();
            URL url = new URL(urlString);
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();
            InputStreamReader isr = new InputStreamReader(conn.getInputStream());
            BufferedReader br = new BufferedReader(isr);
            String temp;
            while ((temp = br.readLine()) != null) {
                html.append(temp).append("\n");
            }
            br.close();
            isr.close();
            return html.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static void main(String[] args) {
        String html = getHtml("http://www.nxedu.gov.cn:8080/maile/office/areaoffice.html");
        String body = PROTOCOL + html.substring(html.indexOf("<table>"), html.indexOf("</table>") + 7);
//        System.out.println(html.indexOf("<body>"));
//        System.out.println(html.indexOf("</body>"));
        try {
            Document doc = new SAXReader().read(new ByteArrayInputStream(body.getBytes("UTF-8")));
            System.out.println(doc.getRootElement());
        } catch (DocumentException e) {
            e.printStackTrace();
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

    }

}
