import java.util.List;

public class Print implements PrintInterface {
    private Calcul calcul = new Calcul(this);
    public void print(String message) {
        System.out.println(message);
    }
}
