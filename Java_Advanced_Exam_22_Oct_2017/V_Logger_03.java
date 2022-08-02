package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_22_Oct_2017;

import java.util.*;

public class V_Logger_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String line;

        Map<String, Set<String>> theVLogger = new HashMap<>();
        Map<String, Set<String>> following = new HashMap<>();

        while (!"Statistics".equals(line = scanner.nextLine())) {
            String[] data = line.split(" ");

            switch (data[1]) {
                case "joined":
                    theVLogger.putIfAbsent(data[0], new TreeSet<>());
                    following.putIfAbsent(data[0], new TreeSet<>());
                    break;
                case "followed":
                    if (theVLogger.containsKey(data[0]) && theVLogger.containsKey(data[2])) {
                        if (!data[0].equals(data[2])) {
                            theVLogger.get(data[2]).add(data[0]);
                            following.get(data[0]).add(data[2]);
                        }
                    }
                    break;
            }
        }

        final int[] count = new int[]{1};
        System.out.printf("The V-Logger has a total of %d vloggers in its logs.%n", theVLogger.keySet().size());

        theVLogger
                .entrySet()
                .stream()
                .sorted((a, b) -> {
                    int result = Integer.compare(b.getValue().size(), a.getValue().size());

                    if (result == 0) {
                        result = Integer.compare(following.get(a.getKey()).size(), following.get(b.getKey()).size());
                    }
                    return result;
                })
                .forEach(x -> {
                    if (count[0] == 1) {
                        System.out.printf("%d. %s : %d followers, %d following%n", count[0]++, x.getKey(), x.getValue().size(), following.get(x.getKey()).size());
                        x.getValue().forEach(y -> System.out.printf("*  %s%n", y));
                    } else {
                        System.out.printf("%d. %s : %d followers, %d following%n", count[0]++, x.getKey(), x.getValue().size(), following.get(x.getKey()).size());
                    }
                });
    }
}




