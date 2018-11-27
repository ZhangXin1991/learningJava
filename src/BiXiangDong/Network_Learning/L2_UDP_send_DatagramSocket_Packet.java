package BiXiangDong.Network_Learning;

/**
 * Socket   网络服务端点  (不要按单词理解)
 *  Socket就是为网络服务提供的一种机制
 *  通信的两端都有Socket
 *  网络通信其实就是Socket间的通信
 *  数据在两个Socket间通过IO传输
 *
 * UDP传输
 *  DatagramSocket与DataGramPacket
 *  建立发送端, 接收端.
 *  建立数据包
 *  调用Socket的发送接收方法
 *  关闭Socket
 *  发送端与接收端是两个独立的运行程序
 */

import java.io.IOException;
import java.net.*;

/**
 *  DatagramSocket  数据报套接字
 *      java.net.DatagramSocket
 *      此类表示用来发送和接受数据包的套接字
 *      数据报套接字是包投递服务的发送或接受点.
 *      每个在数据报套接字上发送或接收的包都是单独编址和路由的.
 *      从一台机器发送到另一台机器的多个包可能选择不同的路由, 也可能按不同的顺序接收
 *
 *    构造方法摘要:
 *      DatagramSocket();
 *          构造数据报套接字并将去绑定到本地主机上任何可用的端口
 *      DatagramSocket(DatagramSocketImpl impl);
 *          创建带有指定DatagramSocketImpl的未绑定数据报套接字
 *      DatagramSocket(int port);
 *          创建数据报套接字并将其绑定到本地主机上的指定端口
 *      DatagramSocket(int port, InetAddress laddr);
 *          创建数据报套接字, 将其绑定到指定的本地地址
 *      DatagramSocket(SocketAddress bindaddr);
 *          创建数据报套接字, 将其绑定到指定的本地套接字地址
 *  DatagramPacket  数据报包
 */

public class L2_UDP_send_DatagramSocket_Packet {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动");
        /**
         * 创建UDP传输的发送端
         * 思路:
         *  1, 建立UDP的socket服务
         *  2, 将要发送的数据封装到数据包中
         *  3, 通过UDP的socket服务将数据包发送出去, 指定地址, 指定端口号
         *  4, 关闭socket服务
         */
        //1, UDP的socket服务. 使用DatagramSocket对象
        DatagramSocket ds = new DatagramSocket();
        //2, 将要送的数据封装到数据包中.     本地ip: "192.168.2.101"
        String string = "udp传输演示,  诶嘿嘿";
        //  使用DatagramPacket将数据封装到数据包中
        byte[] buf = string.getBytes();
        //  DatagramPacket(字节数组, 要发送的长度, 地址, 指定接收端口号)
        DatagramPacket dp = new DatagramPacket(buf, buf.length,
                InetAddress.getByName("192.168.2.101"), 10000);
        //3, 通过UDP的socket服务将数据包发送出去.使用send方法
        ds.send(dp);    //  ds.send(DatagramPacket dp);
        //4, 关闭资源
        ds.close();
    }
}
