package BiXiangDong.Network_Learning;

import java.io.*;
import java.net.Socket;

/**
 * TCP练习:
 *  上传图片
 *  用客户端给服务端发送一个图片
 */
public class Test4_0_UpLoad_Client {
    public static void main(String[] args) throws IOException {
        Socket client_socket = new Socket("192.168.2.101", 10003);

        File pic_file = new File("C:\\Users\\65404\\Desktop\\" +
                "learningJava\\test\\2018_11_4_socket_serverAndClient_UpLoad" +
                "\\picture", "c52b1bf5c924d2ed808805ebf2d1feb3.jpg");

        FileInputStream file_in = new FileInputStream(pic_file);
        byte[] buf = new byte[1024];
        int len = 0;
//        OutputStream client_out = client_socket.getOutputStream();

        BufferedOutputStream client_out = new BufferedOutputStream(client_socket.getOutputStream());

        while ((len=file_in.read(buf)) != -1) {
            client_out.write(buf, 0, len);
            client_out.flush();
        }

        client_socket.shutdownOutput();

//        BufferedReader client_in = new BufferedReader(new InputStreamReader(client_socket.getInputStream()));
//        System.out.println(client_in.readLine());
        InputStream client_in = client_socket.getInputStream();
        byte[] buf_in = new byte[1024];
        int len_in = client_in.read(buf_in);
        String text = new String(buf_in, 0, len_in);
        System.out.println(text);

        file_in.close();
        client_socket.close();
    }
}
