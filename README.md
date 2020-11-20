##微信公众号消息推送自定义 springboot starter

### 相关yml配置信息
wechat:
  xxx:
    appId: wxaba8345e57d9cb3e
    secret: 97aa00b442fd05191aada4484a184a6a

####相关参数组装
List<WxMpTemplateData> wxMpTemplateData = new ArrayList<>();
//消息颜色值
String color = "#000000";
wxMpTemplateData.add(new WxMpTemplateData("first", "消息通知头", color));
wxMpTemplateData.add(new WxMpTemplateData("keyword1", 消息内容参数1, color));
wxMpTemplateData.add(new WxMpTemplateData("keyword2", 消息内容参数2, color));
wxMpTemplateData.add(new WxMpTemplateData("keyword3", 消息内容参数3, color));
wxMpTemplateData.add(new WxMpTemplateData("remark", "消息通知尾", color));
