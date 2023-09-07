package cn.edu.lcu.cs.designpattern.command.function_button;

import java.util.Scanner;

/**
 * 命令模式，模拟功能键
 */
public class Client {
    public static void main(String[] args) {
        FunctionButton button = new FunctionButton();
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入功能键的选项：");
        System.out.println("1：退出系统；2：窗口最大化；3：窗口最小化");
        int select = scanner.nextInt();
        switch (select) {
            case 1:
                button.setCommand(new ExitSystemCmd());
                break;
            case 2:
                button.setCommand(new MaximizeCmd());
                break;
            case 3:
                button.setCommand(new MinimizeCmd());
                break;
        }
        button.onClick();

    }
}
