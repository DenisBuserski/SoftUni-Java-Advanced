package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Exam_10_June_2018;

import java.util.ArrayDeque;
import java.util.Scanner;

public class Internships_01 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        byte problemsCount = Byte.parseByte(scanner.nextLine());
        byte candidatesCount = Byte.parseByte(scanner.nextLine());

        ArrayDeque<String> problemsStack = new ArrayDeque<>();
        ArrayDeque<String> candidatesQueue = new ArrayDeque<>();

        for (int i = 0; i < problemsCount; i++) {
            String problem = scanner.nextLine();
            problemsStack.push(problem);
        }

        for (int i = 0; i < candidatesCount; i++) {
            String[] candidateName = scanner.nextLine().split("\\s+");
            if (candidateName.length == 2){
                String firstName = candidateName[0];
                String lastName = candidateName[1];
                if (nameIsValid(firstName) && nameIsValid(lastName)){
                    candidatesQueue.offer(firstName + " " + lastName);
                }
            }
        }


        while (candidatesQueue.size() > 1){

            if (problemsStack.size() > 0){
                String currentProblemToSolve = problemsStack.peek();
                String currentCandidate = candidatesQueue.peek();
                Integer problemSum = 0;
                Integer candidateSum = 0;

                for (int i = 0; i < currentProblemToSolve.length(); i++) {
                    problemSum += (int)currentProblemToSolve.charAt(i);
                }
                for (int i = 0; i < currentCandidate.length(); i++) {
                    candidateSum += (int)currentCandidate.charAt(i);
                }
                if (candidateSum > problemSum){
                    problemsStack.pop();
                    candidatesQueue.poll();
                    candidatesQueue.offer(currentCandidate);
                    System.out.println(String.format("%s solved %s.", currentCandidate, currentProblemToSolve));
                } else {
                    problemsStack.pop();
                    problemsStack.addLast(currentProblemToSolve);
                    candidatesQueue.poll();
                    System.out.println(String.format("%s failed %s.", currentCandidate, currentProblemToSolve));
                }
            }

            else {
                int count = candidatesQueue.size();
                for (String candidate : candidatesQueue) {
                    if (count > 1) {
                        System.out.print(candidate + ", ");
                        candidatesQueue.poll();
                        count--;
                    } else {
                        System.out.println(candidate);
                        candidatesQueue.poll();
                    }
                }
            }
        }

        if (candidatesQueue.size() == 1){
            System.out.println(candidatesQueue.poll() + " gets the job!");
        }
    }

    private static boolean nameIsValid(String name){
        boolean isValid = true;
        if (Character.isLetter(name.charAt(0)) && !Character.isUpperCase(name.charAt(0))){
            isValid = false;
        }
        for (int i = 1; i < name.length(); i++) {
            if (Character.isLetter(name.charAt(i)) && !Character.isLowerCase(name.charAt(i))){
                isValid = false;
            }
        }
        return isValid;
    }
}
