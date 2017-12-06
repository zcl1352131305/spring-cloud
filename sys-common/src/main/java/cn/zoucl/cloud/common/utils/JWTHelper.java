package cn.zoucl.cloud.common.utils;

import cn.zoucl.cloud.api.model.vo.UserVo;
import cn.zoucl.cloud.common.constant.CommonConstant;
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
     * 加密token
     *
     * @param expire
     * @return
     * @throws Exception
     */
    public static String generateToken(UserVo user,  int expire) throws Exception {
        String compactJws = Jwts.builder()
                .setSubject(user.getUsername())
                .claim(CommonConstant.JWT_KEY_USER_ID, user.getId())
                .claim(CommonConstant.JWT_KEY_NAME, user.getName())
                .setExpiration(DateTime.now().plusSeconds(expire).toDate())
                .signWith(SignatureAlgorithm.HS256, CommonConstant.JWT_SIGN_KEY)
                .compact();
        return compactJws;
    }

    /**
     * 解析token
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
     * 获取对象
     * @param token
     * @return
     * @throws Exception
     */
    public static UserVo getInfoFromToken(String token) throws Exception{
        Jws<Claims> claimsJws = parserToken(token);
        Claims body = claimsJws.getBody();
        UserVo vo = new UserVo();
        vo.setId(body.get(CommonConstant.JWT_KEY_USER_ID).toString());
        vo.setUsername(body.getSubject());
        vo.setName(body.get(CommonConstant.JWT_KEY_NAME).toString());

        return vo;
    }

}
