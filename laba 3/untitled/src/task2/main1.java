import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

class main1 {
    public static void main(String[] args) {
        List<Optional<Integer>> optionalList = List.of(
                Optional.of(10),
                Optional.empty(),
                Optional.of(25),
                Optional.empty(),
                Optional.of(30)
        );

        // Виклик методу для перетворення
        List<Integer> integers = convertOptionalsToList(optionalList);

        // Виводимо результат
        System.out.println(integers); // [10, 25, 30]
    }

    public static List<Integer> convertOptionalsToList(List<Optional<Integer>> optionals) {
        return optionals.stream()
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());
    }
}
