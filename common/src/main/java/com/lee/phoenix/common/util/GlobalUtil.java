package com.lee.phoenix.common.util;


import java.io.UnsupportedEncodingException;
import java.util.List;
import java.util.Vector;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 工具类. <p />
 *
 * @author lee
 * @version 1.0.0
 * @date 2018/08/07 23:00
 * @since JDK1.8
 */
public class GlobalUtil {

    // Create an 24 byte UUID
    protected static int count = 0;
    protected static int guid = 1000;


    /**
     * 生成24位UUID
     *
     * @return UUID 24bit string
     */
    public static synchronized String getUUID() {
        count++;
        long time = System.currentTimeMillis();

        String uuid = "G" + Long.toHexString(time) + Integer.toHexString(count)
                + Long.toHexString(Double.doubleToLongBits(Math.random()));

        uuid = uuid.substring(0, 24).toUpperCase();
        return uuid;
    }

    /**
     * 生成18位UUID数字类型
     *
     * @return UUID 18bit string
     */
    public static synchronized String getGuid() {
        if (++guid > 99999) {
            guid = 1000;
        }
        long time = System.currentTimeMillis();

        String uuid = "" + time + guid + Double.doubleToLongBits(Math.random());

        return uuid.substring(0, 18);

    }

    /**
     * null值的改变
     *
     * @param in 指定字符串
     * @return 如果指定字符串为null, 返回"",否则返回本身
     */
    public static String chgNull(String in) {
        String out = null;
        out = in;
        if (out == null || (out.trim()).equals("null")) {
            return "";
        } else {
            return out.trim();
        }
    }

