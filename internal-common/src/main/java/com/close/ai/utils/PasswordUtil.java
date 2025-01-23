package com.close.ai.utils;

import org.mindrot.jbcrypt.BCrypt;

/**
 * @author ctf
 * @since 2024-12-19
 */
public class PasswordUtil {
    // 哈希密码
    public static String hashPassword(String password) {
        return BCrypt.hashpw(password, BCrypt.gensalt());
    }

    // 验证密码
    public static boolean checkPassword(String password, String hashedPassword) {
        return BCrypt.checkpw(password, hashedPassword);
    }
}
