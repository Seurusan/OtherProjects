package javaprojects.test_task;

import javaprojects.test_task.Classes.SortByName;
import javaprojects.test_task.Methods.FileWriters;

import java.io.File;
import java.io.FilenameFilter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.List;

public class Main {

    /**
     * 1. Имеется корневая папка. В этой папке могут находиться текстовые
     * файлы, а также другие папки. В других папках также могут находится
     * текстовые файлы и папки (уровень вложенности может оказаться любым).
     * Найти все текстовые файлы, отсортировать их по имени и склеить
     * содержимое в один текстовый файл.
     */

    public static void main(String[] args) throws IOException {

        //Main properties
        String directory = "C:\\Test";
        String resultFile = "C:\\Test\\result.txt";

        //Start filtering
        try {
            FilenameFilter filter = (File dir, String name) ->
                    (new File(dir.getAbsolutePath() + File.separator + name).isDirectory()) ||
                            name.toLowerCase().endsWith(".txt");

            //Sort and "merge" all .txt files
            List<File> contentFileList = FileWriters.getFileName(new File(directory), new ArrayList<>(), filter);
            contentFileList.sort(new SortByName());
            String resultText = FileWriters.fileWriter(contentFileList, StandardCharsets.UTF_8);
            FileWriters.fileWriter(resultFile, resultText);

        } catch (NullPointerException e) {
            System.out.println("Please choose existing folder");
        }
    }
}
