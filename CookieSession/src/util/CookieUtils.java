package util;

import javax.servlet.http.Cookie;

public class CookieUtils {
    public static Cookie findCookie(String name , Cookie[] cookies){
        if (name == null || cookies == null || cookies.length == 0) {
            return null;
        }

        for (Cookie cookie : cookies) {
            if (name.equals(cookie.getName())) {
                return cookie;
            }
        }

        return null;
    }
}

/**
 * @ClassName : CookieUtils  //类名
 * @Description : CookieUtils  //描述
 * @Author : 胡雨 //作者
 * @Date: 2020/10/30  21:46
 */

