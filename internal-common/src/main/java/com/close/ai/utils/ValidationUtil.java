package com.close.ai.utils;

import lombok.Data;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author nbwyctf
 * @since 2025-01-20
 */
@Data
public class ValidationUtil {
    // 正则表达式：邮箱
    private static final String EMAIL_REGEX = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";

    // 正则表达式：手机号前缀
    private static final String PHONE_PREFIX_REGEX = "^\\+\\d{1,3}$";

    // 正则表达式：手机号
    private static final String PHONE_NUMBER_REGEX = "^\\d{4,15}$";

    /**
     * 验证邮箱格式
     *
     * @param email 待验证的邮箱字符串
     * @return true 如果格式正确；否则返回 false
     */
    public static boolean isValidEmail(String email) {
        if (email == null || email.isEmpty()) {
            return false;
        }
        Pattern pattern = Pattern.compile(EMAIL_REGEX);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    /**
     * 验证带有前缀的手机号格式
     *
     * @param phonePrefix 手机号前缀（格式如 "+86"）
     * @param phoneNumber 手机号（格式如 "1234567890"）
     * @return true 如果格式正确；否则返回 false
     */
    public static boolean isValidPhone(String phonePrefix, String phoneNumber) {
        if (phonePrefix == null || phonePrefix.isEmpty() || phoneNumber == null || phoneNumber.isEmpty()) {
            return false;
        }
        Pattern prefixPattern = Pattern.compile(PHONE_PREFIX_REGEX);
        Pattern numberPattern = Pattern.compile(PHONE_NUMBER_REGEX);
        Matcher prefixMatcher = prefixPattern.matcher(phonePrefix);
        Matcher numberMatcher = numberPattern.matcher(phoneNumber);
        return prefixMatcher.matches() && numberMatcher.matches();
    }

}
