
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Solution {
    
    public static void main(String[] agrs) throws IOException {
        List<String> reports = Files.readAllLines(Path.of("2024/day2/input_1.txt"));


        System.out.println(part1(reports));
        System.out.println(part2(reports));
    }

    public static int part2(List<String> reports) {
        int count = 0;

        for (String line : reports) {
            List<Integer> levels = Arrays.stream(Arrays.stream(line.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray()).boxed().collect(Collectors.toList());
            

            for (int i = 0; i < levels.size(); i++) {
                List<Integer> tempLevel = new ArrayList<>(levels);
                tempLevel.remove(i);
                if (isSafe(tempLevel.stream().mapToInt(Integer::intValue).toArray())) {
                    count++;
                    break;
                }
            }

     

        }

        return count;
    }

    public static int part1(List<String> reports) {
        int count = 0;

        for (String line : reports) {
            int[] levels = Arrays.stream(line.split(" "))
            .mapToInt(Integer::parseInt)
            .toArray();
            if (isSafe(levels)) {
                count++;
            }
        }

        return count;
    }

    public static boolean isSafe(int[] levels) {

        int lastLevel = levels[0];
        int currentLevel = levels[1];
        int lastGradient = (currentLevel - lastLevel);
        boolean isSafeLevel = Math.abs(lastGradient) <= 3 && lastGradient != 0;

        for (int i = 2; i  < levels.length; i++) {
            if (!isSafeLevel) {
            break;
            }

            lastLevel = currentLevel;
            currentLevel = levels[i];
            int currentGradient = (currentLevel - lastLevel);
            isSafeLevel = currentGradient * lastGradient > 0 && Math.abs(currentGradient) <= 3;
            lastGradient = currentGradient;
        }

        return isSafeLevel;
    }
}