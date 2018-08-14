package util;

import javax.servlet.http.Cookie;

public class CookieUtil {
    public static Cookie getCookie(Cookie[] cookies,String name){
        Cookie cookie=null;
        for (Cookie cookie1:cookies
             ) {
            if(cookie1.getName().equals(name)){
                cookie=cookie1;
            }
        }
        return cookie;
    }
}
