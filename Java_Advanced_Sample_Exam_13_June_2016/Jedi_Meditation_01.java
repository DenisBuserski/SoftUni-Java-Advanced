package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Sample_Exam_13_June_2016;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Jedi_Meditation_01 {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int countOfInputLines = Integer.parseInt(bf.readLine());
        StringBuilder unorderedJedies = new StringBuilder();
        for (int i = 0; i < countOfInputLines; i++) {
            String line = bf.readLine();
            unorderedJedies.append(line);
        }
        // JEDI MATCHERS
        Matcher jediMasters = Pattern.compile("m\\d+").matcher(unorderedJedies);
        Matcher jediKnights = Pattern.compile("k\\d+").matcher(unorderedJedies);
        Matcher jediToshkosAndSlavs = Pattern.compile("(t\\d+)|(s\\d+)").matcher(unorderedJedies);
        Matcher jediPadawans = Pattern.compile("p\\d+").matcher(unorderedJedies);
        Matcher masterYoda = Pattern.compile("y\\d+").matcher(unorderedJedies);

        StringBuilder orderedJedies = new StringBuilder();
        if (masterYoda.find()) {
            while (jediMasters.find()) {
                orderedJedies.append(jediMasters.group()).append(" ");
            }
            while (jediKnights.find()) {
                orderedJedies.append(jediKnights.group()).append(" ");
            }
            while (jediToshkosAndSlavs.find()) {
                orderedJedies.append(jediToshkosAndSlavs.group()).append(" ");
            }
            while (jediPadawans.find()) {
                orderedJedies.append(jediPadawans.group()).append(" ");
            }
        } else {
            while (jediToshkosAndSlavs.find()) {
                orderedJedies.append(jediToshkosAndSlavs.group()).append(" ");
            }
            while (jediMasters.find()) {
                orderedJedies.append(jediMasters.group()).append(" ");
            }
            while (jediKnights.find()) {
                orderedJedies.append(jediKnights.group()).append(" ");
            }
            while (jediPadawans.find()) {
                orderedJedies.append(jediPadawans.group()).append(" ");
            }
        }
        System.out.println(orderedJedies);
    }
}