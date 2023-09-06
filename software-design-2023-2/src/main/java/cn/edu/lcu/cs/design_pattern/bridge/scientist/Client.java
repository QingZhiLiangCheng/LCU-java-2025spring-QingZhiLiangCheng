package cn.edu.lcu.cs.design_pattern.bridge.scientist;

/**
 * @description:
 * @author: ling
 * @since: 2021-09-28 16:06
 **/
public class Client {
    public static void main(String[] args) {
        Scientist manScientist = new ManScientist();
        manScientist.setScienceDiscipline(new Computer());
        manScientist.print();

        Scientist womanScientist = new WomanScientist();
        womanScientist.setScienceDiscipline(new Physics());
        womanScientist.print();
    }
}
