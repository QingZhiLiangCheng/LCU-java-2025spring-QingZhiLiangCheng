package cn.edu.lcu.cs.designpattern.adapter.memory_card;

/**
 * TF卡到SD卡的适配器。
 * 继承适配者类。
 */
public class TF2SDAdapter extends TFCardImpl implements SDCard {

    /**
     * 旧接口中声明的方法，适配器类需要实现它。
     *
     * @return
     */
    @Override
    public String readSD() {
        System.out.println("adapter read tf card ");
        // 调用从另外的类系列继承而来的方法，实现接口的功能
        // 两种不匹配的类系列实现完美适配。
        return readTF();
    }

    @Override
    public void writeSD(String msg) {
        System.out.println("adapter write tf card");
        writeTF(msg);
    }
}