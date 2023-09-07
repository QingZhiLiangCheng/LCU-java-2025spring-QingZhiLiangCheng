package cn.edu.lcu.cs.designpattern.command.macro_command;

/**
 * @description: 客户端
 * @author: ling
 * @since: 2021-10-13 21:19
 **/
public class Client {
    public static void main(String[] args) {
        // 创建并配置宏命令对象
        MacroCmd macroCmd = new MacroCmd();
        macroCmd.append(new CompileCmd());
        macroCmd.append(new LinkCmd());
        macroCmd.append(new DebugCmd());
        // 直接执行宏命令
        // macroCmd.execute();

        // 也可以将宏命令与功能键绑定
        FunctionButton functionButton = new FunctionButton(macroCmd);
        // 在功能键上模拟单击一次，间接执行宏命令
        functionButton.onClick();

        System.out.println("-------华丽丽的分隔线--------");

        // 创建并执行一个单独的命令
        CompileCmd compileCmd = new CompileCmd();
        compileCmd.execute();
    }
}
