package BiXiangDong.Network_Learning;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * TCP传输
 *  Socket类      ServerSocket类
 *  建立客户端     服务器端
 *  建立连接后, 通过Socket中的IO流进行数据的传输
 *  关闭socket
 * 同样, 客户端与服务器端是两个独立的应用程序
 */

public class L6_TCP_Client_intensify_Demo { //  client : 客户端
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动");
        //  客户端发送数据到服务器端

        //  1, 创建socket服务.  new Socket(目标IP地址, 目标端口号);
        Socket socket = new Socket("192.168.2.101", 10002);

        //  2, 获取socket流中的输出流
        OutputStream socket_out = socket.getOutputStream();

        //  3, 使用输出流将制定法的数据写出去
        socket_out.write("tcp演示: ".getBytes());

        //  4, 读取服务端返回的数据, 通过socket对象获取输入流
        InputStream socket_in = socket.getInputStream();
        int port = socket.getPort();
        String ip = socket.getInetAddress().getHostAddress();
        byte[] buf = new byte[1024];  // 字节的容器
        int len = socket_in.read(buf);// buf的大小
        String text = new String(buf, 0, len);


        System.out.println("ip: "+ip+", port:"+port+" "+text);


        //  5, 关闭资源
        socket.close();
    }
}


