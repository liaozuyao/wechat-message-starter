package com.sjyf.wechat.config;

import com.sjyf.wechat.properties.WeChatPushProperties;
import com.sjyf.wechat.util.WeChatPushMessage;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Created by liaozy
 * @Date 2020/11/19 17:24
 */
@Configuration
@RequiredArgsConstructor
@EnableConfigurationProperties(WeChatPushProperties.class)
@ConditionalOnProperty(prefix = "wechat.xxx")
public class WeChatPushMessageConfiguration {

    private final WeChatPushProperties weChatPushProperties;

    @Bean
    public WeChatPushMessage weChatPushMessage(){
        return new WeChatPushMessage(weChatPushProperties.getAppId(), weChatPushProperties.getSecret());
    }
}
