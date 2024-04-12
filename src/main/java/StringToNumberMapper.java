import java.util.List;

public class StringToNumberMapper {
    public List<Integer> map(List<String> numbers) {
        return numbers.stream().map(Integer::parseInt).toList();
    }
}
