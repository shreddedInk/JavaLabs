package org.example.secondsemester.seventhlab;

import java.io.File;
import java.util.ArrayList;
import java.util.Objects;

public class PackageOfAllFiles {
    public ArrayList<File> getPackageOfAllFiles(File directory, String extension) {
        ArrayList<File> files = new ArrayList<>();
        if (directory.isDirectory()) {
            for (String str : Objects.requireNonNull(directory.list())) {
                if (str.endsWith(extension)) files.add(new File(directory.getName() + '/' + str));
            }
        }
        return files;
    }
}
