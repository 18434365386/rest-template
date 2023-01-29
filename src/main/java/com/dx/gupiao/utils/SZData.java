package com.dx.gupiao.utils;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Date;

@Data
public class SZData {
    private Integer P;
//    @JsonProperty("DDATETIME")
//    @JsonFormat(pattern="yyyy-MM-dd hh:mm:ss",locale="zh",timezone="GMT+8")
    private Date DDATETIME;
    private Float R;
    private Integer fx;
    private Integer T;
    private Integer U;
    private Date CRTTIME;
    private Integer fs;
}
