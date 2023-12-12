package utils;

/**
 * 异常工具类
 */
public class ThrowableUtils {

    /**
     * 获取以指定包名为前缀的堆栈信息
     *
     * @param e 异常
     * @return 堆栈信息
     */
    public static String getStackTraceByPn(Throwable e) {
        StringBuilder s = new StringBuilder("\n").append(e);
        for (StackTraceElement traceElement : e.getStackTrace()) {
            s.append("\n\tat ").append(traceElement);
        }
        return s.toString();
    }

}
