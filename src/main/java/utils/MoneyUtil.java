package utils;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.text.NumberFormat;

/**
 * 金额工具类
 */
public class MoneyUtil {

    /**
     * 分转元
     *
     * @param price
     * @return
     */
    public static long changeY2F(BigDecimal price) {
        DecimalFormat df = new DecimalFormat("#.00");
        String format = df.format(price);
        BigDecimal subtract = new BigDecimal(format).multiply(new BigDecimal("100"));
        return subtract.longValue();
    }

    /**
     * 元转分
     *
     * @param price
     * @return
     */
    public static BigDecimal changeF2Y(long price) {
        return BigDecimal.valueOf(price).divide(new BigDecimal(100)).setScale(2, RoundingMode.HALF_UP);
    }

    /**
     * 将数值金额转换为中文大写金额
     *
     * @param money
     * @return
     */
    public static String transitionMoney(double money) {
        String[] upNum = {"零", "壹", "贰", "叁", "肆", "伍", "陆", "柒", "捌", "玖"};
        String[] danwei = {"圆", "拾", "佰", "仟", "万", "拾", "佰", "仟", "亿", "拾", "佰", "仟"};
        //取消科学记数法
        NumberFormat numFormat = NumberFormat.getInstance();
        numFormat.setMaximumFractionDigits(2);//设置小数位个数
        numFormat.setGroupingUsed(false);//取消科学技术法
        String formatNum = numFormat.format(money);
        String lastUpNum = "null"; //用于存放上个参数的值
        String result = "";//返回的结果
        String[] split = formatNum.split("\\.");
        String strMoney = split[0];
        String point = "";
        //小数部分取值处理。
        if (split.length > 1) {
            point = split[1];
            if (point.length() == 1) {
                point = point.concat("0");
            }
        } else {
            point = "0";
        }
        //大于12位就直接返回。
        int moneyLen = strMoney.length();
        if (money == 0) {
            return "零圆整";
        }
        if (moneyLen > 12) {
            return "金额：" + money + "元，超出大写转换范围。最大金额：999999999999.99元";
        }
        //整数(integer)部分处理。
        if (!"0".equals(strMoney)) {
            for (int i = 0; i < moneyLen; i++) {
                String strNum = strMoney.charAt(i) + "";
                int singleNum = Integer.parseInt(strNum);
                String upSingleNum = upNum[singleNum];
                //上一为不等于0的情况
                if (!"零".equals(lastUpNum)) {
                    if (!"零".equals(upSingleNum)) {
                        result = result.concat(upSingleNum).concat(danwei[moneyLen - i - 1]);
                    } else
                        //为零但是在万、亿位上要加单位 (moneyLen-i)==9 指的是单位：亿。  (moneyLen-i)==5指的是单位：万
                        if ((moneyLen - i) == 5 || (moneyLen - i) == 9) {
                            lastUpNum = "";
                        } else {
                            result = result.concat(upSingleNum);
                        }
                }
                //上一位为0的情况
                if ("零".equals(lastUpNum) && !"零".equals(upSingleNum)) {
                    result = result.concat(upSingleNum).concat(danwei[moneyLen - i - 1]);
                }
                //捕捉上一位数（lastUpNum）为零的情况做优化。
                if ((moneyLen - i) == 5 || (moneyLen - i) == 9) {
                    //排除加单位时前面为"零"的情况。如：两百零万
                    if ("零".equals(lastUpNum) || "null".equals(lastUpNum)) {
                        result = result.substring(0, result.length() - 1);
                    }
                    if (!result.endsWith("亿")) {
                        result = result.concat(danwei[moneyLen - i - 1]);
                    }
                    lastUpNum = "";
                } else {
                    //把当前大写数字复制给 lastUpNum 用于下次判断
                    lastUpNum = upSingleNum;
                }
            }
            //对几万元整和几亿元整(result:五万零或者五亿零零)做优化。
            result = result.replaceAll("零零", "零");
            if (result.endsWith("零")) {
                String substring = result.substring(0, result.length() - 1);
                result = substring;
            }
            result = result.concat("圆");
            result = result.replaceAll("圆圆", "圆");
            result = result.replaceAll("万万", "万");

        }

        //小数(point)部分处理
        if ("0".equals(point)) {
            result = result + "整";
        } else {
            String str = upNum[Integer.parseInt(point.charAt(1) + "")] + "分";
            if ((point.charAt(0) + "").equals("0")) {
                result = result.concat(str);
            } else {
                String concat = result.concat(upNum[Integer.parseInt(point.charAt(0) + "")] + "角");
                if ((point.charAt(1) + "").equals("0")) {
                    result = concat;
                } else {
                    result = concat.concat(str);
                }
            }
        }
        return result;
    }

}
