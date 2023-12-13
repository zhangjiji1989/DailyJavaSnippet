package utils;

import java.util.concurrent.ThreadLocalRandom;

/**
 * 随机数工具类
 */
public class RandomUtil {

    /**
     * 生成随机字符串
     *
     * @param length 长度
     * @param range  范围
     * @return
     */
    public static String randomString(Integer length, Integer range) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int j = 0; j < length; j++) {
            stringBuffer.append(ThreadLocalRandom.current().nextInt(range));
        }
        return stringBuffer.toString();
    }

    /**
     * 生成随机数字
     *
     * @param length 长度
     * @param range  范围
     * @return
     */
    public static Integer random(Integer length, Integer range) {
        StringBuilder stringBuffer = new StringBuilder();
        for (int j = 0; j < length; j++) {
            stringBuffer.append(ThreadLocalRandom.current().nextInt(range));
        }
        return Integer.parseInt(stringBuffer.toString());
    }

}
