package org.example.secondsemester.seventhlab;

import org.junit.jupiter.api.Test;
import java.io.File;
import java.util.ArrayList;
import static org.junit.jupiter.api.Assertions.*;

class PackageOfAllFilesTest {

    @Test
    void testGetPackageOfAllFiles() {
        File tempDir = new File("testDir");
        tempDir.mkdir();

        File file1 = new File(tempDir, "file1.txt");
        File file2 = new File(tempDir, "file2.txt");
        File file3 = new File(tempDir, "file3.doc");

        try {
            file1.createNewFile();
            file2.createNewFile();
            file3.createNewFile();
        } catch (Exception e) {
            e.printStackTrace();
        }

        PackageOfAllFiles packageOfAllFiles = new PackageOfAllFiles();

        ArrayList<File> result = packageOfAllFiles.getPackageOfAllFiles(tempDir, ".txt");

        assertEquals(2, result.size());
        assertTrue(result.contains(new File(tempDir.getName() + "/file1.txt")));
        assertTrue(result.contains(new File(tempDir.getName() + "/file2.txt")));

        file1.delete();
        file2.delete();
        file3.delete();
        tempDir.delete();
    }

    @Test
    void testGetPackageOfAllFilesWithEmptyDirectory() {
        File tempDir = new File("emptyDir");
        tempDir.mkdir();

        PackageOfAllFiles packageOfAllFiles = new PackageOfAllFiles();

        ArrayList<File> result = packageOfAllFiles.getPackageOfAllFiles(tempDir, ".txt");

        assertTrue(result.isEmpty());
        tempDir.delete();
    }

    @Test
    void testGetPackageOfAllFilesWithNonExistentDirectory() {
        PackageOfAllFiles packageOfAllFiles = new PackageOfAllFiles();

        ArrayList<File> result = packageOfAllFiles.getPackageOfAllFiles(new File("nonExistentDir"), ".txt");

        assertTrue(result.isEmpty());
    }
}