package BiXiangDong.Network_Learning;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

/**
 * URI 与 URL
 *  java.net.URI
 *  java.net.URL
 *      URI表示统一资源标识符(URI)引用
 *      URN表示统一资源名称
 *      URL表示统一资源定位符
 */
public class L8_URL_Demo {
    public static void main(String[] args) throws IOException {
//        String str_url = "http://192.168.2.101:9090/";
        String str_url = "https://baidu.com/";

        URL url = new URL(str_url);

        //  协议
        System.out.println("getProtocol: "+url.getProtocol());
        //  地址
        System.out.println("getHost: "+url.getHost());
        //  端口
        System.out.println("getPort: "+url.getPort());
        //  文件
        System.out.println("getFile: "+url.getFile());
        //  路径
        System.out.println("getPath: "+url.getPath());
        //  参数信息
        System.out.println("getQuery: "+url.getQuery());

        //  获取这个url的资源流
        InputStream in = url.openStream();
        //  url.openStream();方法等价于openConnection.getInputStream();方法
/*=============================================================================*/

        //  获取Url连接器对象  最常用
        // 将连接封装成了对象: java中内置的可以解析的具体协议的对象+socket
//        sun.net.www.protocol.https.DelegateHttpsURLConnection:https://baidu.com/
        URLConnection conn = url.openConnection();
        System.out.println(conn);

        byte[] buf = new byte[1024];
        int len = in.read(buf);
        String text = new String(buf, 0, len);
        System.out.println(text);
        String value = conn.getHeaderField("Content-Type");
        System.out.println(value);  //  text/html
        //  相当于 加了协议的url.openStream;
        InputStream connIn = conn.getInputStream();



        in.close();
    }

}
