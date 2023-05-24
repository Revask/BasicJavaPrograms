package BasicJavaPrograms;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TextFileWordCount {
public static void main(String[] args) {
	System.out.println("Hello");
	FileReader fr;
	try {
		fr = new FileReader(new File("C:\\TestingRelated\\wordcount.txt"));
		BufferedReader br = new BufferedReader(fr);
		while(br.read() != -1)
		{	System.out.println(br.read());
			
		}
	} catch (FileNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
}
