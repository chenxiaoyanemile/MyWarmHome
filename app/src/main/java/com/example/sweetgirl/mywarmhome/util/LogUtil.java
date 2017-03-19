package com.example.sweetgirl.mywarmhome.util;

public class LogUtil {
    @SuppressWarnings("unchecked")
    public static String makeLogTag(Class cls) {
        return "MyWarmHome_" + cls.getSimpleName();
    }
}
