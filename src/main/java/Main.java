import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        Calcul calcul = new Calcul();
        List<Integer> numbers = null;
        try {
            numbers = fileReader.read(args[0]);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        calcul.process(numbers, args[1]);
    }
}
