package org.example.secondsemester.seventhlab;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

class FileSearcherTest {

    @TempDir
    Path tempDir;


    @Test
    void testSearchFilesWithTxtExtension() throws IOException {
        File file1 = tempDir.resolve("test1.txt").toFile();
        File file2 = tempDir.resolve("test2.txt").toFile();
        File file3 = tempDir.resolve("test3.log").toFile();
        Files.createFile(file1.toPath());
        Files.createFile(file2.toPath());
        Files.createFile(file3.toPath());

        File subDir = tempDir.resolve("subdir").toFile();
        subDir.mkdir();
        File file4 = subDir.toPath().resolve("test4.txt").toFile();
        Files.createFile(file4.toPath());

        FileSearcher searcher = new FileSearcher(".*\\.txt");
        List<String> foundFiles = searcher.searchFiles(tempDir.toFile());

        assertEquals(3, foundFiles.size());
        assertTrue(foundFiles.contains(file1.getAbsolutePath()));
        assertTrue(foundFiles.contains(file2.getAbsolutePath()));
        assertTrue(foundFiles.contains(file4.getAbsolutePath()));
        assertFalse(foundFiles.contains(file3.getAbsolutePath()));
    }

    @Test
    void testSearchFilesInEmptyDirectory() {
        FileSearcher searcher = new FileSearcher(".*\\.txt");
        searcher.searchFiles(tempDir.toFile());

        assertEquals(0, Objects.requireNonNull(tempDir.toFile().listFiles()).length);
    }

    @Test
    void testSearchFilesWithInvalidDirectory() {
        File invalidDir = new File("invalid_directory");

        FileSearcher searcher = new FileSearcher(".*\\.txt");
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            searcher.searchFiles(invalidDir);
        });

        assertTrue(exception.getMessage().contains("Invalid directory"));
    }

    @Test
    void testSearchFilesWithNestedDirectories() throws IOException {
        File subDir1 = tempDir.resolve("subdir1").toFile();
        subDir1.mkdir();
        File file1 = subDir1.toPath().resolve("file1.txt").toFile();
        Files.createFile(file1.toPath());

        File subDir2 = subDir1.toPath().resolve("subdir2").toFile();
        subDir2.mkdir();
        File file2 = subDir2.toPath().resolve("file2.txt").toFile();
        Files.createFile(file2.toPath());

        FileSearcher searcher = new FileSearcher(".*\\.txt");
        searcher.searchFiles(tempDir.toFile());

        assertTrue(file1.exists());
        assertTrue(file2.exists());
    }

    @Test
    void testSearchFilesWithComplexRegex() throws IOException {
        File file1 = tempDir.resolve("test_file_123.txt").toFile();
        File file2 = tempDir.resolve("test_file_456.rar").toFile();
        File file3 = tempDir.resolve("file_789.txt").toFile();
        Files.createFile(file1.toPath());
        Files.createFile(file2.toPath());
        Files.createFile(file3.toPath());

        FileSearcher searcher = new FileSearcher("test_file_.*\\.txt");
        List<String> foundFiles = searcher.searchFiles(tempDir.toFile());

        assertEquals(1, foundFiles.size());
        assertTrue(foundFiles.contains(file1.getAbsolutePath()));
        assertFalse(foundFiles.contains(file2.getAbsolutePath()));
        assertFalse(foundFiles.contains(file3.getAbsolutePath()));
    }
}