package app.zeon.netty.server;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import io.netty.handler.logging.LogLevel;
import io.netty.handler.logging.LoggingHandler;
import io.netty.handler.ssl.SslContext;
import io.netty.handler.ssl.SslContextBuilder;
import io.netty.handler.ssl.util.SelfSignedCertificate;

public class ZServer {

    private static final ServerBootstrap bootstrap = new ServerBootstrap();

    public ZServer() {

    }

    /**
     * 
     */
    public void run(final int port) throws InterruptedException, SSLException, CertificateException {
        EventLoopGroup bossGroup = new NioEventLoopGroup();
        EventLoopGroup workerGroup = new NioEventLoopGroup();

        try {
            bootstrap.group(bossGroup, workerGroup).channel(NioServerSocketChannel.class)
                    .handler(new LoggingHandler(LogLevel.INFO)).childHandler(new ZServerInitializer(setupSsl()))
                    .option(ChannelOption.SO_BACKLOG, 128).childOption(ChannelOption.SO_KEEPALIVE, true)
                    .childOption(ChannelOption.AUTO_READ, false);

            // Bind and start to accept incoming connections.
            ChannelFuture channelFuture = bootstrap.bind(port).sync();

            // // Wait until the server socket is closed.
            channelFuture.channel().closeFuture().sync();

        } finally {
            workerGroup.shutdownGracefully();
            bossGroup.shutdownGracefully();
        }
    }

    /**
     *  
     */
    public ZServer disableNettyLogging() {
        var loggerContext = LoggerContext.getContext();
        loggerContext.getConfiguration().getLoggerConfig("io.netty").setLevel(Level.OFF);
        return this;
    }

    /**
     * 
     */
    private SslContext setupSsl() throws SSLException, CertificateException {
        // TODO: Replace this with a secure certificate
        SelfSignedCertificate ssc = new SelfSignedCertificate();
        return SslContextBuilder.forServer(ssc.certificate(), ssc.privateKey()).build();
    }

}