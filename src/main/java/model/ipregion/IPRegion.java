package model.ipregion;

import lombok.Data;

import java.io.Serializable;

@Data
public class IPRegion implements Serializable {
    private String ip;            // IP地址
    private String longIp;        // 长整型IP地址
    private String isp;           // 运营商信息
    private String area;          // 区域
    private String regionId;      // 区域ID
    private String region;        // 区域名称
    private String cityId;        // 城市ID
    private String city;          // 城市名称
    private String district;      // 区/县
    private String districtId;    // 区/县ID
    private String countryId;     // 国家ID
    private String country;       // 国家名称
    private String lat;           // 纬度
    private String lng;           // 经度
}
