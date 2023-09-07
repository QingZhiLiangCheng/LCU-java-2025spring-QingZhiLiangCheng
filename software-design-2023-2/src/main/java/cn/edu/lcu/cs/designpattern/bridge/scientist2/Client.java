package cn.edu.lcu.cs.designpattern.bridge.scientist2;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-28 16:06
 **/
public class Client {
    public static void main(String[] args) {
        ScienceDiscipline biology = new Biology();
        biology.setScientist(new ManScientist());
        biology.print();

        ScienceDiscipline computer = new Computer();
        computer.setScientist(new WomanScientist());
        computer.print();
    }
}
