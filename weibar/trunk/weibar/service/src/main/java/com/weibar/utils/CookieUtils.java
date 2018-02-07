package com.weibar.utils;


import org.apache.commons.lang.ArrayUtils;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Created by Administrator on 2017/12/7.
 */
public class CookieUtils {


    // cookie的有效期默认为30天
    public final static int COOKIE_MAX_AGE = 60 * 60 * 24 * 30;

    private static final Logger logger = LoggerFactory.getLogger(CookieUtils.class);


    /**
     * 添加一个新Cookie
     *
     * @author zifangsky
     * @param response
     *            HttpServletResponse
     * @param cookieName
     *            cookie名称
     * @param cookieValue
     *            cookie值
     *
     * @return null
     */
    public static void addCookie(HttpServletRequest request,HttpServletResponse response, String cookieName, String cookieValue) {
        //logger.info("add cookie cookieName " + cookieName + " cookieValue " + cookieValue );
        if (StringUtils.isNotBlank(cookieName)) {
            if (cookieValue == null) {
                cookieValue = "";
            }
            Cookie newCookie = new Cookie(cookieName, cookieValue);
            newCookie.setDomain(request.getServerName());
            newCookie.setHttpOnly(false);
            newCookie.setMaxAge(COOKIE_MAX_AGE);
            newCookie.setPath("/");
            newCookie.setSecure(false);
            addCookie(response, newCookie);
        }
    }



    /**
     * 根据Cookie名获取对应的Cookie
     *
     * @author zifangsky
     * @param request
     *            HttpServletRequest
     * @param cookieName
     *            cookie名称
     *
     * @return 对应cookie，如果不存在则返回null
     */
    public static Cookie getCookie(HttpServletRequest request, String cookieName) {


        Cookie[] cookies = request.getCookies();

        if (cookies == null || cookieName == null || "".equals(cookieName)) {
            return null;
        }

        for (Cookie c : cookies) {
            if (c.getName().equals(cookieName)) {
                return (Cookie) c;
            }
        }
        return null;
    }

    /**
     * 根据Cookie名获取对应的Cookie值
     *
     * @author zifangsky
     * @param request
     *            HttpServletRequest
     * @param cookieName
     *            cookie名称
     *
     * @return 对应cookie值，如果不存在则返回null
     */
    public static String getCookieValue(HttpServletRequest request, String cookieName) {
        Cookie cookie = getCookie(request, cookieName);
        if (cookie == null) {
            return null;
        } else {
            return cookie.getValue();
        }
    }

    /**
     * 删除指定Cookie
     *
     * @author zifangsky
     * @param response
     *            HttpServletResponse
     * @param cookie
     *            待删除cookie
     */
    public static void delCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            cookie.setPath("/");
            cookie.setMaxAge(0);
            cookie.setValue(null);

            response.addCookie(cookie);
        }
    }

    /**
     * 根据cookie名删除指定的cookie
     *
     * @author zifangsky
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param cookieName
     *            待删除cookie名
     */
    public static void delCookie(HttpServletRequest request, HttpServletResponse response, String cookieName) {
        Cookie c = getCookie(request, cookieName);
        if (c != null && c.getName().equals(cookieName)) {
            delCookie(response, c);
        }
    }

    /**
     * 根据cookie名修改指定的cookie
     *
     * @author zifangsky
     * @param request
     *            HttpServletRequest
     * @param response
     *            HttpServletResponse
     * @param cookieName
     *            cookie名
     * @param cookieValue
     *            修改之后的cookie值
     */
    public static void editCookie(HttpServletRequest request, HttpServletResponse response, String cookieName,
                                  String cookieValue) {
        Cookie c = getCookie(request, cookieName);
        if (c != null && cookieName != null && ! "".equals(cookieName) && c.getName().equals(cookieName)) {
            addCookie(request, response, cookieValue, cookieValue);
        }
    }


    /**
     * 添加一个新Cookie
     *
     * @author zifangsky
     * @param response
     *            HttpServletResponse
     * @param cookie
     *            新cookie
     *
     * @return null
     */
    private static void addCookie(HttpServletResponse response, Cookie cookie) {
        if (cookie != null) {
            response.addCookie(cookie);
        }
    }
}
