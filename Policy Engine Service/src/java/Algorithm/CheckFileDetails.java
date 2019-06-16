package Algorithm;

import java.io.File;

public class CheckFileDetails {

    public void checkFileDetails(String fileDir) {



        try {
            System.out.println("fileDir = " + fileDir);
            File file = new File(fileDir);

            if (file.exists()) {
                file.delete();
                System.out.println(file.getName() + " is deleted!");
            } else {
                System.out.println("Delete operation is failed.");
            }

        } catch (Exception e) {

            e.printStackTrace();

        }

    }
}