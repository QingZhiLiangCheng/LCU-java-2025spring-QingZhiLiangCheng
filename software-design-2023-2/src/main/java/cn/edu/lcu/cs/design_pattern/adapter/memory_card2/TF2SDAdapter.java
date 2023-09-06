package cn.edu.lcu.cs.design_pattern.adapter.memory_card2;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * TF卡到SD卡的适配器。
 * 聚合适配者类。
 */
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TF2SDAdapter implements SDCard {
    private TFCard tfCard;

    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        return tfCard.readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        tfCard.writeTF(msg);
    }
}