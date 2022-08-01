package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_27_August_2018;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Mission_03 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> messages = new LinkedList<>();
        Map<String, Integer> completedMissions = new HashMap<>();
        Map<String, Integer> failedMissions = new HashMap<>();

        String line;
        while (!"Decrypt".equals(line = scanner.nextLine())){
            messages.add(line);
        }

        Pattern missionPattern = Pattern.compile("M.*I.*S.*S.*I.*O.*N");

        for (String message : messages) {
            Matcher missionMatcher = missionPattern.matcher(message);

            if (missionMatcher.find()){
                StringBuilder missionName = new StringBuilder();
                Integer missionRating = 0;
                boolean failed = false;
                boolean completed = false;

                for (int i = 0; i < message.length(); i++) {
                    if (Character.isLowerCase(message.charAt(i))){
                        missionName.append(message.charAt(i));
                    }
                    else if (message.charAt(i) == 'C'){
                        completed = true;
                    }
                    else if (message.charAt(i) == 'X'){
                        failed = true;
                    } else if (Character.isDigit(message.charAt(i))){
                        StringBuilder num =  new StringBuilder();
                        num.append(message.charAt(i));
                        missionRating += Integer.parseInt(num.toString());
                    }
                }

                if (failed){
                    failedMissions.put(missionName.toString(), missionRating);
                }
                if (completed){
                    completedMissions.put(missionName.toString(), missionRating);
                }
            }
        }

        completedMissions.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(1)
                .forEach(z -> {
                    System.out.println(String.format("Completed mission %s with rating: %d",
                            z.getKey(), z.getValue()));
                });
        failedMissions.entrySet().stream()
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .limit(1)
                .forEach(z -> {
                    System.out.println(String.format("Failed Mission %s with rating: %d",
                            z.getKey(), z.getValue()));
                });
    }
}