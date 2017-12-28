package com.gdyx.apidoc.util;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.impl.crypto.MacProvider;

import java.security.Key;
import java.util.Date;

/**
 * Created by Y_Coffee on 2017/12/6.
 */
public class TokenUtil {
    private static final Key key;

    static {
        key = MacProvider.generateKey();
        byte[] randomKey = key.getEncoded();
        System.out.println("生成SecretKey：" + key);
    }

    public static String buildToken() {
        String token = Jwts.builder().setSubject("gdyxUnionpay").claim("roles", "admin").setIssuedAt(new Date())
                .signWith(SignatureAlgorithm.HS256, key).compact();
        return token;
    }

    public static Claims unBuildToken(String compactJws) {
        Jws<Claims> parseClaimsJws = Jwts.parser().setSigningKey(key).parseClaimsJws(compactJws);
        Claims body = parseClaimsJws.getBody();
        return body;
    }
}
