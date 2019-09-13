package com.lee.phoenix.common.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ValidatorUtil {
    public static boolean isRealPhone(String phone) {
        if (phone == null || phone.isEmpty()) {
            return false;
        }
        Pattern p = null;
        if (Character.isDigit(phone.charAt(0))) {//手机号以数字开头，限制所有字符都必须为数字
            p = Pattern.compile("^((13[0-9])|(14[0-9])|(15[0-9])|(16[0-9])|(17[0-9])|(18[0-9])|(19[0-9]))\\d{8}$");
        } else {
            p = Pattern.compile("^(T\\d{10})$");
        }
        boolean isValid = false;
        try {
            Matcher m = p.matcher(phone);
            isValid = m.matches();
        } catch (Exception e) {
        }
        return isValid;
    }


    public static boolean validPhone(String phone){
        if (phone == null || phone.isEmpty()) {
            return true;
        }
        Pattern p = Pattern.compile("^((\\d{8})|(\\d{11})|(\\d{12}))|(T\\d{4,12})$");
        boolean isValid = false;
        try {
            Matcher m = p.matcher(phone);
            isValid = m.matches();
        } catch (Exception e) {
            isValid = false;
        }
        return isValid;
    }
}
