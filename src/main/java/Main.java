import java.io.FileNotFoundException;
import java.util.List;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        FileReader fileReader = new FileReader();
        PrintInterface printInterface = new Print();
        Calcul calcul = new Calcul(printInterface);

        List<Integer> numbers = null;

        try {
            numbers = fileReader.read(args[0]);
        } catch (FileNotFoundException e) {
            throw new FileNotFoundException();
        }
        calcul.process(numbers, args[1]);
    }
}
