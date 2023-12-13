package enums;

/**
 * 省份字典枚举
 */
public enum ProvinceCodeEnum {

    BEI_JING("110000", 110000, "北京市"),
    TIAN_JIN("120000", 120000, "天津市"),
    HE_BEI("130000", 130000, "河北省"),
    SHAN_XI("140000", 140000, "山西省"),
    NEI_MENG_GU("150000", 150000, "内蒙古自治区"),
    LIAO_NING("210000", 210000, "辽宁省"),
    JI_LIN("220000", 220000, "吉林省"),
    HEI_LONG_JIANG("230000", 230000, "黑龙江省"),
    SHANG_HAI("310000", 310000, "上海市"),
    JIANG_SU("320000", 320000, "江苏省"),
    ZHE_JIANG("330000", 330000, "浙江省"),
    AN_HUI("340000", 340000, "安徽省"),
    FU_JIAN("350000", 350000, "福建省"),
    JIANG_XI("360000", 360000, "江西省"),
    SHAN_DONG("370000", 370000, "山东省"),
    HE_NAN("410000", 410000, "河南省"),
    HU_BEI("420000", 420000, "湖北省"),
    HU_NAN("430000", 430000, "湖南省"),
    GUANG_DONG("440000", 440000, "广东省"),
    GUANG_XI("450000", 450000, "广西壮族自治区"),
    HAI_NAN("460000", 460000, "海南省"),
    CHONG_QING("500000", 500000, "重庆市"),
    SI_CHUAN("510000", 510000, "四川省"),
    GUI_ZHOU("520000", 520000, "贵州省"),
    YUN_NAN("530000", 530000, "云南省"),
    XI_ZANG("540000", 540000, "西藏自治区"),
    SHAAN_XI("610000", 610000, "陕西省"),
    GAN_SU("620000", 620000, "甘肃省"),
    QING_HAI("630000", 630000, "青海省"),
    NING_XIA("640000", 640000, "宁夏回族自治区"),
    XIN_JIANG("650000", 650000, "新疆维吾尔自治区"),
    TAI_WAN("710000", 710000, "台湾省"),
    XIANG_GANG("810000", 810000, "香港特别行政区"),
    AO_MEN("820000", 820000, "澳门特别行政区");

    /**
     * 省份编码
     */
    public final String code;

    /**
     * 省份数字编码
     */
    public final Integer number;

    /**
     * 省份名称
     */
    public final String name;

    ProvinceCodeEnum(String code, Integer number, String name) {
        this.code = code;
        this.number = number;
        this.name = name;
    }

    /**
     * 通过code获取枚举
     */
    public static String getByCode(String name) {
        String code = null;
        for (ProvinceCodeEnum value : values()) {
            if (value.name.equals(name)) {
                code = value.code;
            }
        }
        return code;
    }


}
