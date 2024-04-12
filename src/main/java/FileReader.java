import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class FileReader {
    private StringToNumberMapper stringToNumberMapper = new StringToNumberMapper();

    public List<Integer> read(String path) throws FileNotFoundException {
        List<String> records = new ArrayList<>();
        try(Scanner scanner = new Scanner(new File(path))) {
            while (scanner.hasNextLine()) {
                records.add(getRecordFromLine(scanner.nextLine()).get(0));
            }
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("File not found");
        }
        return stringToNumberMapper.map(records);
    }

    private List<String> getRecordFromLine(String line) {
        List<String> values = new ArrayList<String>();
        try (Scanner rowScanner = new Scanner(line)) {
            rowScanner.useDelimiter(",");
            while (rowScanner.hasNext()) {
                values.add(rowScanner.next());
            }
        }
        return values;
    }
}
