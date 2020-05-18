package cn.chuxiao.log4j2;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;


public class Main {


    public static void main(String[] args) {
        System.out.println("log");
        log();

        System.out.println("reconfigure");
        Config.reconfigure();
        System.out.println("relog");
        log();
    }

    private static void log() {
        Logger logger1 = LogManager.getLogger("Stdout1");
        System.out.println(logger1);

//        Logger logger2 = LogManager.getLogger("Stdout2");
//        System.out.println(logger2);

//        Logger logger3 = LogManager.getLogger("xxxxx");
//        System.out.println(logger3);


        logger1.info("1 info msg");
        logger1.warn("1 warn msg");
        logger1.error("1 error msg");


//        logger2.info("2 info msg");
//        logger2.warn("2 warm msg");
//        logger2.error("2 error msg");

//        logger3.info("3 info msg");
//        logger3.warn("3 warm msg");
//        logger3.error("3 error msg");
    }
}
