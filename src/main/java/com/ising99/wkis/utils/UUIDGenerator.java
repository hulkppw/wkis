package com.ising99.wkis.utils;

import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.UUID;

/**
 * Created by Hulk on 2014/11/14.
 */
public class UUIDGenerator {
    public static String generateId(){
        String uuid = UUID.randomUUID().toString();
        uuid = uuid.replace("-", "");
        return uuid;
    }
}
