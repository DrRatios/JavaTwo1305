package Lesson_3;

import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeMap;

public class HumanApp {

    public static void main(String[] args) {
        Human h1 = new Human("Bob",12);
        Human h2 = new Human("Kevin",14);
        Human h3 = new Human("Steward",18);

        Map<Human,String> map = new TreeMap<>();
        map.put(h1,"Moscow");
        map.put(h2,"Berlin");
        map.put(h3,"Saratov");

        System.out.println(map);

        Human h4 = new Human("Steward",18);

        System.out.println(map.get(h4));


    }
}
