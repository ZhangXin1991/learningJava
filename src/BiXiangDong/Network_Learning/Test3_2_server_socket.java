package BiXiangDong.Network_Learning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 2, 创建服务端:
 *     - 创建serverSocket端点
 *     - 获取客户端连接对象, 并接收同意接受客户端对象连接
 *     - 获取客户端连接对象的网络输入流
 *     - 创建字节读取流读取对象用于读取客户端的网络输入流的数据
 *     - 将这些数据转换为大写
 *     - 创建客户端连接对象的网络输出流
 *     - 创建字节输出流用于输出给客户端的网络输出流输出数据, 并将这些转为大写的数据输出
 */
public class Test3_2_server_socket {
    public static void main(String[] args) throws IOException {
        System.out.println("服务端启动!");


        //  1, 创建服务端,   指定接收端口10003
        ServerSocket server_socket = new ServerSocket(10003);

        //  2, 获取客户端连接过来的对象
        Socket client_socket = server_socket.accept();


        //  3, 创建字节输入流 并 接收客户端发来的网络字节流
        BufferedReader br_client = new BufferedReader(
                new InputStreamReader(client_socket.getInputStream(), "UTF-8")
        );

        //  获取客户端连接对象的ip port信息
        int port = client_socket.getPort();
        String ip = client_socket.getInetAddress().getHostAddress();

        String line = null;
        //  4, 创建字节输出流, 并 关联输出给客户端的网络流
//        BufferedWriter bw_client = new BufferedWriter(
//                new OutputStreamWriter(client_socket.getOutputStream(), "UTF-8")
//        );
// 需要使用PrintWriter类, 因为BufferedWriter类的未知原因,
// 只有当输入over时,才会将所有打印的字符串发送并关闭连接.
        PrintWriter p_client = new PrintWriter(client_socket.getOutputStream(), true);

        while ((line = br_client.readLine()) != null) {
            System.out.println("ip: "+ip+", port: "+port+" :"+line);
//            bw_client.write(line.toUpperCase(), 0, line.length());
//            bw_client.flush();
            p_client.println(line.toUpperCase());
            if ("over".equals(line)) {
                break;
            }
        }
//        client_socket.close();
//        server_socket.close();
    }
}
