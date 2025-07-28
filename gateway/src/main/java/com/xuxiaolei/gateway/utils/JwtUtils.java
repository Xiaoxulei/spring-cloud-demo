package com.xuxiaolei.gateway.utils;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;

import java.security.Key;
import java.util.Date;
/**
 * @Author: xuxiaolei
 * @Description: TODO: JwtUtils
 * @CreatTime: 2025/07/28 09:47
 **/
public class JwtUtils {
    // 建议使用更复杂的密钥保存在配置文件或环境变量中
    private static final Key key = Keys.secretKeyFor(SignatureAlgorithm.HS256);

    // 生成 JWT
    public static String generateToken(String username) {
        long nowMillis = System.currentTimeMillis();
        Date now = new Date(nowMillis);
        Date exp = new Date(nowMillis + 3600_000); // 1小时有效

        return Jwts.builder()
                .setSubject(username)              // 主题，通常是用户名
                .setIssuedAt(now)                 // 签发时间
                .setExpiration(exp)               // 过期时间
                .signWith(key)                    // 使用HS256算法签名
                .compact();
    }

    // 解析 JWT
    public static String parseToken(String token) {
        try {
            Jws<Claims> claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token);

            return claims.getBody().getSubject(); // 返回用户名
        } catch (JwtException e) {
            System.out.println("Invalid JWT: " + e.getMessage());
            return null;
        }
    }

    // 验证是否过期
    public static boolean isExpired(String token) {
        try {
            Claims claims = Jwts.parserBuilder()
                    .setSigningKey(key)
                    .build()
                    .parseClaimsJws(token)
                    .getBody();
            return claims.getExpiration().before(new Date());
        } catch (JwtException e) {
            return true;
        }
    }
}
