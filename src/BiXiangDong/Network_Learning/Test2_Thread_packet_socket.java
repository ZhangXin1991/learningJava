package BiXiangDong.Network_Learning;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;

/**
 * UDP练习:
 *  利用多线程, 同时接收发送数据
 */
public class Test2_Thread_packet_socket {

    public static void main(String[] args) throws IOException {
        DatagramSocket receive = new DatagramSocket(9000);//    我的接收端口9000
        DatagramSocket send = new DatagramSocket(10000);//  我的传输端口 1000
        PacketAndSocket_receive p1 = new PacketAndSocket_receive(receive);
        PacketAndSocket_send p2 = new PacketAndSocket_send(send);
        //  下两行是两个中转类...可以纳入PacketAndSocket_receive/send类中
        Receive r = new Receive(p1);
        Send s = new Send(p2);

        Thread thread0 = new Thread(r);
        Thread thread1 = new Thread(s);
        thread0.start();
        thread1.start();
    }


}

class PacketAndSocket_receive {
    private DatagramSocket ds;

    public PacketAndSocket_receive(DatagramSocket ds) {
        this.ds = ds;
    }

    //  接收端
    public void thread1() throws IOException {
        System.out.println("接收端启动");
        byte[] buf = new byte[1024];
        DatagramPacket datagramPacket1 = new DatagramPacket(buf, 0, buf.length);
        while (true) {
            this.ds.receive(datagramPacket1);
            String ip = datagramPacket1.getAddress().getHostAddress();
            int port = datagramPacket1.getPort();
            String text = new String(datagramPacket1.getData(), 0 , datagramPacket1.getLength());
            System.out.println("ip: " + ip + ", port: " + port + ", text: " + text);

            if ("over".equals(text)) {
                System.out.println("ip: " + ip/*+", port: "+port*/ + " 退出对话");
            }
        }
//        datagramSocket1.close();
    }

}
class PacketAndSocket_send {
    private DatagramSocket ds;

    public PacketAndSocket_send(DatagramSocket ds) {
        this.ds = ds;
    }

    //  发送端
    public void thread2() throws IOException {
        System.out.println("发送端启动");
        BufferedReader bufferedReader =
                new BufferedReader(new InputStreamReader(System.in));
        String line = null;
        while ((line = bufferedReader.readLine()) != null) {
            DatagramPacket datagramPacket = new DatagramPacket(
                    line.getBytes(), line.length(),
                    InetAddress.getByName("192.168.2.101"), 9000);  //  返送到对方端口9000
            this.ds.send(datagramPacket);
            if ("over".equals(line)) {
                break;
            }
        }
        this.ds.close();
    }
}

class Send implements Runnable {
    PacketAndSocket_send send;
    public Send(PacketAndSocket_send send) {
        this.send = send;
    }

    @Override
    public void run() {
        try {
            send.thread2();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Receive implements Runnable {
    PacketAndSocket_receive receive;

    public Receive(PacketAndSocket_receive receive) {
        this.receive = receive;
    }

    @Override
    public void run() {
        try {
            receive.thread1();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}