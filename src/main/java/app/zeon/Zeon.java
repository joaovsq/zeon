package app.zeon;

import app.zeon.server.netty.ZServer;
import app.zeon.utils.Log;

import javax.net.ssl.SSLException;
import java.security.cert.CertificateException;
import java.util.concurrent.CompletableFuture;

// entry point
public class Zeon {

    private static final Log log = new Log(Zeon.class);

    public static void main(String[] args) {

        var serverJob = CompletableFuture.runAsync(() -> {
            try {
                log.info("Zeon server starting...");
                new ZServer().run(7777);
            } catch (InterruptedException | CertificateException | SSLException e) {
                e.printStackTrace();
            }
        });

        var clientJob = CompletableFuture.runAsync(() -> {
            log.info("Client running...");
        });

        serverJob.join();

    }

}