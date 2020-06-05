package com.pandaroid.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;

/**
 * 需要准备两个东西：
 *  1. 轮询器 Selector ，相当于叫号系统或大堂经理，轮询缓冲区的数据是否准备好了，准备好了则改变状态，通知相应服务端线程处理
 *  2. 缓冲区 Buffer ，相当于等候区，客户端数据发送到服务端，都在缓冲区等候准备
 * @author pandaroid
 */
public class NIOServerDemo {

    private final int port = 8080;

    private Selector selector;

    private final ByteBuffer byteBuffer = ByteBuffer.allocate(1024);

    public NIOServerDemo() {
        // 初始化 selector
        try {
            // open 开门营业
            ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
            // 公布 IP + Port 地址，好接客
            serverSocketChannel.bind(new InetSocketAddress(this.port));
            serverSocketChannel.configureBlocking(false);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void listen() {

    }

    public static void main(String[] args) {
        (new NIOServerDemo()).listen();
    }

}
