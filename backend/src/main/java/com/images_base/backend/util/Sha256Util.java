package com.images_base.backend.util;

import org.springframework.security.crypto.codec.Hex;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author zhengzhihao
 * <p>
 * Created on 2022/1/18
 */
public class Sha256Util {

    public static String encode(String original) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        md.update(original.getBytes());
        byte[] digest = md.digest();
        return new String(Hex.encode(digest));
    }
}
