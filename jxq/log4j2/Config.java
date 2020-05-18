package cn.chuxiao.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.appender.ConsoleAppender;
import org.apache.logging.log4j.core.config.builder.api.AppenderComponentBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilderFactory;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;

public class Config {

    public static void reconfigure() {

        final LoggerContext ctx = (LoggerContext) LogManager.getContext(false);
        //  final Configuration config = ctx.getConfiguration();
        ConfigurationBuilder<BuiltConfiguration> builder = ConfigurationBuilderFactory.newConfigurationBuilder();

//        System.out.println(config.getName());
//        builder.setConfigurationName(config.getName());
//        builder.setStatusLevel(Level.ERROR);
//        builder.add(builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT, Filter.Result.NEUTRAL).
//                addAttribute("level", Level.DEBUG));
        AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").
                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
//        appenderBuilder.add(builder.newLayout("PatternLayout").
//                addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));

        AppenderComponentBuilder appenderBuilder1 = builder.newAppender("Stdout1", "CONSOLE").
                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
        appenderBuilder1.add(builder.newLayout("PatternLayout").
                addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
//        appenderBuilder.add(builder.newFilter("MarkerFilter", Filter.Result.DENY,
//                Filter.Result.NEUTRAL).addAttribute("marker", "FLOW"));

        AppenderComponentBuilder appenderBuilder2 = builder.newAppender("Stdout2", "CONSOLE").
                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
//        appenderBuilder2.add(builder.newLayout("PatternLayout").
//                addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));

        builder.add(appenderBuilder);
        builder.add(appenderBuilder1);
        builder.add(appenderBuilder2);
        builder.add(builder.newLogger("Stdout1", Level.DEBUG).
                add(builder.newAppenderRef("Stdout")).
                add(builder.newAppenderRef("Stdout1")).
                add(builder.newAppenderRef("Stdout2")).
                addAttribute("additivity", false));

//        builder.add(builder.newLogger("Stdout2", Level.INFO).
//                add(builder.newAppenderRef("Stdout2")).
//                addAttribute("additivity", false));

        //builder.add(builder.newRootLogger(Level.WARN).add(builder.newAppenderRef("Stdout")));
       // ctx.reconfigure(builder.build());
        ctx.setConfiguration(builder.build());
      
    }
}
