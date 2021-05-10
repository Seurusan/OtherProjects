package javaprojects.test_task.Methods;

import java.io.*;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Objects;

public class FileWriters {
    public static List<File> getFileName(File directory, List<File> fileList, FilenameFilter filter) {
        //Implement filter for all files
        for (File file : Objects.requireNonNull(directory.listFiles(filter))) {
            if (file.isDirectory()) {
                getFileName(file, fileList, filter);
            } else {
                fileList.add(file);
            }
        }
        return fileList;
    }

    public static String fileWriter (List<File> contentFileList, Charset charset) {
        //StringBuilder for less memory usage
        final StringBuilder finalText = new StringBuilder();
        //Start forEach for all files
        contentFileList.forEach((file) -> {
            try {
                Files.lines(Paths.get(file.getAbsolutePath()), charset).
                        forEach((t) -> finalText.append(t).append("\r\n"));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        return finalText.toString();
    }

    public static void fileWriter(String fileName, String content) throws IOException {
        //Write into file with stream in UTF-8
        try (BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(fileName))) {
            out.write(content.getBytes(StandardCharsets.UTF_8));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
