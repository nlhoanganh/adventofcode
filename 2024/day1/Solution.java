import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Solution {
    static Scanner scanner;

    static List<Long> leftList = new ArrayList<>();
    public static void main(String[] args) throws IOException {
        scanner = new Scanner(new File("./input.txt"));

        System.out.println(part2());
    
    }   

    public static long part1() {
        long result = 0;
        List<Long> rightList = new ArrayList<>();
        
        while(scanner.hasNext()) {
            leftList.add(scanner.nextLong());
            rightList.add(scanner.nextLong());
        }

        Collections.sort(leftList);
        Collections.sort(rightList);

        for(int i = 0; i < leftList.size(); i++) {
            long distance = rightList.get(i) - leftList.get(i);
            result += distance < 0 ? distance * -1 : distance;
        }

        return result;
    }

    public static long part2() {
        long result = 0;

        Map<Long, Long> rightMap = new HashMap<>();

        while(scanner.hasNext()) {
            leftList.add(scanner.nextLong());

            long nextRight = scanner.nextLong();
            rightMap.put(nextRight, rightMap.getOrDefault(nextRight, 0L) + 1);
        }

        for(int i = 0; i < leftList.size(); i++) {
            long leftValue = leftList.get(i);
            result += leftValue * rightMap.getOrDefault(leftValue, 0L);
        }
        
        return result;
    }
}