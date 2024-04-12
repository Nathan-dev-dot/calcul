import org.junit.jupiter.api.Test;

import java.io.FileNotFoundException;

import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class FileReaderTest {
    @Test
    public void ShouldThrowAnErrorBecauseFileNotFound() {
        FileReader fileReader = new FileReader();
        String[] args = new String[1];
        args[0] = "fileNotFound.txt";

        FileNotFoundException thrown = assertThrows(
                FileNotFoundException.class,
                () -> fileReader.read(args[0]),
                "Expected read() to throw, but it didn't"
        );

        assertTrue(thrown.getClass() == FileNotFoundException.class);
    }
}
