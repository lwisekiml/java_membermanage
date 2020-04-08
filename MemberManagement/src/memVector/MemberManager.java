package memVector;
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
			default: System.out.println("�߸� �����Ͽ����ϴ�.");
			}
			System.out.println("while~~");
		}
		System.out.println("�����մϴ�...");
	}

	int selectMenu() {
		int num = 0;

		System.out.println("1.�߰� 2.���� 3.�˻� 4.��� 0.����");
		num = scan.nextInt();
		scan.nextLine();
		return num;
	}

	void addMember() {
		int memNum = 0;
		String name = "";

		while(true) {
			System.out.println("�߰��� ȸ�� ��ȣ:");
			memNum =scan.nextInt();
			scan.nextLine();

			if(checkMemNumRang(memNum)) {
				if(hasMemNum(memNum)) {
					System.out.println("�����ϴ� ȸ����ȣ �Դϴ�.");
					continue;
				}
			}else {
				System.out.println("����� �� ���� ȸ����ȣ �Դϴ�.");
				System.out.println("1~100 ������ ��ȣ�� ����� �� �ֽ��ϴ�.\n");
			}

			break;
		}

		System.out.println("ȸ�� �̸�:");
		name = scan.nextLine();

		Member member = new Member(memNum, name);
		members.add(member);

		System.out.println(member.toString()+" �����Ͽ����ϴ�.");
	}
	
	boolean checkMemNumRang(int num) {
		if (1 <= num && num <= 100)
			return true;
		else
			return false;
	}

	void removerMember() {
		int memNum = 0;

		System.out.println("������ ȸ�� ��ȣ:");
		memNum = scan.nextInt();
		scan.nextLine();
/*
		for (int i=0; i<this.members.size(); i++) {	
			if (this.members.get(i).getNum() == memNum) {
				System.out.println("��ȣ:"+members.get(i).getNum()+" �̸�:"+members.get(i).name+" �����Ͽ����ϴ�.");
				this.members.remove(i);
			}
		}
*/
		Member member = findMember(memNum);
		if(member == null) {
			System.out.println("�������� �ʴ� ȸ����ȣ �Դϴ�.");
			return;
		}
		members.remove(member);
		System.out.println(member.toString()+" �����Ͽ����ϴ�.");
	}

	void searchMemberNum() {
		int memNum = 0;

		System.out.println("�˻��� ȸ�� ��ȣ:");
		memNum = scan.nextInt();
		scan.nextLine();

		Member member = findMember(memNum);
		if(member == null) {
			System.out.println("�������� �ʽ��ϴ�");
			return;
		}
		System.out.println("�˻� ��� >> "+member.toString());
	}
	
	void findMemberName() {
		String memName = "";
		
		System.out.println("�˻��� ȸ�� �̸� :");
		memName = scan.nextLine();
		scan.nextLine();
		if(findMember(memName) != null) {
			
		}
		
	}

	void listMember() {
		System.out.println("��ü ���");
		int cnt = members.size();
		System.out.println("ȸ�� ��:"+cnt);

		for (int i=0; i<this.members.size(); i++) {	
			System.out.println("��ȣ:"+this.members.get(i).getNum()+" �̸�:"+this.members.get(i).name);
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
