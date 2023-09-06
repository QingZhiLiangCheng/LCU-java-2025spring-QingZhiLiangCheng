package cn.edu.lcu.cs.design_pattern.mediator.estateagent;

import java.time.Instant;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 房产中介
 */
public class EstateAgent {
    /**
     * 与客户绑定的窗体对象集合
     */
    private Set<CustomerFrame> frames = new HashSet<>();
    /**
     * 中介者保存的历史消息
     */
    private List<EstateMessage> messages = new ArrayList<>();

    /**
     * 注册登记到中介者
     *
     * @param frame
     */
    public void register(CustomerFrame frame) {
        // 双向绑定
        frames.add(frame);
        frame.setAgent(this);
    }

    public List<EstateMessage> getMessages() {
        return messages;
    }

    /**
     * 转发消息
     *
     * @param senderFrame 消息源窗体
     * @param message     消息
     */
    public void relay(CustomerFrame senderFrame, String message) {
        // 保存消息到历史记录
        messages.add(new EstateMessage(senderFrame.getCustomer(), message, Instant.now()));
        // 广播消息给所有窗口
        frames.stream().forEach(frame -> frame.receive());
    }

}
