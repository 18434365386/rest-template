package com.dx.gupiao.utils;

import lombok.Data;

import java.util.List;

@Data
public class SZResponse {
    private String total;
    private String page;
    private String rows;
    private List<SZData> data;
}
