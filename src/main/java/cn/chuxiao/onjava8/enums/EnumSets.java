package cn.chuxiao.onjava8.enums;

import java.util.EnumSet;

import java.util.*;

// Operations on EnumSets
// {java enums.EnumSets}
public class EnumSets {
    public static void main(String[] args) {
        EnumSet<AlarmPoints> points =
                EnumSet.noneOf(AlarmPoints.class); // Empty
        points.add(AlarmPoints.BATHROOM);
        System.out.println(points);

        points.addAll(
                EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);

        points = EnumSet.allOf(AlarmPoints.class);
        points.removeAll(
                EnumSet.of(AlarmPoints.STAIR1, AlarmPoints.STAIR2, AlarmPoints.KITCHEN));
        System.out.println(points);

        points.removeAll(
                EnumSet.range(AlarmPoints.OFFICE1,AlarmPoints.OFFICE4));
        System.out.println(points);

        //所有的中去除给定参数中的
        points = EnumSet.complementOf(points);
        System.out.println(points);
    }

    enum AlarmPoints {
        STAIR1, STAIR2, LOBBY, OFFICE1, OFFICE2, OFFICE3,
        OFFICE4, BATHROOM, UTILITY, KITCHEN
    }
}