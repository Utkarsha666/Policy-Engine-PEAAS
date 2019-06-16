package Algorithm;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class SplitFileAlgo {

    private static String FILE_NAME = ""; // "TextFile.txt";
    private static byte PART_SIZE;
    int i = 2;
    private String D_FilesavePathUpload = "C:" + File.separator + "ServerFile";
    private String D_FilesavePathUploads = System.getenv("OPENSHIFT_DATA_DIR");//"D:" + File.separator + "ServerFile";

    public int splitRequest(String fname, String division) throws IOException {

        System.out.println("filepath--" + D_FilesavePathUpload);
        FILE_NAME = D_FilesavePathUpload + File.separator + fname;
        System.out.println("FILE_NAME = " + FILE_NAME);
        PART_SIZE = (byte) Integer.parseInt(division);
        File inputFile = new File(FILE_NAME);
        FileInputStream inputStream;
        String newFileName;
        FileOutputStream filePart;
        int fileSize = (int) inputFile.length();
        int size = fileSize;
        int nChunks = 0, read = 0, readLength = fileSize / PART_SIZE;
        byte[] byteChunkPart;
        System.out.println("size = " + size);
        double cost = size*0.0018;

        try {
            inputStream = new FileInputStream(new File(FILE_NAME));
            while (PART_SIZE > 0) {
                byteChunkPart = new byte[readLength];
                read = inputStream.read(byteChunkPart, 0, readLength);
                fileSize -= read;
                assert (read == byteChunkPart.length);
                nChunks++;
                newFileName = FILE_NAME + ".part"
                        + Integer.toString(nChunks - 1);
                filePart = new FileOutputStream(new File(newFileName));
                filePart.write(byteChunkPart);
                filePart.flush();
                filePart.close();
                byteChunkPart = null;
                filePart = null;
                PART_SIZE--;
            }
            inputStream.close();
        } catch (IOException exception) {
            exception.printStackTrace();
        }
        return i;
    }

    public class splitRequest {

        public splitRequest() {
        }
    }
}