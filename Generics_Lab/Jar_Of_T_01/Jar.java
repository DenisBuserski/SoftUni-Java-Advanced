package Generics_Lab.Generics_Lab_Jar_Of_T_01;

import java.util.ArrayDeque;

public class Jar<Type> {
    private ArrayDeque<Type> stack;

    public Jar() {
        this.stack = new ArrayDeque<>();
    }

    public void add(Type element) {
        this.stack.push(element);
    }

    public Type remove() {
        return this.stack.pop();
    }
    
}
