package com.sjyf.wechat.util;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import me.chanjar.weixin.mp.api.WxMpInMemoryConfigStorage;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.api.impl.WxMpServiceImpl;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateData;
import me.chanjar.weixin.mp.bean.template.WxMpTemplateMessage;

import java.util.List;

/**
 * @Created by liaozy
 * @Date 2020/11/19 17:10
 */
@Slf4j
@AllArgsConstructor
public class WeChatPushMessage {

    public String appId;
    public String secret;

    /**
     *
     * @param openId  推送微信用户的openId
     * @param templateId  模板消息的Code
     * @param wxMpTemplateData 模板消息的内容 详见.md
     */
    public void pushWeChatMessage(String openId, String templateId, List<WxMpTemplateData> wxMpTemplateData){
        //1-配置
        WxMpInMemoryConfigStorage wxStorage = new WxMpInMemoryConfigStorage();
        wxStorage.setAppId(this.appId);
        wxStorage.setSecret(this.secret);
        WxMpService wxMpService = new WxMpServiceImpl();
        wxMpService.setWxMpConfigStorage(wxStorage);
        //2-推送消息
        WxMpTemplateMessage templateMessage = new WxMpTemplateMessage();
        //消息模板id
        templateMessage.setTemplateId(templateId);
        templateMessage.setData(wxMpTemplateData);
        try {
            //要推送的用户openid
            templateMessage.setToUser(openId);
            wxMpService.getTemplateMsgService().sendTemplateMsg(templateMessage);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
