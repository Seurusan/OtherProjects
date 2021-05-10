package javaprojects.test_task.Classes;

import java.io.File;
import java.io.Serial;
import java.io.Serializable;
import java.util.Comparator;

public class SortByName implements Comparator<File>, Serializable {

    //Define the serial number of the class
    @Serial
    private static final long serialVersionUID = 1L;

    //"Modify" method compare for our task
    @Override
    public int compare(File first, File second) {
        return first.getName().compareTo(second.getName());
    }
}
