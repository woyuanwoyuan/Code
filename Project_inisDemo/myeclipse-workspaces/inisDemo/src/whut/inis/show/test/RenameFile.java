package whut.inis.show.test;

import java.io.File;
import java.io.IOException;

public class RenameFile {
	//file重命名之前的文件名，toFile重命名之后的文件名
	public void renameFile(String file, String toFile) {

        File toBeRenamed = new File(file);
        //检查要重命名的文件是否存在，是否是文件
        if (!toBeRenamed.exists() || toBeRenamed.isDirectory()) {

            System.out.println("File does not exist: " + file);
            return;
        }

        File newFile = new File(toFile);

        //修改文件名
        if (toBeRenamed.renameTo(newFile)) {
            System.out.println("File has been renamed.");
        } else {
            System.out.println("Error renmaing file");
        }

    }
public static void main(String[] args) throws IOException {
	RenameFile rn = new RenameFile();
	rn.renameFile("D:/新建文件夹/1.txt","D:/新建文件夹/2.txt");
}
}
