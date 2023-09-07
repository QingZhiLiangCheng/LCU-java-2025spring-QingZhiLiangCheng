package cn.edu.lcu.cs.designpattern.mediator.estateagent;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.time.Instant;

/**
 * 房产消息
 */
@Data
@AllArgsConstructor
class EstateMessage {
    /**
     * 消息的发布者
     */
    private Customer customer;
    /**
     * 消息内容
     */
    private String message;
    /**
     * 发布时间
     */
    private Instant postTime;
}
