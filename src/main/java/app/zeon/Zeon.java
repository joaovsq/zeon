package app.zeon;

import java.security.cert.CertificateException;

import javax.net.ssl.SSLException;

import app.zeon.netty.server.ZServer;
import app.zeon.utils.Log;
import app.zeon.utils.LogModule;

// entry point
public class Zeon {

    private static final Log LOG = new Log(LogModule.MAIN);

    public static void main(String[] args) throws InterruptedException, SSLException, CertificateException {
        LOG.info("Zeon machine starting...");

        // if (args.length > 0 && args[0].equals("-server")) {
        // }

        new ZServer().run(7777);

    }

}