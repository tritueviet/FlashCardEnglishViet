/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.code.flashcardenglishviet.utils;

import android.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author sev_user
 */
public class fuck {

    private static final String ALGORITHM = "AES";
    private static final String ALGORITHM_STR = "AES/ECB/PKCS5Padding";
    public static byte[] b = {81, 104, 102, 114, 73, 102, 108, 108, 76, 108, 76, 108, 116, 75, 101, 121};
    
    private static SecretKeySpec key;

    public fuck(String hexKey) {
        key = new SecretKeySpec(hex2byte(hexKey), ALGORITHM);
    }

    public String encryptData(String data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.ENCRYPT_MODE, key);
//        return new BASE64Encoder().encode(cipher.doFinal(data.getBytes()));
        return Base64.encodeToString(cipher.doFinal(data.getBytes()), Base64.DEFAULT);
    }

    public static String decryptData(String base64Data) throws Exception {
        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);
        cipher.init(Cipher.DECRYPT_MODE, key);
        return new String(cipher.doFinal(Base64.decode(base64Data, Base64.DEFAULT)));
//        return new String(cipher.doFinal(base64Data));
    }

    private static byte[] hex2byte(String s) {
        if (s.length() % 2 == 0) {
            return hex2byte(s.getBytes(), 0, s.length() >> 1);
        } else {
            return hex2byte("0" + s);
        }
    }

    private static byte[] hex2byte(byte[] b, int offset, int len) {
        byte[] d = new byte[len];
        for (int i = 0; i < len * 2; i++) {
            int shift = i % 2 == 1 ? 0 : 4;
            d[i >> 1] |= Character.digit((char) b[offset + i], 16) << shift;
        }
        return d;
    }

    public static void main(String[] args) throws Exception {
        System.out.println(decodeText("wI6IJBUnkiPx64bwBgakz1Y/FZ+kkrwAZyQMMl3L9Oo="));
//        System.out.println(""+ (0x1&0x1));
    }
    public static String decodeText(String txt) {
        String s ="NULL";
        if (txt !=null && !txt.equals("NULL")) {
            try {
//                b[4] = 108;
                key = new SecretKeySpec(b, ALGORITHM);
                s = decryptData(txt);

            } catch (Exception e) {
            }
        }
        return s;
    }
    
}
