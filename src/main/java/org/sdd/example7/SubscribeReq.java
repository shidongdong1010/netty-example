package org.sdd.example7;

import lombok.Data;

import java.io.Serializable;

/**
 * 整个代码文件描述
 *
 * @author 施冬冬
 * date: 2019/5/31 13:58
 */
@Data
public class SubscribeReq implements Serializable {

    /**
     * 订购编号
     */
    private int subReqID;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 订购的产品名称
     */
    private String productName;

    /**
     * 订购者电话号码
     */
    private String phoneNumber;

    /**
     * 订购者的家庭地址
     */
    private String address;
}
