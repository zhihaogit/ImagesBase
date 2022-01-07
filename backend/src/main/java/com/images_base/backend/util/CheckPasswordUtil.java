package com.images_base.backend.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/7
 */
public class CheckPasswordUtil {

    private static final String REGEX_STR = "^(?=.*[0-9])(?=.*[a-zA-Z])(.{8,20})$";

    public static boolean checkPassword(String password) {
        Pattern passwordPattern = Pattern.compile(REGEX_STR);
        Matcher matcher = passwordPattern.matcher(password);
        return matcher.matches();
    }
}
