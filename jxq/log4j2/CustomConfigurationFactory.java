package cn.chuxiao.log4j2;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.core.LoggerContext;
import org.apache.logging.log4j.core.config.Configuration;
import org.apache.logging.log4j.core.config.ConfigurationFactory;
import org.apache.logging.log4j.core.config.ConfigurationSource;
import org.apache.logging.log4j.core.config.Order;
import org.apache.logging.log4j.core.config.builder.api.ConfigurationBuilder;
import org.apache.logging.log4j.core.config.builder.impl.BuiltConfiguration;
import org.apache.logging.log4j.core.config.plugins.Plugin;

import java.net.URI;

@Plugin(name = "CustomConfigurationFactory", category = ConfigurationFactory.CATEGORY)
@Order(50)
public class CustomConfigurationFactory extends ConfigurationFactory {

    static Configuration createConfiguration(final String name, ConfigurationBuilder<BuiltConfiguration> builder) {
        System.out.println(name);
        builder.setConfigurationName(name + "jxq");

        builder.setStatusLevel(Level.ERROR);
//        builder.add(builder.newFilter("ThresholdFilter", Filter.Result.ACCEPT, Filter.Result.NEUTRAL).
//                addAttribute("level", Level.DEBUG));
//        AppenderComponentBuilder appenderBuilder = builder.newAppender("Stdout", "CONSOLE").
//                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
//        appenderBuilder.add(builder.newLayout("PatternLayout").
//                addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
//        AppenderComponentBuilder appenderBuilder1 = builder.newAppender("Stdout1", "CONSOLE").
//                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
//        appenderBuilder1.add(builder.newLayout("PatternLayout").
//                addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
////        appenderBuilder.add(builder.newFilter("MarkerFilter", Filter.Result.DENY,
////                Filter.Result.NEUTRAL).addAttribute("marker", "FLOW"));
//
//        AppenderComponentBuilder appenderBuilder2 = builder.newAppender("Stdout2", "CONSOLE").
//                addAttribute("target", ConsoleAppender.Target.SYSTEM_OUT);
//        appenderBuilder2.add(builder.newLayout("PatternLayout").
//                addAttribute("pattern", "%d [%t] %-5level: %msg%n%throwable"));
//
//        builder.add(appenderBuilder);
//        builder.add(appenderBuilder1);
//        builder.add(appenderBuilder2);
//        builder.add(builder.newLogger("Stdout1", Level.INFO).
//                add(builder.newAppenderRef("Stdout1")).
//                addAttribute("additivity", false));
//
//        builder.add(builder.newLogger("Stdout2", Level.ERROR).
//                add(builder.newAppenderRef("Stdout2")).
//                addAttribute("additivity", false));
//
//        builder.add(builder.newRootLogger(Level.FATAL).add(builder.newAppenderRef("Stdout")));
        builder.add(builder.newRootLogger(Level.FATAL));
        return builder.build();
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final ConfigurationSource source) {
        return getConfiguration(loggerContext, source.toString(), null);
    }

    @Override
    public Configuration getConfiguration(final LoggerContext loggerContext, final String name, final URI configLocation) {
        ConfigurationBuilder<BuiltConfiguration> builder = newConfigurationBuilder();
        return createConfiguration(name, builder);
    }

    @Override
    protected String[] getSupportedTypes() {
        return new String[]{"*"};
    }
}
