package Defining_Classes_Exercises.Family_Tree_08;

import java.util.LinkedHashMap;
import java.util.Map;

public class OriginPerson {
    String name;
    String birthday;
    LinkedHashMap<String, String> childrenMap = new LinkedHashMap<>();
    LinkedHashMap<String, String> parentMap = new LinkedHashMap<>();

    public OriginPerson(String name, String birthday) {
        this.name = name;
        this.birthday = birthday;
    }

    public void addChild(Map.Entry<String, String> child) {
        this.childrenMap.put(child.getKey(), child.getValue());
    }

    public void addParent(Map.Entry<String, String> parent) {
        this.parentMap.put(parent.getKey(), parent.getValue());
    }

    public boolean isParent(String[] info) {
        return this.name.equals(info[0]) || this.birthday.equals(info[0]);
    }

    public boolean isChild(String[] info) {
        return this.name.equals(info[1]) || this.birthday.equals(info[1]);
    }

    public void printFamilyTree() {
        StringBuilder parents = new StringBuilder();
        this.parentMap.forEach((name, date) -> parents.append(name).append(" ")
                .append(date).append(System.lineSeparator()));
        StringBuilder children = new StringBuilder();
        this.childrenMap.forEach((name, date) -> children.append(name).append(" ")
                .append(date).append(System.lineSeparator()));
        System.out.printf("%s %s%nParents:%n%sChildren:%n%s", this.name, this.birthday, parents, children);
    }
    
}