    /**
     * double类型取小数点后面几位
     *
     * @param val       指定double型数字
     * @param precision 取前几位
     * @return 转换后的double数字
     */
    public static Double roundDouble(double val, int precision) {
        Double ret = null;
        try {
            double factor = Math.pow(10, precision);
            ret = Math.floor(val * factor + 0.5) / factor;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return ret;
    }

    /**
     * 数组转换成字符串
     *
     * @param values 字符串数组
     * @return 以逗号隔开的字符串
     */
    public static String Array2String(String[] values) {
        String result = "";
        if (values == null) {
            return result;
        }
        int len = values.length;
        for (int i = 0; i < len; i++) {
            result += values[i] + ",";
        }
        if (result.endsWith(",")) {
            result = result.substring(result.length() - 1);
        }
        return result;
    }

    /**
     * 数组转换成字符串
     *
     * @param values 对象串数组
     * @return 以逗号隔开的字符串
     */
    public static String Array2String(Object[] values) {
        String result = "";
        if (values == null) {
            return result;
        }
        int len = values.length;
        for (int i = 0; i < len; i++) {
            result += values[i].toString() + ",";
        }
        if (result.endsWith(",")) {
            result = result.substring(result.length() - 1);
        }
        return result;
    }

    /**
     * 数组转换成字符串
     *
     * @param values List集合
     * @return 以逗号隔开的字符串
     */
    @SuppressWarnings("unchecked")
    public static String Array2String(List values) {
        String result = "";
        if (values == null) {
            return result;
        }
        int len = values.size();
        for (int i = 0; i < len; i++) {
            result += values.get(i).toString() + ",";
        }
        if (result.endsWith(",")) {
            result = result.substring(result.length() - 1);
        }
        return result;
    }

    /**
     * 字符转换成数字，如果字符格式错误返回-1
     *
     * @param str 需要输入的字符串
     * @return 格式错误:返回为-1   正确:返回整数
     */
    public static int str2int(String str) {
        int result = 0;
        try {
            result = Integer.parseInt(str);
        } catch (Exception e) {
            result = -1;
        }
        return result;
    }

    /**
     * 数字转换成字符串
     *
     * @param i 需要输入的整型数
     * @return 转换后的字符串
     */
    public static String int2str(int i) {
        String result = "";
        result = String.valueOf(i);
        return result;
    }

    /**
     * 分隔字符串
     *
     * @param source 要分隔的串
     * @param sign   sign为分隔符
     * @return 字符串数组
     */
    @SuppressWarnings("unchecked")
    public static String[] split(String source, char[] sign) {
        String[] ret = new String[0];
        if ((source == null) || (source.equals("")))
            return ret;
        Vector ar = new Vector();
        int start = 0;
        for (int i = 0; i < source.length(); i++) {
            for (int j = 0; j < sign.length; j++) {
                if (sign[j] == source.charAt(i)) {
                    if (start != i) {
                        String s = source.substring(start, i);
                        ar.add(s);
                    }
                    start = i + 1;
                    break;
                }
            }
        }
        if (start < source.length())
            ar.add(source.substring(start, source.length()));
        ret = new String[ar.size()];
        for (int i = 0; i < ar.size(); i++) {
            ret[i] = (String) ar.elementAt(i);
        }
        return ret;

    }

    /**
     * 功能 ：UTF-8转换为GBK
     *
     * @param strUtf8
     * @return GBK
     * @throws UnsupportedEncodingException
     */
    public static String UTF8toGBK(String strUtf8)
            throws UnsupportedEncodingException {

        String encode = "";
        encode = new String(strUtf8.trim().getBytes("UTF-8"), "GBk");
        return encode;
    }

    /**
     * 功能 ：UTF-8转换为ISO-8859-1
     *
     * @param strUtf8
     * @return ISO-8859-1
     * @throws UnsupportedEncodingException
     */
    public static String UTF8toISO88591(String strUtf8)
            throws UnsupportedEncodingException {

        String encode = "";
        encode = new String(strUtf8.trim().getBytes("UTF-8"), "ISO-8859-1");
        return encode;
    }

    /**
     * 功能 ：GBK转换为UTF-8
     *
     * @param strGbk
     * @return UTF-8
     * @throws UnsupportedEncodingException
     */
    public static String GBKtoUTF8(String strGbk)
            throws UnsupportedEncodingException {

        String encode = "";
        encode = new String(strGbk.trim().getBytes("GBk"), "UTF-8");
        return encode;
    }

    /**
     * 功能 ：GBK转换为ISO-8859-1
     *
     * @param strGbk
     * @return ISO-8859-1
     * @throws UnsupportedEncodingException
     */
    public static String GBKtoISO88591(String strGbk)
            throws UnsupportedEncodingException {

        String encode = "";
        encode = new String(strGbk.trim().getBytes("GBk"), "ISO-8859-1");
        return encode;
    }

    /**
     * 功能 ：ISO-8859-1转换为GBK
     *
     * @param strISO88591
     * @return GBK
     * @throws UnsupportedEncodingException
     */
    public static String ISO88591toGBK(String strISO88591)
            throws UnsupportedEncodingException {

        String encode = "";
        encode = new String(strISO88591.trim().getBytes("ISO-8859-1"), "GBK");
        return encode;
    }

    /**
     * 功能 ：ISO-8859-1转换为UTF-8
     *
     * @param strISO88591
     * @return UTF-8
     * @throws UnsupportedEncodingException
     */
    public static String ISO88591toUTF8(String strISO88591)
            throws UnsupportedEncodingException {

        String encode = "";
        encode = new String(strISO88591.trim().getBytes("ISO-8859-1"), "UTF-8");
        return encode;
    }

    // 判断是否为中文  ture=是中文     false=不是中文
    public static boolean isChineseChar(String str) {
        Pattern p = Pattern.compile("[\u4e00-\u9fa5]*");
        Matcher m = p.matcher(str);
        if (!m.matches()) {
            return false;
        }
        return true;
    }

    /**
     * 去除字符串中头部和尾部所包含的空格（包括:空格(全角，半角)、制表符、换页符等）
     *
     * @param s
     * @return
     */
    public static String trim(String s) {
        String result = s.trim();
        while (result.startsWith(" ")) {
            result = result.substring(1, result.length()).trim();
        }
        while (result.endsWith(" ")) {
            result = result.substring(0, result.length() - 1).trim();
        }

        return result;
    }

    public static void main(String[] args) {

    }
}
