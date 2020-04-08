package memVector;
public class Program {
	public static void main(String[] args) throws Exception {
		MemberManager mm = new MemberManager();
		FileManager fm = new FileManager();
		fm.fileRead(mm);
//		mm.members = fm.members; // 얕은복사?
		mm.Run();
		fm.fileWrite(mm);
	}
}

/*
//Scanner 사용
Scanner sc = new Scanner(new File(fileName));
while(sc.hasNextLine()) {
	System.out.println(sc.nextLine());
}

// BufferedReader 사용
BufferedReader fr = new BufferedReader(new FileReader(fileName));
while((fileRead = fr.readLine()) != null) {
	System.out.println(fileRead);
}
fr.close();

// file write
BufferedWriter fw = new BufferedWriter(new FileWriter(fileName, false)); // true: 이어쓰기, false: 새로쓰기
fw.write(txt);
fw.flush();
fw.close();
*/