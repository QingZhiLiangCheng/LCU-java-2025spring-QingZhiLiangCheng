package cn.edu.lcu.cs.designpattern.command.electric_switch;

/**
 * @description: 地雷爆炸命令
 * @author: ling
 * @since: 2021-10-11 21:21
 **/
public class MineBombCmd implements Command {
    private Mine mine;

    public MineBombCmd(Mine mine) {
        this.mine = mine;
    }


    @Override
    public void execute() {
        mine.bomb();
    }
}
