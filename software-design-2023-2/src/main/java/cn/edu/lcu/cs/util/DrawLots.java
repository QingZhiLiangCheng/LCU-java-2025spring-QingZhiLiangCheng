package cn.edu.lcu.cs.util;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Random;

/**
 * 抽签程序：从指定文本文件中抽取其中一行并显示。 <br>
 * 应检异常：URISyntaxException，IOException，如果不处理，编译器会报错。 <br>
 * 要么向上抛出异常，要么catch异常。
 * 
 * @author Ling
 *
 */
public class DrawLots {
	public static void main(String[] args) throws URISyntaxException {
		String filename = "/课堂表现.csv";
		URI uri = DrawLots.class.getResource(filename).toURI();
		List<String> lines = null;
		try {
			lines = Files.readAllLines(Paths.get(uri)/*, Charset.forName("GBK")*/);
		} catch (IOException e) {
			e.printStackTrace();
		}
		String line = lines.get(new Random().nextInt(lines.size()));
		System.out.println(line);
	}

}
