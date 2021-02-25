package com.kalone.mylog.security.util;

import org.springframework.security.crypto.password.PasswordEncoder;

/**
 * 密码编码
 *
 * @author shelin 2021/02/25 10:32
 */
public class MyPasswordEncoder implements PasswordEncoder {

    @Override
    public String encode(CharSequence charSequence) {
        return charSequence.toString();
    }

    @Override
    public boolean matches(CharSequence charSequence, String s) {
        return s.equals(charSequence.toString());
    }
}
