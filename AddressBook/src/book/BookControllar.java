package book;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BookControllar {

	Scanner sc = new Scanner(System.in);
	BookView view = new BookView();
//	List<BookData>list = new ArrayList<>();				// Q. (Array Linked) 어떤것을 쓰는것이 더 좋고 효울적인 건지? 
	List<BookData>list = new LinkedList<>();
														// Q. (바이트 / 문자) 기반 스트림 적절한 사용처?  Q. 인코딩 방식 지정하면 바이트 스트림 사용이 유리한지?
														// <바이트 스트림은 데이터를 있는 그대로 송수진 하기에 다른 프로그램 이용하여 읽을경우 문제 발생 할 수 있음> / <믄자 스트림은 해당 운영체제의 인코딩 형식>
	
	
	public void addressBook () {						// Q. protected / public 어떤것을 사용하는 것이 좋은 건지?
		
		while(true) {
			view.startView();
			view.menuView();
			
			
			switch (sc.nextInt()) {						// Q. 잘못된 값을 입력하였을때 에러 종료가 아닌 다시 시작하는 방법을 찾아보자
				case 1: // 조회
					view.listView();
					listData();
					continue;
				case 2: //등록
					view.addView();
					addData();
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
		
	public void listData() {
//		System.out.println(list.toString());
		for (int i = 0; i < list.size(); i++) {
//			System.out.printf(i +data.getName()+data.getHp()+data.getTel());			// 에러 . null 값 나옴 
			System.out.printf((i+1) + "," + list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getTel() + "%n");
		}
	}
	
		///////////////////////////////////////////////////
			
	public void addData() {
		
		System.out.print(">이름: ");
		String name = sc.next();
		System.out.print(">휴대전화: ");
		String hp = sc.next();
		System.out.print(">집전화: ");
		String tel = sc.next();
		
		list.add(new BookData(name,hp,tel));
				
	}
	
	///////////////////////////////////////////////////
	
	public void delData() {
		
		
//		list.remove(sc.nextInt() -1);
		
	}
	
	///////////////////////////////////////////////////
	
	public void searchData() {
		System.out.print("데이터 검색: ");
		String search = sc.next();
		for(int i = 0; i < list.size(); i++) {
			if(list.get(i).getName().contains(search)) {						// contains 을 통해 포함 된 문자열 검색기능
				System.out.printf((i+1) + "," + list.get(i).getName() + "," + list.get(i).getHp() + "," + list.get(i).getTel() + "%n");
				}
		}
		
	}
	
	///////////////////////////////////////////////////
	
	
}
