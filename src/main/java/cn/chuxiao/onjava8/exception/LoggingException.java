package cn.chuxiao.onjava8.exception;
import	java.io.PrintWriter;
import	java.io.StringWriter;
import	java.util.logging.Logger;

import java.util.logging.Logger;

public class LoggingException extends Exception {
    private static Logger logger = Logger.getLogger("LoggingException");

    LoggingException(){
        StringWriter trace = new StringWriter();
        printStackTrace(new PrintWriter(trace));
        logger.severe(trace.toString());
    }
}

class LogginfExceptions{
    public static void main(String[] args) {
        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught" + e);
        }

        try {
            throw new LoggingException();
        } catch (LoggingException e) {
            System.err.println("Caught" + e);
        }
    }
}