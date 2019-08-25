package cn.chuxiao.onjava8.enums;

import java.util.Random;

/**
 * 随机选择的工具类
 * */
public class Enums {
    private static Random random = new Random(47);

    public static <T extends Enum<T>>  T random(Class<T> clazz){
        return random(clazz.getEnumConstants());
    }

    public static <T> T random(T[] values){
        return values[random.nextInt(values.length)];
    }

    private Enums() {
        super();
    }
}
