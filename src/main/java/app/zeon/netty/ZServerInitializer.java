package app.zeon.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

/**
 * This class is responsible for the core.netty.http channel initialization
 */
public class ZServerInitializer extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
        var channelPipeline = socketChannel.pipeline();

        // adds the core.netty.http codec
        channelPipeline.addLast(new HttpServerCodec());
        channelPipeline.addLast(new HttpObjectAggregator(1048576));

        // Inbound

        // Outbound
        // channelPipeline.addLast("httpOutboundHandler", new HttpOutboundHandler());

    }

}
