package app.zeon.server.netty.initializers;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.ssl.SslContext;

/**
 * This class is responsible for the core.netty.http channel initialization
 */
public class ZServerInitializer extends ChannelInitializer<SocketChannel> {

    private final SslContext sslContext;

    public ZServerInitializer(SslContext sslContext) {
        this.sslContext = sslContext;
    }

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        var pipeline = socketChannel.pipeline();

        // ssl to encrypt and decrypt comming data
        pipeline.addLast(sslContext.newHandler(socketChannel.alloc()));

        // Inbound

        // Outbound

    }

}
