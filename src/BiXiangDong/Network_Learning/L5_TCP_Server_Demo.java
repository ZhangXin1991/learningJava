package BiXiangDong.Network_Learning;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class L5_TCP_Server_Demo {
    public static void main(String[] args) throws IOException {
        //  服务端接收客户端发送过来的数据, 并打印到控制台上
        /**
         *TCP传输, 建立tcp服务端的思路
         * 1, 创建服务端socket服务, 通过ServerSocket对象
         * 2, 服务端必须对外提供端口, 否则客户端无法连接.
         * 3, 获取连接过来的客户端对象.
         * 4, 通过客户端对象获取socket流读取客户端发来的数据
         *      并打印到控制台上
         * 5, 关闭资源.
         *      关掉客户端
         *      关掉服务端(必须断开)
         */
        //  1, 创建服务端对象
        ServerSocket serverSocket = new ServerSocket(10002);

        //  2, 获取链接过来的客户端对象
        Socket client_socket = serverSocket.accept();
        //     获得客户端ip地址
        String ip = client_socket.getInetAddress().getHostAddress();
        //     获取客户端连接端口
        int port = client_socket.getPort();

        //  3, 通过socket对象获取输入流, 要读取客户端发送来的数据
        InputStream socket_in = client_socket.getInputStream();

        //     读取字节输入流的数据..
        byte[] buf = new byte[1024];
        int len = socket_in.read(buf);
        String text = new String(buf, 0, len);

        //  4, 打印到控制台
        System.out.println("server: " + text+
        "ip: "+ip+", port: "+port);

        //  5, 关闭客户端连接
        client_socket.close();
        //     关闭服务端连接. 通常不关闭服务端, 因本次只显示一次所以关闭
        serverSocket.close();
    }
}
