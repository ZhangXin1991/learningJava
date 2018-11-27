package BiXiangDong.Network_Learning;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Test5_0_TCP_Thread_Server {
    public static void main(String[] args) throws IOException {
        //1, 创建服务端, 并指定接收端口
        ServerSocket serverSocket = new ServerSocket(10003 );

        //2, 创建已连接的客户端对象, 并开启多线程
        while (true) {
            Socket socket_client = serverSocket.accept();

            //  此处的new Thread 不能用Thread类 变量 引用, 不知道为啥....
            new Thread(new UpTask(socket_client)).start();
        }

    }
}

class UpTask implements Runnable {

    private Socket socket_client;
    private FileOutputStream fileOut;
//    private int count = 0;

    public UpTask(Socket socket_client) {
        this.socket_client = socket_client;
    }

    @Override
    public void run() {
        String ip = socket_client.getInetAddress().getHostAddress();
        System.out.println(ip+"....connect");

        File dirF = new File("C:\\Users\\65404\\Desktop\\" +
                "learningJava\\test\\2018_11_4_socket_serverAndClient_UpLoad" +
                "\\picture");

        //  健壮性判断: 判断保存picture的目录是否存在
        if (!dirF.exists()) {
            try {
                boolean dir_Error = dirF.createNewFile();
                if (! dir_Error)
                    System.out.println("创建目录异常");
            } catch (IOException e) { e.printStackTrace(); }

        }
        //  健壮性判断: 判断是否有同名的picture文件, 如果有就换名字.....
        int count = 0;
        File file = new File(dirF, ip+"("+count+")"+".jpg");
        while (file.exists()) {
            file = new File(dirF, ip+"("+(++count)+")"+".jpg");
        }


        try {
            InputStream clientIn = socket_client.getInputStream();
            fileOut = new FileOutputStream(file);
            OutputStream clientOut = socket_client.getOutputStream();

            byte[] bufF = new byte[1024];
            int lenF = 0;
            while ((lenF = clientIn.read(bufF)) != -1) {
                fileOut.write(bufF, 0, lenF);
                fileOut.flush();
            }

            clientOut.write("上传成功".getBytes());

        } catch (IOException e) { e.printStackTrace(); }
        finally {
            try {
                socket_client.close();
                fileOut.close();
            } catch (IOException e) { new RuntimeException("关闭失败"); }
        }
    }
}
