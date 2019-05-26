package app.zeon.utils;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * A simple logger wrapper,
 * <p>
 * THIS CLASS IS NOT A IMPLEMENTATION, IT IS JUST A WRAPPER AROUND A ALREADY
 * KNOWN logger LIBRARY
 */
public final class Log {

    private static Logger logger;

    public Log(Class<?> module) {
        logger = LogManager.getLogger(module.getSimpleName());
    }

    public void info(Object info) {
        logger.info(info);
    }

    public void error(Object error) {
        logger.error(error);
    }

}
