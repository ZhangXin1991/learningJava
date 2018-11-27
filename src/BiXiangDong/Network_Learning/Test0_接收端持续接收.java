package BiXiangDong.Network_Learning;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class Test0_接收端持续接收 {
    public static void main(String[] args) throws IOException {
        System.out.println("接收端启动");
        DatagramSocket ds = new DatagramSocket(10000);

        while (true) {

            byte[] buf = new byte[1024];
            DatagramPacket dp = new DatagramPacket(buf, buf.length);
            ds.receive(dp); //  receive是阻塞式的方法
            int port = dp.getPort();
            String ip = dp.getAddress().getHostAddress();
            String text = new String(dp.getData(), 0, dp.getLength());
            System.out.println(ip + ":" + port + ":" + text);

            if ("over".equals(text)) {
                break;
            }
        }
//        DatagramSocket ds = new DatagramSocket(10000);
//        byte[] buf = new byte[1024];
//        DatagramPacket dp = new DatagramPacket(buf, buf.length);
//        ds.receive(dp); //  receive是阻塞式的方法
//        String ip = dp.getAddress().getHostAddress();
//        int port = dp.getPort();
//        String text = new String(dp.getData(), 0, dp.getLength());
//        System.out.println(ip+ ":" +port+":"+text);

//        ds.close();
    }

}
