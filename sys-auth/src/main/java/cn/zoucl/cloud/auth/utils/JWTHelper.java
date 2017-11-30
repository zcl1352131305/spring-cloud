package cn.zoucl.cloud.auth.utils;

import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.auth.constant.CommonConstant;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jws;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.joda.time.DateTime;

/**
 * Created by ace on 2017/9/10.
 */
public class JWTHelper {
    /**
     * 密钥加密token
     *
     * @param priKeyPath
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(UserVo user, String priKeyPath, int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(user.getUsername())
                .claim(CommonConstant.JWT_KEY_USER_ID, user.getId())
                .claim(CommonConstant.JWT_KEY_NAME, user.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.RS256, CommonConstant.JWT_SIGN_KEY)
                .compact();
        return compactJws;
    }

    /**
     * 公钥解析token
     *
     * @param token
     * @return
     * @throws Exception
     */
    public static Jws<Claims> parserToken(String token) throws Exception {
        Jws<Claims> claimsJws = Jwts.parser().setSigningKey(CommonConstant.JWT_SIGN_KEY).parseClaimsJws(token);
        return claimsJws;
    }

    /**
     * 获取token中的用户信息
     *
     * @param token
     * @param pubKeyPath
     * @return
     * @throws Exception
     */
    public static IJWTInfo getInfoFromToken(String token, String pubKeyPath) throws Exception {
        Jws<Claims> claimsJws = parserToken(token, pubKeyPath);
        Claims body = claimsJws.getBody();
        return new JWTInfo(body.getSubject(), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_USER_ID)), StringHelper.getObjectValue(body.get(CommonConstants.JWT_KEY_NAME)));
    }

}
