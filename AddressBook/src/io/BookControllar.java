package io;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;
import java.io.Writer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class BookControllar {

	Scanner sc = new Scanner(System.in);
	
	
	public void addressBook () {						
		
		BookView view = new BookView();
		
		while(true) {
			view.startView();
			view.menuView();
			
			
			switch (sc.nextInt()) {						
				case 1: // 조회
					view.listView();
					listData();
					continue;
				case 2: //등록
					view.addView();
					addFile();
					continue;
				case 3: //삭제
					view.delView();
					delData();
					continue;
				case 4: //검색
					view.searchView();
					searchData();
					continue;
				case 5: //종료
					view.endView();
					break;
				default :	// 없는 메뉴
					view.erView();
					continue;
			}
			sc.close();
			break;
		}
		
	}
		///////////////////////////////////////////////////
	public List<BookData>getFile(){
		
		List<BookData>list = new ArrayList<>();
		
		try {
			Reader rd = new FileReader("files\\data.txt");
			BufferedReader br = new BufferedReader(rd);
			String line = null;
			BookData data = null;

			while((line=br.readLine()) != null) {	
//				BookData data = new BookData();				 이해안간다 위에는 적용안됨
				data = new BookData();						// 이런 식으로 하면 적용 가능
				String[] dataArray = new String[3];
				dataArray = line.split(",");
				if (dataArray.length != 3) continue;	// 왜 넣어야 하는지 변수생각해보자.
				
				data.setName(dataArray[0]);
				data.setHp(dataArray[1]);
				data.setTel(dataArray[2]);
				list.add(data);
				
			} 
			br.close();
			
		} catch(Exception e) {
			e.printStackTrace();
			System.out.println("Not Found File!!");
		} 
		return list;
	}

	
	public void listData() {
		
		List<BookData>data = getFile();
		for (int i = 0; i < data.size(); i++) {
			System.out.print(i+1 +".");
			System.out.print(data.get(i).getName()+"\t");
			System.out.print(data.get(i).getHp()+"\t");
			System.out.print(data.get(i).getTel()+"\n");
		}	System.out.println("");
			System.out.println("    ----- [검색 완료] -----");
	}
	
		///////////////////////////////////////////////////
	
	public BookData addData() {
		
		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화: ");
		String hp = sc.next();
		System.out.print(">집전화: ");
		String tel = sc.next();
		
		BookData data = new BookData(name,hp,tel);
		
		return data;
	}

	public void addFile() {
		
		try {
			BookData data = addData();
			
			Writer fw = new FileWriter("files\\data.txt",true);
			BufferedWriter bw = new BufferedWriter(fw);
			
			String str;
			str = data.getName() + "," + data.getHp() + "," + data.getTel();
			
			
			bw.newLine();
			bw.append(str);
//			bw.write(str);			// ( append or write ) 차이점은?
			bw.flush();
			bw.close();
		} catch(Exception e) {
			e.printStackTrace();
		} 	System.out.println("");
			System.out.println("    ----- [등록 완료] -----");
	}
		
	
	///////////////////////////////////////////////////
	
	public void delData() {		
		
		List<BookData>data = getFile();
		
		try {
		Writer fw = new FileWriter("files\\data.txt");
		BufferedWriter bw = new BufferedWriter(fw);
		
		String str = null;
		data.remove(sc.nextInt()-1);
		for (int i = 0; i < data.size(); i++) {
			str = data.get(i).getName() + "," + data.get(i).getHp() + "," + data.get(i).getTel() + "\n";
			
//			bw.newLine();				//  "\n" 대신 사용하면 데이터가 한칸 아래에 파일 저장됨
			bw.write(str);
		}	
		
		bw.flush();
		bw.close();
		
		}  catch(Exception e) {
			e.printStackTrace();
		}	System.out.println("");
			System.out.println("    ----- [삭제 완료] -----");
			System.out.println("");
			listData();
		

	}
	
	///////////////////////////////////////////////////
	
	public void searchData() {
		
		List<BookData>list = getFile();				// getFile 의 list 저장 파일에서 읽어옴
		String search = sc.next();
		
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().contains(search)) {
				System.out.print(i+1 +".");
				System.out.print(list.get(i).getName()+"\t");
				System.out.print(list.get(i).getHp()+"\t");
				System.out.print(list.get(i).getTel()+"\n");
			}
		}	System.out.println("");
			System.out.println("    ----- [검색 완료] -----");
	}
	
	///////////////////////////////////////////////////
	
	
}
