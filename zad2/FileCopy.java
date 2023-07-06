package zad2;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

//Implementacja z wykorzystaniem FileInputStream i FileOutputStream
public class FileCopyIO {
    public static void copyFileUsingStreams(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileInputStream inputStream = new FileInputStream(sourcePath);
             FileOutputStream outputStream = new FileOutputStream(destinationPath)) {
            byte[] buffer = new byte[1024];
            int bytesRead;
            while ((bytesRead = inputStream.read(buffer)) != -1) {
                outputStream.write(buffer, 0, bytesRead);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas kopiowania: " + duration + " ms");
    }
}

//Implementacja z wykorzystaniem FileReader i FileWriter
public class FileCopy {
    public static void copyFileUsingReaders(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        try (FileReader reader = new FileReader(sourcePath);
             FileWriter writer = new FileWriter(destinationPath)) {
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas kopiowania: " + duration + " ms");
    }
}

//Implementacja z wykorzystaniem BufferedReader i BufferedWriter
public class FileCopyBuffered {
    public static void copyFileUsingBuffers(String sourcePath, String destinationPath) throws IOException {
        long startTime = System.currentTimeMillis();

        try (BufferedReader reader = new BufferedReader(new FileReader(sourcePath));
             BufferedWriter writer = new BufferedWriter(new FileWriter(destinationPath))) {
            char[] buffer = new char[1024];
            int charsRead;
            while ((charsRead = reader.read(buffer)) != -1) {
                writer.write(buffer, 0, charsRead);
            }
        }

        long endTime = System.currentTimeMillis();
        long duration = endTime - startTime;
        System.out.println("Czas kopiowania: " + duration + " ms");
    }
}