package cn.chuxiao.onjava8.enums;

import java.util.EnumMap;
import java.util.Map;

import static cn.chuxiao.onjava8.enums.EnumSets.AlarmPoints.*;

interface Command { void action(); }

public class EnumMaps {
    public static void main(String[] args) {
        EnumMap<EnumSets.AlarmPoints,Command> em =
                new EnumMap<>(EnumSets.AlarmPoints.class);
        em.put(KITCHEN,
                () -> System.out.println("Kitchen fire!"));
        em.put(BATHROOM,
                () -> System.out.println("Bathroom alert!"));
        for(Map.Entry<EnumSets.AlarmPoints,Command> e:
                em.entrySet()) {
            System.out.print(e.getKey() + ": ");
            e.getValue().action();
        }
        try { // If there's no value for a particular key:
            em.get(UTILITY).action();
        } catch(Exception e) {
            System.out.println("Expected: " + e);
        }
    }
}