package cn.edu.lcu.cs.design_pattern.command.macro_command;

/**
 * 构造并运行的命令。编译、链接、运行一条龙。
 * 宏命令，可由用户自定义，也可提前预置。
 * 本例即是预置好的宏命令。
 *
 * @Author Ling
 * @Date 2021/10/14 11:56
 * @Version 1.0
 */
public class BuildAndRunCmd extends MacroCmd {
    public BuildAndRunCmd() {
        append(new CompileCmd());
        append(new LinkCmd());
        append(new RunCmd());
    }
}
