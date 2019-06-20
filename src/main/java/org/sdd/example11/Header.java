package org.sdd.example11;

import lombok.Data;

import java.util.HashMap;
import java.util.Map;

/**
 * 整个代码文件描述
 *
 * @author 施冬冬
 * date: 2019/6/4 10:49
 */
@Data
public class Header {

    /**
     * 消息校验码，它由三部分组成：
     * 1)0xabef:固定值，表明该消息是Netty协议消息，2个字节
     * 2）主版本号：1-255，1个字节
     * 3）次版本号：1-255，1个字节
     * crcCode = 0xabef + 主版本号 + 次版本号
     */
    private int crcCode = 0xabef0101;

    /**
     * 消息长度, 整个消息，包括消息头和消息体
     */
    private int length;

    /**
     * 会话ID，集群节点内全局唯一，由会话ID生成器生成
     */
    private long sessionId;

    /**
     * 消息类型
     * 0：业务请求消息
     * 1：业务响应消息
     * 2：业务ONE WAY消息（既是请求又是响应消息）
     * 3：握手请求消息
     * 4：握手应答消息
     * 5：心跳请求消息
     * 6：心跳应答消息
     */
    private byte type;

    /**
     * 消息优先级: 0-255
     */
    private byte prority;

    /**
     * 附件，可选字段，用于扩展消息头
     */
    private Map<String, Object> attachment = new HashMap<>();


}
