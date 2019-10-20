package com.jun.demo.nio;

import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.util.Date;
import java.util.Iterator;

/**
 * @author Jun
 * @date: 19-10-20 下午3:00
 */
public class NonBlockingNIO {
    /*客户端*/
    @Test
    public void client() throws IOException {
        // 获取通道
        SocketChannel socketChannel = SocketChannel.open(new InetSocketAddress("localhost", 9898));
        // 切换非阻塞模式
        socketChannel.configureBlocking(false);
        // 分配指定大小的缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        // 发送数据给服务器
        byteBuffer.put(new Date().toString().getBytes());
        byteBuffer.flip();
        socketChannel.write(byteBuffer);
        byteBuffer.clear();
        // 关闭通道
        socketChannel.close();
    }

    @Test
    public void server() throws IOException {
        // 获取通道
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        // 切换非阻塞模式
        serverSocketChannel.configureBlocking(false);
        // 绑定连接
        serverSocketChannel.bind(new InetSocketAddress("localhost", 9898));
        // 获取选择器
        Selector selector = Selector.open();
        // 将通道注册到选择器，并且指定 监听接收事件
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        // 轮询式的获取选择器上已经准备的就绪的事件
        while (selector.select() > 0) {
            // 获取当前选择器中所有 注册的选择键（已经就绪的选择键）
            Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
            while (iterator.hasNext()) {
                // 获取准备就绪的事件
                SelectionKey selectionKey = iterator.next();
                // 判断具体是什么事件并准备就绪
                if (selectionKey.isAcceptable()) {
                    // 若“接收就绪”，获取客户端连接
                    SocketChannel socketChannel = serverSocketChannel.accept();
                    // 切换非阻塞模式
                    socketChannel.configureBlocking(false);
                    // 将该通道注册到选择器上
                    socketChannel.register(selector, SelectionKey.OP_ACCEPT);
                }
            }
        }
    }
}
