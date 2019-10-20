package com.jun.demo.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;

/**
 * @author Jun
 * @date: 19-10-20 下午2:31
 */
public class BlockingNIO {
    //  服务端
    public static void main(String[] args) throws IOException {
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        Path path = Paths.get("");

        FileChannel outChannel = FileChannel.open(path, StandardOpenOption.WRITE);
        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress(9898));
        // 获取客户端的连接通道
        SocketChannel socketChannel = serverSocketChannel.accept();
        // 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 接受客户端的数据并保存到本地
        while (socketChannel.read(byteBuffer) != -1) {
            byteBuffer.flip();
            outChannel.write(byteBuffer);
            byteBuffer.clear();
        }
        // 关闭通道
        socketChannel.close();
        outChannel.close();
        serverSocketChannel.close();
    }

    @Test
    public void client() {

    }
}
