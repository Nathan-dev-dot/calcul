import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicReference;

public class Calcul {
    PrintInterface print;

    public Calcul(PrintInterface print) {
        this.print = print;
    }

    protected Integer add(List<Integer> numbers) {
        AtomicReference<Integer> total = new AtomicReference<>(0);
        numbers.forEach((number) -> {
            total.updateAndGet(v -> v + number);
        });
        return total.get();
    }

    protected Integer time(List<Integer> numbers) {
        AtomicReference<Integer> total = new AtomicReference<>(1);
        numbers.forEach((number) -> {
            total.set(total.get() * number);
        });
        return total.get();
    }

    public void process(List<Integer> numbers, String arg) throws ArithmeticException {
        switch (arg){
            case "+":
                print.print("total = " + this.add(numbers).toString() + "(addition)");
                break;
            case "*":
                print.print("total = " + this.add(numbers).toString() + "(multiplication)");
                break;
            default:
                throw new ArithmeticException("Not permitted");
        }
    }
}
