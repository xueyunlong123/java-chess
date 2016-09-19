package com.xyl.Util;

import javax.servlet.http.Cookie;

/**
 * Created by ${Xueyunlong} on 2016/9/7.
 */
public class CookieUtil {

    public static String getCookie(Cookie[] cookies,String name){
        String value = null;
        for (Cookie cookie : cookies) {
            //通过cookie获取当前用户uid
            Cookie c = null;

            if (cookies != null) {
                for (int i = 0; i < cookies.length; i++) {
                    c = cookies[i];
                    if (c.getName().equals(name)) {
                        value = c.getValue();

                    }
                }
            }
    }
        return value;
}

}
