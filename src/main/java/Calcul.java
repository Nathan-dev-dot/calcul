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
        AtomicInteger start = new AtomicInteger();

        numbers.forEach((number) -> {
            total.updateAndGet(v -> v + number);
            start.updateAndGet(v -> v + 1);
            convert(number, total, start, "+", numbers.size() );
        });

        return total.get();
    }

    private void convert(Integer number, AtomicReference total, AtomicInteger start, String args, Integer listSize){
        if(start.get() != 1){
            print.print(args + number.toString() + " (=" + total + ")");
        } else{
            print.print(number.toString());
        }
        if (start.get() ==  listSize){
            print.print("_______");
        }
    }

    protected Integer time(List<Integer> numbers) {
        AtomicReference<Integer> total = new AtomicReference<>(1);
        AtomicInteger start = new AtomicInteger();
        numbers.forEach((number) -> {
            total.updateAndGet(v -> v * number);
            start.addAndGet(1);
            convert(number, total, start, "*", numbers.size());
        });

        return total.get();
    }

    public void process(List<Integer> numbers, String arg) throws ArithmeticException {
        switch (arg){
            case "+":
                print.print("total = " + this.add(numbers).toString() + " (addition)");
                break;
            case "*":
                print.print("total = " + this.time(numbers).toString() + " (multiplication)" );
                break;
            default:
                throw new ArithmeticException("Not permitted");
        }
    }
}
