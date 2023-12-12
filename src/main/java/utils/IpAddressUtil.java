package utils;

import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONUtil;
import model.ipregion.IPRegionResponse;
import lombok.extern.slf4j.Slf4j;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * IP地址工具类
 */
@Slf4j
public class IpAddressUtil {

    private static final String C2BA_IP = "http://c2ba.api.huachen.cn";

    /**
     * 从请求中获取IP地址
     * @param request
     * @return
     */
    public static String getIpAddress(HttpServletRequest request) {
        String ip = request.getHeader("x-forwarded-for");
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("WL-Proxy-Client-IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_CLIENT_IP");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getHeader("HTTP_X_FORWARDED_FOR");
        }
        if (ip == null || ip.isEmpty() || "unknown".equalsIgnoreCase(ip)) {
            ip = request.getRemoteAddr();
        }
        String[] split = ip.split(", ");
        if (split.length > 0) {
            return split[0];
        }
        return ip;
    }

    /**
     * 根据IP地址解析归属地
     * @param ip
     * @return
     */
    public static String getIPRegion(String ip) {
        Map<String, String> headers = new HashMap<>();
        headers.put("Authorization", "APPCODE " + "");
        Map<String, Object> params = new HashMap<>();
        params.put("ip", ip);
        try {
            HttpRequest get = HttpUtil.createGet(C2BA_IP + "/ip");
            get.addHeaders(headers);
            get.form(params);
            String response;
            try (HttpResponse httpResponse = get.execute()) {
                response = httpResponse.body();
            }
            log.info("获取ip, {}, 结果: {}", ip, response);
            IPRegionResponse regionResponse = JSONUtil.toBean(response, IPRegionResponse.class);
            if (regionResponse.getRet() == 200 && regionResponse.getMsg().equals("success")) {
                return regionResponse.getData().getRegion();
            }
        } catch (Exception e) {
            log.error("获取IP区域信息失败: {}", ThrowableUtils.getStackTraceByPn(e));
        }
        return "";
    }

}
