package cn.edu.lcu.cs.design_pattern.simple_factory;

import cn.edu.lcu.cs.designpattern.simple_factory.computer_factory.Computer;

/**
 * @Description 用传统的new操作创建对象
 * @Author Ling
 * @Date 2021/9/2 23:45
 * @Version 1.0
 */
public class ClassicNewOperation {
    public static void main(String[] args) {
        String cpu = "第十代智能英特尔® 酷睿™ i7-10700F 处理器";
        String memory = "8GB, 8Gx1, DDR4, 2933MHz";
        String disk = "512GB M.2 PCIe NVMe 固态硬盘";
        String videoCard = "NVIDIA® GeForce® GT™ 730 2GB GDDR5";
        String display = "27英寸微边框显示器 S2719H";
        String os = "Windows 10 家庭单语言版";

        // 调用默认的构造方法创建缺省的对象，再调用一系列方法设置各种属性
        // 客户端程序需要自己组装各种属性，有点烦
        Computer computer = new Computer();
        computer.setCpu(cpu);
        computer.setMemory(memory);
        computer.setDisk(disk);
        computer.setVideoCard(videoCard);
        computer.setDisplay(display);
        computer.setOs(os);
        System.out.println(computer);

        // 调用带参的构造方法，传入所需的参数
        // 这些构造方法可能已经被很多很多很多……客户程序调用过了
        // 如果原来的构造方法签名需要修改，比如调整参数的名称或者位置、添加参数，还需要修改许许多多的客户代码，恶梦开始了，客户流失了
        Computer computer1 = new Computer(cpu, memory, disk, videoCard, display, os);
        System.out.println(computer1);

        // 我很懒，也很烦，只要念动咒语，告诉神灯，我想要XXX样的东西，它就能变出来，世界瞬间美好了
        // 管它怎么创建的，管它调用的什么方法，我统统不管
        // 如何做到？？？
    }
}
