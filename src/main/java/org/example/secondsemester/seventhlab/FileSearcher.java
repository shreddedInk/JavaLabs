package org.example.secondsemester.seventhlab;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class FileSearcher {
    private final Pattern pattern;

    public FileSearcher(String regex) {
        this.pattern = Pattern.compile(regex);
    }

    private void recursiveSearch(File dir, List<String> foundFiles) {
        File[] files = dir.listFiles();
        if (files == null) return;

        for (File file : files) {
            if (file.isFile() && pattern.matcher(file.getName()).matches()) {
                foundFiles.add(file.getAbsolutePath());
            }

            if (file.isDirectory()) {
                recursiveSearch(file, foundFiles);
            }
        }
    }

    public List<String> searchFiles(File dir) {
        if (!dir.exists() || !dir.isDirectory()) {
            throw new IllegalArgumentException("Invalid directory: " + dir.getAbsolutePath());
        }

        List<String> foundFiles = new ArrayList<>();
        recursiveSearch(dir, foundFiles);
        return foundFiles;
    }
}