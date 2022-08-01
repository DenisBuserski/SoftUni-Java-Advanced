package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_27_August_2018;

import java.util.*;
import java.util.stream.Collectors;

public class Agency_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        ArrayDeque<String> ids = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(ids::push);
        ArrayDeque<String> agents = new ArrayDeque<>();
        Arrays.stream(scanner.nextLine().split("\\s+")).forEach(agents::offer);


        String line;
        while (!"stop".equals(line = scanner.nextLine())){
            String command = line.split(" ")[0];

            switch (command){
                case "add-ID" :
                    String Id = line.split(" ")[1];
                    ids.push(Id);
                    break;
                case "add-agent" :
                    String agent = line.split(" ")[1];
                    agents.offer(agent);
                    break;
                case "remove-ID" :
                    String removedId = ids.pop();
                    System.out.println(String.format("%s has been removed.", removedId));
                    break;
                case "remove-agent" :
                    String removedAgent = agents.pollLast();
                    System.out.println(String.format("%s has left the queue.", removedAgent));
                    break;
                case "sort-ID" :
                    ids = ids.stream()
                            .sorted(Comparator.reverseOrder())
                            .collect(Collectors.toCollection(ArrayDeque::new));
                    break;
            }
        }

        while (!(ids.isEmpty() || agents.isEmpty())){
            String currentAgent = agents.poll();
            String currentId = ids.pop();
            System.out.println(String.format("%s takes ID number: %s", currentAgent, currentId));
        }
        if (ids.size() > 0){
            System.out.println("No more agents left.");
            while (!ids.isEmpty()){
                String leftId = ids.pop();
                System.out.println(String.format("ID number: %s", leftId));
            }
        }
        if (agents.size() > 0){
            while (!agents.isEmpty()){
                String leftAgent = agents.poll();
                System.out.println(String.format("%s does not have an ID.", leftAgent));
            }
        }

    }
}



