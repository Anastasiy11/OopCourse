import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        try (Scanner scanner = new Scanner(new FileInputStream("Numbers"))) {
            ArrayList<Integer> numbers = new ArrayList<>();

            while (scanner.hasNextLine()) {
                numbers.add(scanner.nextInt());
            }

            for (int i = numbers.size() - 1; i > 0; i--) {
                if (numbers.get(i) % 2 == 0) {
                    numbers.remove(i);
                }
            }

            System.out.println("Список целых чисел: " + numbers);

            ArrayList<Integer> numbersNoDuplicates = new ArrayList<>();

            for (Integer number : numbers) {
                if (!numbersNoDuplicates.contains(number)) {
                    numbersNoDuplicates.add(number);
                }
            }

            System.out.println("Список целых чисел, без повторений: " + numbersNoDuplicates);
        }
    }
}