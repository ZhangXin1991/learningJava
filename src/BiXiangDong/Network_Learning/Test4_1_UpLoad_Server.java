package BiXiangDong.Network_Learning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * TCP练习:
 *  接收图片
 *  用服务端接收客户端发送的图片
 */

public class Test4_1_UpLoad_Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server_socket = new ServerSocket(10003);

        Socket client_socket = server_socket.accept();
        String ip = client_socket.getInetAddress().getHostAddress();
        System.out.println(ip+"......connected");
        File pic_dir = new File("C:\\Users\\65404\\Desktop\\" +
                "learningJava\\test\\2018_11_4_socket_serverAndClient_UpLoad\\picture");
        if (pic_dir.exists()) {
            pic_dir.createNewFile();
        }
        File pic_file = new File(pic_dir, ip+".jpg");

        InputStream client_in = client_socket.getInputStream();

        FileOutputStream file_out = new FileOutputStream(pic_file);
        byte[] bufF = new byte[1024];
        int lenF = 0;
        while ((lenF = client_in.read(bufF)) != -1) {
            file_out.write(bufF, 0, lenF);
            file_out.flush();
        }
        OutputStream client_out = client_socket.getOutputStream();
        client_out.write("上传成功".getBytes());

        file_out.close();
        client_socket.close();
        server_socket.close();
    }
}
