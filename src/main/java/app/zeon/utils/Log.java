package app.zeon.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple logger wrapper,
 * <p>
 * THIS CLASS IS NOT A IMPLEMENTATION, IT IS JUST A WRAPPER AROUND A ALREADY KNOWN logger LIBRARY
 */
public final class Log {

    private static Logger logger;

    public Log(LogModule module) {
        logger = LogManager.getLogger(module.get());
    }

    public <T> void info(String info) {
        logger.info(info);
    }

    public <T> void error(String error) {
        logger.error(error);
    }

}
