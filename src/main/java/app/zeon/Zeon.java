package app.zeon;

import app.zeon.utils.Log;
import app.zeon.utils.LogModule;

// entry point
public class Zeon {

    private static final Log LOG = new Log(LogModule.MAIN);

    public static void main(String[] args) {
        LOG.info("Zeon machine starting...");

        LOG.error("Testing error logger");
    }

}