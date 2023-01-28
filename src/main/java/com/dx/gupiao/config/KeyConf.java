package com.dx.gupiao.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("key-stock")
public class KeyConf {
    /**
     * app key config
     */
    private String appKey;
}
