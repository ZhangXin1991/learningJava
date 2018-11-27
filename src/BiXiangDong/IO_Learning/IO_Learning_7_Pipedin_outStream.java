package BiXiangDong.IO_Learning;

import java.io.IOException;
import java.io.InputStream;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * 管道流:
 *      管道输入流应连接到管道输出流; 然后，管道输入流提供写入管道输出流的任何数据字节。
 *      通常，PipedInputStream 一个线程从对象读取数据，
 *      并且PipedOutputStream 通过某个其他线程将数据写入对应的数据。
 *      建议不要尝试使用单个线程中的两个对象，因为它可能使线程死锁。
 *      管道输入流包含缓冲区，在一定限度内将读操作与写操作解耦。
 *      如果向连接的管道输出流提供数据字节的线程不再存在，则称管道被破坏
 *
 *  管道输入流:
 *      PipedInputStream
 *
 *  管道输出流:
 *      PipedOutputStream
 *
 */
public class IO_Learning_7_Pipedin_outStream {
    public static void main(String[] args) throws IOException {
        PipedInputStream input = new PipedInputStream();
        PipedOutputStream output = new PipedOutputStream();

        //  将 管道输入流 与 管道输出流 建立连接
        input.connect(output);

        new Thread(new Input(input)).start();
        new Thread(new Output(output)).start();
    }
}

class Input implements Runnable {

    private PipedInputStream in;

    Input(PipedInputStream in) {
        this.in = in;
    }

    @Override
    public void run() {

        try {
            byte[] buf = new byte[1024];
            int len = in.read(buf);

            String string = new String(buf, 0, len);
            System.out.println(string);

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                in.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}


class Output implements Runnable {

    private PipedOutputStream out;

    Output(PipedOutputStream out) {
        this.out = out;
    }
    @Override
    public void run() {

        try {
            Thread.sleep(5000);
            out.write("蛤!!, 管道来了..".getBytes());
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        } finally {
            try {
                out.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
