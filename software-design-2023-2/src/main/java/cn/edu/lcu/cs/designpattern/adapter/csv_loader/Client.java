package cn.edu.lcu.cs.designpattern.adapter.csv_loader;

/**
 * 2022/10/23 16:29
 *
 * @Author ling
 */
public class Client {
    public static void main(String[] args) {
        String filename = "2020.34.csv";
        TxtFileLoader txtFileLoader = new TxtFileLoaderImpl(filename);

        PersonLoader personLoader = new CsvPersonLoader(txtFileLoader);
        personLoader.load().forEach(System.out::println);

    }
}
