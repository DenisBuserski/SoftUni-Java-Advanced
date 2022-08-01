package JAVA_DEVELOPMENT_SOFTUNI.Java_Development.Java_Advanced.Archive.Advanced_Java.Advanced_Java_Exams.Java_Advanced_Retake_Exam_27_August_2018;

import java.util.*;

public class Agents_04 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Double> missions = new LinkedHashMap<>();
        List<String> agents = new LinkedList<>();
        Map<String, Map<String, Double>> agentMissions = new LinkedHashMap<>();

        String line;
        while (!"registration".equals(line = scanner.nextLine())){
            if (line.charAt(0) == '#'){
                String[] missionInfo = line.split(":");
                String name = missionInfo[0];
                Double rating = Double.parseDouble(missionInfo[1]);
                missions.put(name, rating);
            } else if (line.charAt(line.length() - 3) == '0'){
                agents.add(line);
            }
        }

        while (!"operate".equals(line = scanner.nextLine())){
            String[] data = line.split("->");
            switch (data[0]){
                case "assign" :
                    String agent = data[1];
                    String mission = data[2];
                    if (missions.containsKey(mission) && agents.contains(agent)){
                        agentMissions.putIfAbsent(agent, new LinkedHashMap<>());
                        if (!agentMissions.get(agent).containsKey(mission)){
                            agentMissions.get(agent).put(mission, missions.get(mission));
                        }
                    }
                    break;
                case "abort" :
                    String removeMission = data[1];
                    for (Map.Entry<String, Map<String, Double>> entry : agentMissions.entrySet()) {
                        if (entry.getValue().containsKey(removeMission)){
                            entry.getValue().remove(removeMission);
                        }
                    }
                    break;
                case "change" :
                    String agent1 = data[1];
                    String agent2 = data[2];
                    Map<String, Double> agent1Missions = new LinkedHashMap<>(agentMissions.get(agent1));
                    Map<String, Double> agent2Missions = new LinkedHashMap<>(agentMissions.get(agent2));
                    agentMissions.get(agent1).clear();
                    agentMissions.get(agent2).clear();
                    agentMissions.get(agent2).putAll(agent1Missions);
                    agentMissions.get(agent1).putAll(agent2Missions);
                    break;
            }
        }

        agentMissions.entrySet().stream()
                .filter(x -> x.getValue().size() != 0)
                .sorted((a, b) -> {
                    Double agent1Rating = a.getValue().values().stream().reduce((c, d) -> c + d).get();
                    Double agent2Rating = b.getValue().values().stream().reduce((c, d) -> c + d).get();

                    return Double.compare(agent2Rating, agent1Rating);
                }).forEach(z -> {
            Double agentRating = z.getValue().values().stream().reduce((c, d) -> c + d).get();

            System.out.println(String.format("Agent: %s - Total Rating: %.2f", z.getKey(), agentRating));
            z.getValue().entrySet().stream().sorted((n, b) -> b.getValue().compareTo(n.getValue())).forEach( w -> {
                System.out.println(String.format(" - %s -> %.2f", w.getKey(), w.getValue()));
            });
        });
    }
}