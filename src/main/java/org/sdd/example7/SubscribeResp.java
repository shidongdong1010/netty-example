package org.sdd.example7;

import lombok.Data;

import java.io.Serializable;

/**
 * 整个代码文件描述
 *
 * @author 施冬冬
 * date: 2019/5/31 14:00
 */
@Data
public class SubscribeResp implements Serializable {


    /**
     * 订购编号
     */
    private int subReqID;

    /**
     * 订购结果：0表示成功
     */
    private int respCode;

    /**
     * 可选的详细描述信息
     */
    private String desc;
}
