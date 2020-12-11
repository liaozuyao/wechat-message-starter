package com.sjyf.wechat.properties;

import lombok.Getter;
import lombok.Setter;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @Created by liaozy
 * @Date 2020/11/19 17:22
 */
@Getter
@Setter
@ConfigurationProperties(prefix = "wechat.xxx")
public class WeChatPushProperties {

    private String appId;
    private String secret;
    private Boolean enable = false;
}
