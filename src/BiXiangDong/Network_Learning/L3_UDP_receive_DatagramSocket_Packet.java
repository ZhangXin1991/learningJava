package BiXiangDong.Network_Learning;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.SocketException;

public class L3_UDP_receive_DatagramSocket_Packet {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动");
        /**
         * 创建UDP传输的接收端
         * 思路:
         *  1, 建立UDP的socket服务, 因为是接收数据, 必须要明确端口号.
         *  2, 创建数据包, 用于存储接收到的数据, 方便用数据包对象的方法解析这些数据
         *  3, 使用socket服务的receive方法将接收的数据存储到数据包中
         *  4, 通过数据包的方法解析数据包中的数据
         *  5, 关闭资源
         */
        //1, 建立UDP的socket服务, 绑定端口号10000
        DatagramSocket ds = new DatagramSocket(10000);
        //2, 创建数据包
        byte[] buf = new byte[1024];
        //  DatagramPacket(字节数组, 读取长度);
        DatagramPacket dp = new DatagramPacket(buf, buf.length);
        //3, 使用接收方法将数据存储到数据包中
        ds.receive(dp); //  receive是阻塞式的方法
        //4, 通过数据包对象的方法, 解析数据包中的数据, 比如:地址, 端口, 数据内容
        //  dp.获取IP地址对象.获取IP地址字符串表示形式
        String ip = dp.getAddress().getHostAddress();
        //  获取端口, 返回int类
        int port = dp.getPort();
        //  获取数据:   new String(数据包数据, 起始, 结尾);
        String text = new String(dp.getData(), 0, dp.getLength());
        //  打印
        System.out.println(ip+ ":" +port+":"+text);
        //  关闭资源
        ds.close();
    }
}
