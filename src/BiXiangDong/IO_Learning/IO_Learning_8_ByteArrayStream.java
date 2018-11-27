package BiXiangDong.IO_Learning;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

/**
 * 这两个字节流是直接从内存中读写数据的流, 所以不涉及调用资源的问题
 *
 * ByteArrayOutputStream
 *      此类实现了一个输出流, 其中的数据被写入一个byte数组.
 *      缓冲区会随着数据的不断写入而自动增长.
 *      可以使用toByteArray(); 和 toString();获取数据
 *  注意:
 *      因不涉及调用资源的问题, 所以关闭ByteArrayOutputStream无效.
 *      此类中的方法再关闭此流后仍可被调用, 而不会产生IO异常;
 *
 *  字段摘要:
 *    - 存储数据的缓冲区            protected byte[]
 *      buf
 *    - 缓冲区中的有效字节数        protected int
 *      count
 *
 *  构造方法:
 *    - ByteArrayOutputStream();
 *      创建一个新的字符数组输出流
 *    - ByteArrayOutputStream(int size);
 *      创建一个新的字节数组输出流, 其缓冲区容量为指定大小(以字节为单位)
 *
 *  类方法:
 *    -
 *
 *
 * ByteArrayInputStream
 *      ByteArrayInputStream 包含一个内部缓冲区, 该缓冲区包含从流中读取的字节.
 *      内部计数器跟踪read方法要提供的下一个字节.
 *  注意:
 *      因不涉及调用资源的问题, 所以关闭ByteArrayInputStream无效.
 *      此类中的方法再关闭此流后仍可被调用, 而不会产生IO异常;
 *
 *  字节摘要:
 *    - 由该流的创建者提供的 byte数组   protected byte[]
 *      buf
 *    - 比输入流缓冲区中最后一个有效字符的索引+1的索引  protected int
 *      count
 *    - 流中当前的标记位置             protected int
 *      mark
 *    - 要从输入流缓冲区中读取的下一个字符的索引   protected int
 *      pos
 *
 *  构造方法:
 *    - ByteArrayInputStream(byte[] buf);
 *      创建一个 ByteArrayInputStream, 使用buf作为其缓冲区
 *    - ByteArrayInputStream(byte[] buf, int offset, int length);
 *      创建一个 ByteArrayInputStream, 使用buf作为其缓冲区
 *
 *  类方法:
 *    -
 */
public class IO_Learning_8_ByteArrayStream {
    public static void main(String[] args) throws IOException {
        //  示例:
        byteArrayInputStream_demo();
    }

    private static void byteArrayInputStream_demo() throws IOException {

//        //  假装这个byte[]中有数据......
//        byte[] buf = new byte[1024];

        //  读取对象的创建...
        ByteArrayInputStream bais = new ByteArrayInputStream(/*buf*/"abc".getBytes());
        //  写入对象的创建...
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        //  字节...
        int ch = 0;
        //  循环读取....写入....
        while ((ch = bais.read()) != -1) {
            baos.write(ch);
        }

        System.out.println(baos.toString());
    }
}
