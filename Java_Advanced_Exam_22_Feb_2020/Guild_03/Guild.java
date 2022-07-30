package Java_Advanced_Exam_22_Feb_2020.Guild_03;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Guild {
    private String name;
    private int capacity;
    private List<Player> roster;

    public Guild(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
        this.roster = new ArrayList<>();
    }

    // Method addPlayer(Player player) - adds an entity to the roster if there is room for it
    public void addPlayer(Player player){
        if(this.roster.size() < capacity){
            this.roster.add(player);
        }
    }

    // Method removePlayer(String name) - removes a player by given name,
    // if such exists, and returns boolean
    public boolean removePlayer(String name){
        for (Player player : this.roster ) {
            if(player.getName().equals(name)){
                this.roster.remove(player);
                return true;
            }
        }
        return false;
    }

    // Method promotePlayer(String name) - promote (set his rank to "Member")
    // the first player with the given name.
    // If the player is already a "Member", do nothing.
    public void promotePlayer(String name){
        for (Player player : this.roster) {
            if (player.getName().equals(name)){
                player.setRank("Member");
                break;
            }
        }
    }

    // Method demotePlayer(String name)- demote (set his rank to "Trial")
    // the first player with the given name.
    // If the player is already a "Trial",  do nothing.
    public void demotePlayer(String name){
        for (Player player : this.roster) {
            if (player.getName().equals(name)){
                player.setRank("Trial");
                break;
            }
        }
    }


    // Method kickPlayersByClass(String clazz) -
    // removes all the players by the given class
    // and returns all removed players from that class as an array
    public Player[] kickPlayersByClass(String clazz){
        Player[] kickedOnes = this.roster.stream()
                .filter(player -> player.getClazz().equals(clazz))
                .toArray(Player[]::new);
        this.roster = this.roster.stream().filter(player -> !player.getClazz().equals(clazz))
                .collect(Collectors.toList());
        return kickedOnes;
    }

    // Method count() - returns the number of players
    public int count(){
        return this.roster.size();
    }

    // Method report() - returns a String in the following format:
    // "Players in the guild: {guildName}:
    // {Player1}
    // {Player2}
    public String report(){
        StringBuilder fill = new StringBuilder();
        fill.append(String.format("Players in the guild: %s:", this.name))
                .append(System.lineSeparator());
        for (Player player : this.roster) {
            fill.append(player.toString()).append(System.lineSeparator());
        }
        return fill.toString().trim();
    }
    
}
