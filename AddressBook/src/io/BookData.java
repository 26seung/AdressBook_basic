package io;

public class BookData {

	private String name;
	private String hp;
	private String tel;
	
	///////////////////////////////////////////////////
	
	public BookData() {									// Q. 작동 원인이 무었인지?  같은 메서드명 두개가 사용됨
		
	}
	
	public BookData(String name, String hp, String tel) {
		this.name = name;
		this.hp = hp;
		this.tel = tel;
	}
	
	///////////////////////////////////////////////////
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getHp() {
		return hp;
	}
	public void setHp(String hp) {
		this.hp = hp;
	}
	public String getTel() {
		return tel;
	}
	public void setTel(String tel) {
		this.tel = tel;
	}

	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return name + "," + hp + "," + tel ;
	}
	
	///////////////////////////////////////////////////
	
}
