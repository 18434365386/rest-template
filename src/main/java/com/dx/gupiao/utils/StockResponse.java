package com.dx.gupiao.utils;

import lombok.Data;

import java.util.List;

@Data
public class StockResponse {
    private String resultCode;
    private String reason;
    private String error_code;
    private List<StockResult> result;
}