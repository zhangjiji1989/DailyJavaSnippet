package utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 字符串工具类
 */
public class StringUtils {

    /**
     * 判断字符串是否包含中文字符
     *
     * @param content 字符串
     * @return 是否包含中文字符
     */
    public static boolean checkChineseCharacter(String content) {
        if (null != content && !content.isEmpty()) {
            String regEx = "[一-龥]";
            Pattern p = Pattern.compile(regEx);
            Matcher m = p.matcher(content);
            if (m.find()) {
                return true;
            } else {
                return false;
            }
        }
        return false;
    }

}
