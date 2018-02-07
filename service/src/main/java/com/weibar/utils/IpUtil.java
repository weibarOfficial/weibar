package com.weibar.utils;


import org.apache.commons.lang3.StringUtils;

import javax.servlet.http.HttpServletRequest;
import java.net.InetAddress;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2016/12/15.
 */
public class IpUtil {

    private final static Pattern COMMA = Pattern.compile(",\\s*");


    /**
     * 获取本机的IP
     * @return Ip地址
     */
    public static String getLocalHostIP() {
        String ip;
        try {
            /**返回本地主机。*/
            InetAddress addr = InetAddress.getLocalHost();
            /**返回 IP 地址字符串（以文本表现形式）*/
            ip = addr.getHostAddress();
        } catch(Exception ex) {
            ip = "";
        }

        return ip;
    }

    public static String getRequestIp(HttpServletRequest request) {

        // 优先级１：从X-Real-IP中取，有多重代理时，这个地址可能不准确，但一般不会被伪造
        String ip = request.getHeader("X-Real-IP");
        if (StringUtils.isBlank(ip)) {
            // 优先级２：从X-Forwarded-For中取，有被伪造的风险
            ip = request.getHeader("X-Forwarded-For");
            if (StringUtils.isNotBlank(ip) && ip.indexOf(",") >= 0) {
                // Replaced by Gzc
                // ip = null;
                ip = getXForwardedFor(request, 0);
                // Replaced by Gzc // END
            }
        }
        if (StringUtils.isBlank(ip)) {
            // 优先级３：直接获取RemoteAddr，有反向代理时这个地址会不准确
            ip = request.getRemoteAddr();
        }
        return ip;
    }

    /**
     * 获取X-Forward-For中特定索引的值, 如果没有XFF返回RemoteAddr
     *
     * @author GongZichao
     * @param request
     * @param index 从0开始; 负数代表从后向前, -1即最后一个值
     * @return 指定索引在适应边界后对应的值, 如果没有XFF, 则返回RemoteAddr
     */
    public static String getXForwardedFor(HttpServletRequest request, int index) {
        String value = request.getHeader("X-Forwarded-For");
        if (StringUtils.isBlank(value)) {
            return request.getRemoteAddr();
        } else {
            String[] ips = COMMA.split(value);
            if (index < 0) {
                index += ips.length;
            }
            return ips[index < 0 ? 0 : index >= ips.length ? ips.length - 1 : index];
        }
    }
}
