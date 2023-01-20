import java.io.*;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        StringBuilder sb = new StringBuilder();
        List<File> dir = Arrays.asList(
                new File("/Users/vi/Desktop/Games"),
                new File("/Users/vi/Desktop/Games/src"),
                new File("/Users/vi/Desktop/Games/res"),
                new File("/Users/vi/Desktop/Games/savegames"),
                new File("/Users/vi/Desktop/Games/temp"),
                new File("/Users/vi/Desktop/Games/src/main"),
                new File("/Users/vi/Desktop/Games/src/test"),
                new File("/Users/vi/Desktop/Games/res/drawables"),
                new File("/Users/vi/Desktop/Games/res/vectors"),
                new File("/Users/vi/Desktop/Games/res/icons"));

        List<File> files = Arrays.asList(
                new File("/Users/vi/Desktop/Games/src/main/Main.java"),
                new File("/Users/vi/Desktop/Games/src/main/Utils.java"),
                new File("/Users/vi/Desktop/Games/temp/temp.txt"));


        dir.stream().forEach(dirеctory -> {
            if (dirеctory.mkdir()) sb.append("Директорий " + dirеctory + " создан\n");
            else sb.append("Директорий " + dirеctory + " не создан\n");
        });

        files.stream().forEach(file -> {
            try {
                if (file.createNewFile()) sb.append("Файл " + file + " создан\n");
                else sb.append("Файл " + file + " не создан\n");
            } catch (IOException e) {
                System.out.println(e.getMessage());
            }
        });

        try (FileWriter log = new FileWriter("/Users/vi/Desktop/Games/temp/temp.txt")) {
            log.write(sb.toString());
            log.flush();
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }


        try (BufferedReader read = new BufferedReader
                (new FileReader("/Users/vi/Desktop/Games/temp/temp.txt"))) {
            while (read.readLine() != null)
                System.out.println(read.readLine());
        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
    }
}