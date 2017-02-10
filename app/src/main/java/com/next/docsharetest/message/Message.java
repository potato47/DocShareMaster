package com.next.docsharetest.message;

/**
 * Created by Administrator on 2016/12/28 0028.
 */

public class Message {
    private String tip;//截取content部分内容加上name在缩略图显示
    private String name;
    private String content;
    private String time;

    public Message(String name, String content, String time) {
        this.name = name;
        this.content = content;
        this.time = time;
        if(content.length()>15){
            this.tip=name+":"+content.substring(0,15)+"...";//截取长度待定
        }else{
            this.tip = name+":"+content;
        }
    }

    public String getName() {
        return name;
    }

    public String getContent() {
        return content;
    }

    public String getTime() {
        return time;
    }

    public String getTip(){return tip;}
}
