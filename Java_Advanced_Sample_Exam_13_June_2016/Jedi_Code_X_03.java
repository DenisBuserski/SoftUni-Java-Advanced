package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Sample_Exam_13_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jedi_Code_X_03 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        StringBuilder jediText = new StringBuilder();
        int lines = Integer.parseInt(reader.readLine());

        while (lines > 0) {
            String line = reader.readLine();
            jediText.append(line);
            lines--;
        }

        String namePattern = reader.readLine();
        String messagePattern = reader.readLine();

        int[] indexes = Arrays.stream(reader.readLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();

        ArrayList<String> nameList = new ArrayList<>();
        ArrayList<String> messageList = new ArrayList<>();

        Matcher nameMatcher = Pattern.compile(namePattern + "([a-zA-Z]" + "{" +
                namePattern.length()+ "})" + ("(?![a-zA-Z])")).matcher(jediText);
        Matcher messageMatcher =
                Pattern.compile(messagePattern + "([a-zA-Z0-9]"  + "{" +
                        messagePattern.length() + "})" +"(?![a-zA-Z0-9])").matcher(jediText);

        addToList(nameMatcher, nameList);
        addToList(messageMatcher ,messageList);

        //queryPart
        queryJedies(indexes, messageList, nameList);
    }

    private static void addToList(Matcher matcher, ArrayList<String> list) {
        while (matcher.find()) {
            list.add(matcher.group(1));
        }
    }

    private static void queryJedies(int[] indexes, ArrayList<String> messages, ArrayList<String> names) {
        for (int i = 0; i < Math.min(indexes.length, names.size()); i++) {
            int index = indexes[i];
            if (index <= messages.size()) {
                System.out.println(names.get(i) + " - " + messages.get(index - 1));
            }
        }
    }
}
