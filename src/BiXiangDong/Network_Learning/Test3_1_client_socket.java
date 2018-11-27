package BiXiangDong.Network_Learning;

import java.io.*;
import java.net.Socket;

/**
 * 1, 创建客户端:
 *     - 创建socket端点
 *     - 获取客户端网络输出流
 *     - 获取客户端输出源,
 *         此处源为 读取键盘录入,
 *         所以还要创建字节读取流读取键盘录入
 *     - 将客户端输出源的数据通过客户端网络输出流发送给服务端
 *     - 获取客户端网络输入流, 用于获取服务端发送过来的数据
 *     - 创建字节读取流, 用于读取网络输入流的数据(服务端发送来的数据)
 */
public class Test3_1_client_socket {
    public static void main(String[] args) throws IOException {
        System.out.println("客户端启动!");


        //  1, 创建客户端, 并指定目标ip地址 与 目标端口号
        Socket client_socket = new Socket(
                "192.168.2.101", 10003);
        //  2, writer socket 创建字符输出流, 并使用客户端对象拿到网络输出流
//        BufferedWriter bw_client = new BufferedWriter(
//                new OutputStreamWriter(client_socket.getOutputStream(), "UTF-8")
//        );
        PrintWriter p_client = new PrintWriter(client_socket.getOutputStream(), true);

        //  3, read keyboard 创建字节读取流, 并关联控制台输入的数据
        BufferedReader br_console = new BufferedReader(
                new InputStreamReader(System.in, "UTF-8"));
        //  4, read socket 创建客户端网络输入流
        BufferedReader br_client = new BufferedReader(
                new InputStreamReader(client_socket.getInputStream(), "UTF-8"));

        String line = null;
        while ((line = br_console.readLine()) != null) {
//            bw_client.write(line);
//            bw_client.flush();
            p_client.println(line);
            if ("over".equals(line)) {
                break;
            }
            System.out.println(br_client.readLine());
//            client_socket.shutdownOutput();

            //  打印服务端返回到客户端的数据
//            String upstr = br_client.readLine();
//            System.out.println(upstr);
        }
        client_socket.close();
    }
}