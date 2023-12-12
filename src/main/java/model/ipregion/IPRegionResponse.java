package model.ipregion;

import lombok.Data;

import java.io.Serializable;

@Data
public class IPRegionResponse implements Serializable {

    private Integer ret;

    private String msg;

    private IPRegion data;

}
