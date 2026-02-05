package Works;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

public class TextToByte {
    private TextToByte(){};

    public static byte[] readAllBytes(Path path) throws IOException{
        return Files.readAllBytes(path);
    }

    public static void writeAllBytes(Path path, byte[] data) throws IOException{
        Files.write(path, data);
    }
}
