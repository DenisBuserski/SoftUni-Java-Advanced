package Defining_Classes_Exercises.Family_Tree_08;

import java.util.*;

public class Main {
    public static OriginPerson originPerson;
    public static List<String[]> unsortedInfoList = new ArrayList<>();
    public static Map<String, String> completePersonMap = new LinkedHashMap<>();

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String origin = scanner.nextLine();

        String inputInfo;
        while (!"End".equals(inputInfo = scanner.nextLine())) {
            if (inputInfo.matches(".*\\s+-\\s+.*")) {
                String[] divided = inputInfo.split("\\s+-\\s+");
                unsortedInfoList.add(new String[]{divided[0], divided[1]});
            } else {
                String[] temp = inputInfo.split("\\s+");
                String name = temp[0] + " " + temp[1];

                if (name.equals(origin) || temp[2].equals(origin)) {
                    originPerson = new OriginPerson(name, temp[2]);
                } else {
                    completePersonMap.put(name, temp[2]);
                }
            }
        }
        
        sortFamilyTies();
        originPerson.printFamilyTree();
    }

    public static void sortFamilyTies() {
        for (String[] X : unsortedInfoList) {
            if (originPerson.isParent(X)) {
                for (Map.Entry<String, String> Y : completePersonMap.entrySet()) {
                    if (Y.getKey().equals(X[1]) || Y.getValue().equals(X[1])) {
                        originPerson.addChild(Y);
                        // completePersonMap.remove(Y.getKey()); -> if faster runtime required
                        break;
                    }
                }
            } else if (originPerson.isChild(X)) {
                for (Map.Entry<String, String> Y : completePersonMap.entrySet()) {
                    if (Y.getKey().equals(X[0]) || Y.getValue().equals(X[0])) {
                        originPerson.addParent(Y);
                        // completePersonMap.remove(Y.getKey()); -> if faster runtime required
                        break;
                    }
                }
            }
        }
    }
    
}
