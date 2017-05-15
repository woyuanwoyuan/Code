package whut.inis.show.test;

import java.io.File;
import java.io.IOException;

public class RenameFile {
	//file������֮ǰ���ļ�����toFile������֮����ļ���
	public void renameFile(String file, String toFile) {

        File toBeRenamed = new File(file);
        //���Ҫ���������ļ��Ƿ���ڣ��Ƿ����ļ�
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {

            System.out.println("File does not exist: " + file);
            return;
        }

        File newFile = new File(toFile);

        //�޸��ļ���
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }

    }
public static void main(String[] args) throws IOException {
	RenameFile rn = new RenameFile();
	rn.renameFile("D:/�½��ļ���/1.txt","D:/�½��ļ���/2.txt");
}
}
