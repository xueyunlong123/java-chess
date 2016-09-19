package com.xyl.Util;

import javax.servlet.http.Cookie;

/**
 * Created by ${Xueyunlong} on 2016/9/9.
 */
public class JudgeUserIdentityUtil {
    public static int judgeUserIdentity(Cookie[] cookie){
        String uid = CookieUtil.getCookie(cookie,"uid");
        if(uid == null )
            return 0;
        else
            return 1;
    }
}
