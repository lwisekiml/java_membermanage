package memArraylist;

public class Member {
	final private int num;
	String name;
	public Member(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getNum() {
		return num;
	}
	
	public String getName() {
		return name;
	}
	
	public String toString() {
		return String.format("번호:%d 이름:%s", num, name);
	}
	
	public String fileWrite() {
		return String.format("%d,%s", num, name);
	}
}
