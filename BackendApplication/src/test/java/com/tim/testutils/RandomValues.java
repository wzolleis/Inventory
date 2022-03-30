package com.tim.testutils;

import org.apache.commons.lang3.RandomStringUtils;
import org.apache.commons.lang3.RandomUtils;

public abstract class RandomValues {
    public static String randomString(int count) {
        return RandomStringUtils.randomAlphabetic(count);
    }

    public static int randomInt() {
        return RandomUtils.nextInt();
    }

    public static int randomInt(int start, int end) {
        return RandomUtils.nextInt(start, end);
    }

    public static int randomInt(int end) {
        return randomInt(0, end);
    }
}
