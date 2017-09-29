package com.diabin.latte.util;

import android.util.Log;

/**
 * @auther jh
 * @des ${TODO}
 * Created by J.H on 2017/9/29.
 */

public class Logger {
    /**
     * 日志输出的开关
     */
    private static final boolean isLogCatEnabled = true;
    private static final int mPrintLogLevel = Log.VERBOSE;
    public static final String APP_TAG = "MMall";

    public static void d(Object tag, Object content) {
        debug(String.valueOf(tag), String.valueOf(content), Log.DEBUG, true);
    }

    public static void i(Object tag, Object content) {
        debug(String.valueOf(tag), String.valueOf(content), Log.INFO, true);
    }

    public static void e(Object tag, Object content) {
        debug(String.valueOf(tag), String.valueOf(content), Log.ERROR, true);
    }

    public static void w(Object tag, Object content) {
        debug(String.valueOf(tag), String.valueOf(content), Log.WARN, true);
    }

    public static void v(Object tag, Object content) {
        debug(String.valueOf(tag), String.valueOf(content), Log.VERBOSE, true);
    }

    private static void debug(String tag, String content, int level, boolean isToLagcat) {

        if (!isLogCatEnabled) {
            return;
        }

        if (mPrintLogLevel > level) {
            return;
        }

        switch (level) {
            case Log.VERBOSE:
                if (isToLagcat && isLogCatEnabled) {
                    Log.v(String.valueOf(tag), String.valueOf(content));
                }
                break;
            case Log.DEBUG:
                if (isToLagcat && isLogCatEnabled) {
                    Log.d(String.valueOf(tag), String.valueOf(content));
                }
                break;
            case Log.INFO:
                if (isToLagcat && isLogCatEnabled) {
                    Log.i(String.valueOf(tag), String.valueOf(content));
                }
                break;
            case Log.WARN:
                if (isToLagcat && isLogCatEnabled) {
                    Log.w(String.valueOf(tag), String.valueOf(content));
                }
                break;
            case Log.ERROR:
                if (isToLagcat && isLogCatEnabled) {
                    Log.e(String.valueOf(tag), String.valueOf(content));
                }
                break;
        }
    }

    public static void d1(String tag, Object content) {
        debug("MMall", String.valueOf(tag + "__" + content), Log.DEBUG, true);
    }

    public static void e1(String tag, Object content) {
        debug("MMall", String.valueOf(tag + "__" + content), Log.ERROR, true);
    }

    public static void e1(String tag, Exception error) {
        debug("MMall", Log.getStackTraceString(error), Log.ERROR, true);
    }

}
