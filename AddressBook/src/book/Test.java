package book;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.Reader;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try {
				Reader rd = new FileReader("files\\data.txt");
				BufferedReader br = new BufferedReader(rd);
				String line=null;
				while((line=br.readLine())!=null) {
				System.out.println(line);
				}
			}catch (Exception e) {
				e.printStackTrace();
				System.err.println("파일이 없습니다.");
			}
	}

}
