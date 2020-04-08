package memArraylist;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;

public class FileManager {
	File fileName = new File("test.txt");
	
	void fileRead(MemberManager mm) throws Exception {
		String fileRead = "";

		try {
			if(checkBeforeFile(fileName)) {
				BufferedReader fr = new BufferedReader(new FileReader(fileName));
				while((fileRead = fr.readLine()) != null) {
					System.out.println("읽은 파일 내용 : "+fileRead);
					
					String[] mem = fileRead.split(",");
					
					int memNum = Integer.parseInt(mem[0]);
					String memName = mem[1];

					System.out.println("파싱한 내용 : ["+memNum+" "+memName+"]");
					Member member = new Member(memNum, memName);
					mm.members.add(member);
				}
				fr.close();
			} else {
				System.out.println("존재하지 않은 파일입니다.");
			}
		}catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
	
	boolean checkBeforeFile(File file) {
		if(file.exists()) {
			if(file.isFile() && file.canRead()) {
				return true;
			}
		}
		return false;
	}
	
	void fileWrite(MemberManager mm) throws Exception {
		try {
			BufferedWriter fw = new BufferedWriter(new FileWriter(fileName));
			for(int i=0; i<mm.members.size(); i++) {
				System.out.println(mm.members.get(i).fileWrite());
				
				fw.write(mm.members.get(i).fileWrite());
				fw.write("\n");
			}
			fw.close();
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
	}
}
