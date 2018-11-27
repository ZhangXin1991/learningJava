package BiXiangDong.Network_Learning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 模拟服务器
 */
public class Test6_myServer {
    public static void main(String[] args) throws IOException {
        ServerSocket ss = new ServerSocket(9090);
        Socket s = ss.accept();
        System.out.println(s.getInetAddress().getHostAddress());

        InputStream in = s.getInputStream();

        byte[] bufIn = new byte[1024];
        int len = in.read(bufIn);
        String text = new String(bufIn, 0, len);
        System.out.println(text);

//        PrintWriter out = new PrintWriter(s.getOutputStream(), true);
//        out.println("嘿嘿嘿嘿, 欢迎光临本服务器");
//        out.flush();

        OutputStream out = s.getOutputStream();
        BufferedOutputStream bOut = new BufferedOutputStream(out);
        bOut.write("heiheihei".getBytes());
        bOut.flush();

        s.close();
        ss.close();
    }
}
