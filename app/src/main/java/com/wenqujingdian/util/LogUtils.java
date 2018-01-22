package com.wenqujingdian.util;

import android.text.TextUtils;
import android.util.Log;


/**
 * # 作者：王宏伟
 * # 时间：2017/8/17    下午2:53
 * # 描述：织巢鸟科技
 */

public class LogUtils {
    /**
     * 日志开关
     */
    private static       boolean isDebug   = true;
    private static       String  TAGString = "ZhiChaoNiao_LogUtils_:";
    private static final String  AUTHOR    = "数据  -->";


    public static void debug(boolean status) {
        isDebug = status;
    }

    public static void d(String message) {
        if (isDebug) {
            Log.d(TAGString, AUTHOR + message);
        }
    }

    public static void i(String message) {
        if (isDebug) {
            Log.i(TAGString, AUTHOR + message);
        }
    }

    /**
     * Json格式化输出
     *
     * @param message                 内容
     * @param isOutputOriginalContent 是否输入原内容
     */
    public static void iJsonFormat(String message, boolean isOutputOriginalContent) {
        if (isDebug && !TextUtils.isEmpty(message)) {
            if (isOutputOriginalContent)
                Log.i(TAGString, AUTHOR + message);
            Log.i(TAGString, AUTHOR + "\n" + format(convertUnicode(message)));
//            showLogCompletion(AUTHOR + "\n" + format(convertUnicode(message)), 4000);
        }
    }


//    /**
//     * 分段打印出较长log文本
//     *
//     * @param log       原log文本
//     * @param showCount 规定每段显示的长度（最好不要超过eclipse限制长度）
//     */
//    public static void showLogCompletion(String log, int showCount) {
//        if (log.length() > showCount) {
//            String show = log.substring(0, showCount);
////          System.out.println(show);
//            Log.i("TAG", show + "");
//            if ((log.length() - showCount) > showCount) {//剩下的文本还是大于规定长度
//                String partLog = log.substring(showCount, log.length());
//                showLogCompletion(partLog, showCount);
//            } else {
//                String surplusLog = log.substring(showCount, log.length());
////              System.out.println(surplusLog);
//                Log.i("TAG", surplusLog + "");
//            }
//
//        } else {
//            Log.i(TAGString, log + "");
//        }
//    }


    public static void w(String message) {
        if (isDebug) {
            Log.w(TAGString, AUTHOR + message);
        }

    }

    public static void e(String message) {
        if (isDebug) {
            Log.e(TAGString, AUTHOR + message);
        }
    }


    public static String format(String jsonStr) {
        int level = 0;
        StringBuffer jsonForMatStr = new StringBuffer();
        for (int i = 0; i < jsonStr.length(); i++) {
            char c = jsonStr.charAt(i);
            if (level > 0 && '\n' == jsonForMatStr.charAt(jsonForMatStr.length() - 1)) {
                jsonForMatStr.append(getLevelStr(level));
            }
            switch (c) {
                case '{':
                case '[':
                    jsonForMatStr.append(c + "\n");
                    level++;
                    break;
                case ',':
                    jsonForMatStr.append(c + "\n");
                    break;
                case '}':
                case ']':
                    jsonForMatStr.append("\n");
                    level--;
                    jsonForMatStr.append(getLevelStr(level));
                    jsonForMatStr.append(c);
                    break;
                default:
                    jsonForMatStr.append(c);
                    break;
            }
        }

        return jsonForMatStr.toString();

    }


    private static String getLevelStr(int level) {
        StringBuffer levelStr = new StringBuffer();
        for (int levelI = 0; levelI < level; levelI++) {
            levelStr.append("\t");
        }
        return levelStr.toString();
    }


    public static String convertUnicode(String ori) {
        char aChar;
        int len = ori.length();
        StringBuffer outBuffer = new StringBuffer(len);
        for (int x = 0; x < len; ) {
            aChar = ori.charAt(x++);
            if (aChar == '\\') {
                aChar = ori.charAt(x++);
                if (aChar == 'u') {
                    // Read the xxxx
                    int value = 0;
                    for (int i = 0; i < 4; i++) {
                        aChar = ori.charAt(x++);
                        switch (aChar) {
                            case '0':
                            case '1':
                            case '2':
                            case '3':
                            case '4':
                            case '5':
                            case '6':
                            case '7':
                            case '8':
                            case '9':
                                value = (value << 4) + aChar - '0';
                                break;
                            case 'a':
                            case 'b':
                            case 'c':
                            case 'd':
                            case 'e':
                            case 'f':
                                value = (value << 4) + 10 + aChar - 'a';
                                break;
                            case 'A':
                            case 'B':
                            case 'C':
                            case 'D':
                            case 'E':
                            case 'F':
                                value = (value << 4) + 10 + aChar - 'A';
                                break;
                            default:
                                throw new IllegalArgumentException(
                                        "Malformed   \\uxxxx   encoding.");
                        }
                    }
                    outBuffer.append((char) value);
                } else {
                    if (aChar == 't')
                        aChar = '\t';
                    else if (aChar == 'r')
                        aChar = '\r';
                    else if (aChar == 'n')
                        aChar = '\n';
                    else if (aChar == 'f')
                        aChar = '\f';
                    outBuffer.append(aChar);
                }
            } else
                outBuffer.append(aChar);

        }
        return outBuffer.toString();
    }

}
