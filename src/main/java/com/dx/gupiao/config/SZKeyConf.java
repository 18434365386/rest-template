package com.dx.gupiao.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties("sz-key")
public class SZKeyConf {
    private String szKey;
}
