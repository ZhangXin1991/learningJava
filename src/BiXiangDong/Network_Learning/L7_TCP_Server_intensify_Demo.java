package BiXiangDong.Network_Learning;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class L7_TCP_Server_intensify_Demo {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动");
        //  服务端接收客户端发送过来的数据, 并打印到控制台上

        //  1, 创建服务端对象  new ServerSocket(port:接收端口);
        ServerSocket serverSocket = new ServerSocket(10002);

        //  2, 获取链接过来的客户端对象
        //      阻塞式, 如果没有客户端连接则等待;
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
        System.out.println("client: " + text+
        "ip: "+ip+", port: "+port);

        //  5, 使用客户端socket对象的输出流给客户端返回数据
        OutputStream socket_out = client_socket.getOutputStream();
        socket_out.write("收到".getBytes());

        //  6, 关闭客户端连接
        client_socket.close();
        //     关闭服务端连接. 通常不关闭服务端, 因本次只显示一次所以关闭
        serverSocket.close();
    }
}
