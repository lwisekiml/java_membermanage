package memArraylist;
import java.util.Vector;
import java.util.Scanner;

public class MemberManager {
	Scanner scan = new Scanner(System.in);
	Vector<Member> members = new Vector<Member>();

	public void Run() {
		int key = 0;

		while((key = selectMenu()) != 0) {
			switch (key) {
			case 1: addMember(); break;
			case 2: removerMember(); break;
			case 3: searchMemberNum(); break;
			case 4: listMember(); break;
			default: System.out.println("잘못 선택하였습니다.");
			}
			System.out.println("while~~");
		}
		System.out.println("종료합니다...");
	}

	int selectMenu() {
		int num = 0;

		System.out.println("1.추가 2.삭제 3.검색 4.목록 0.종료");
		num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	void addMember() {
		int memNum = 0;
		String name = "";

		while(true) {
			System.out.println("추가할 회원 번호:");
			memNum =scan.nextInt();
			scan.nextLine();

			if(checkMemNumRang(memNum)) {
				if(hasMemNum(memNum)) {
					System.out.println("존재하는 회원번호 입니다.");
					continue;
				}
			}else {
				System.out.println("사용할 수 없는 회원번호 입니다.");
				System.out.println("1~100 사이의 번호를 사용할 수 있습니다.\n");
			}

			break;
		}

		System.out.println("회원 이름:");
		name = scan.nextLine();

		Member member = new Member(memNum, name);
		members.add(member);

		System.out.println(member.toString()+" 생성하였습니다.");
	}
	
	boolean checkMemNumRang(int num) {
		if (1 <= num && num <= 100)
			return true;
		else
			return false;
	}

	void removerMember() {
		int memNum = 0;

		System.out.println("삭제할 회원 번호:");
		memNum = scan.nextInt();
		scan.nextLine();
/*
		for (int i=0; i<this.members.size(); i++) {	
			if (this.members.get(i).getNum() == memNum) {
				System.out.println("번호:"+members.get(i).getNum()+" 이름:"+members.get(i).name+" 삭제하였습니다.");
				this.members.remove(i);
			}
		}
*/
		Member member = findMember(memNum);
		if(member == null) {
			System.out.println("존재하지 않는 회원번호 입니다.");
			return;
		}
		members.remove(member);
		System.out.println(member.toString()+" 삭제하였습니다.");
	}

	void searchMemberNum() {
		int memNum = 0;

		System.out.println("검색할 회원 번호:");
		memNum = scan.nextInt();
		scan.nextLine();

		Member member = findMember(memNum);
		if(member == null) {
			System.out.println("존재하지 않습니다");
			return;
		}
		System.out.println("검색 결과 >> "+member.toString());
	}
	
	void findMemberName() {
		String memName = "";
		
		System.out.println("검색할 회원 이름 :");
		memName = scan.nextLine();
		scan.nextLine();
		if(findMember(memName) != null) {
			
		}
		
	}

	void listMember() {
		System.out.println("전체 목록");
		int cnt = members.size();
		System.out.println("회원 수:"+cnt);

		for (int i=0; i<this.members.size(); i++) {	
			System.out.println("번호:"+this.members.get(i).getNum()+" 이름:"+this.members.get(i).name);
		}
	}

	Member findMember(int num) {
		for(Member member : members) {
			if(member.getNum() == num) {
				return member;
			}
		}
		return null;
	}
	
	Member findMember(String name) {
		for(Member member : members) {
			if(member.getName() == name) {
				return member;
			}
		}
		return null;
	}

	boolean hasMemNum(int num) {
		for(Member member : members) {
			if(member.getNum() == num) {
				return true;
			}
		}
		return false;
	}
}
