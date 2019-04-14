package Set;

import java.io.File;

public class _file_exist {

	public static void main(String[] args) {
		String filename="aaa.txt";
		File file=new File(filename);
		System.out.println(file.exists());

	}

}
