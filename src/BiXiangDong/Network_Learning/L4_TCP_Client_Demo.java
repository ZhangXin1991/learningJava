package BiXiangDong.Network_Learning;

import java.io.IOException;
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

public class L4_TCP_Client_Demo { //  client : 客户端
    public static void main(String[] args) throws IOException {
//  客户端发送数据到服务器端
        /**
         * TCP传输, 建立tcp客户端的思路
         * 1, 创建tcp客户端socket服务, 使用的是Socket对象
         * 建议该对象一经创建就明确目的地. 要连接的主机
         * 2, 如果连接建立成功, 说明数据传输通道已建立.
         * 该通道就是socket流(网络流), 是底层建立好的.
         * 既然是流, 说明这里既有输入, 又有输出.
         * 如果需求输入流或者输出流对象, 可以找Socket类来获取
         * 可以通过socket.getOutputStream();和getInputStream();来获取
         * 3, 使用输出流, 将数据写出.
         * 4, 关闭资源......
         */
        //  1, 创建socket服务.  new Socket(目标IP地址, 目标端口号);
        Socket socket = new Socket("192.168.2.101", 10002);

        //  2, 获取socket流中的输出流
        OutputStream socket_out = socket.getOutputStream();

        //  3, 使用输出流将制定法的数据写出去
        socket_out.write("tcp演示: ".getBytes());

        //  4, 关闭资源
        socket.close();
    }
}


