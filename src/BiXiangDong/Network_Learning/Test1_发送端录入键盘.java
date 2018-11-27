package BiXiangDong.Network_Learning;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

public class Test1_发送端录入键盘 {
    public static void main(String[] args) throws IOException {
        System.out.println("发送端启动....");
        DatagramSocket ds = new DatagramSocket(8888);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = br.readLine())!=null) {

            byte[] buf = line.getBytes();
            DatagramPacket dp =
                    new DatagramPacket(buf, buf.length,
                    InetAddress.getByName("192.168.2.101"), 10000);
            ds.send(dp);
            if ("over".equals(line)) {
                break;
            }
        }
        ds.close();
    }
}
