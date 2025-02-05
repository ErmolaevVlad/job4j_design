package ru.job4j.io;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UsageLog4j {

    private static final Logger LOG = LoggerFactory.getLogger(UsageLog4j.class.getName());

    public static void main(String[] args) {
        String name = "Alex";
        int age = 27;
        char firstCharName = 'A';
        boolean smoke = true;
        float weight = 75.5f;
        double distance = 5783;
        short children = 1;
        long dataStorageSize = 1073782400L;
        LOG.debug("User info name : {}, age : {}, first char name : {}, smoke : {}, weight : {},"
                + " distance to work in meters : {}, children : {},"
                + " data storage size : {}", name, age, firstCharName, smoke, weight, distance, children, dataStorageSize);
    }
}
