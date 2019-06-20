package org.sdd.example11;

import lombok.Data;

/**
 * 整个代码文件描述
 *
 * @author 施冬冬
 * date: 2019/6/4 11:08
 */
@Data
public class NettyMessage {

    /**
     * 消息头
     */
    private Header header;

    /**
     * 消息体
     */
    private Object body;

    public Header getHeader() {
        return header;
    }

    public void setHeader(Header header) {
        this.header = header;
    }

    public Object getBody() {
        return body;
    }

    public void setBody(Object body) {
        this.body = body;
    }
}
