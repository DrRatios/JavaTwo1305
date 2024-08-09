package Lesson7;

import java.util.*;

public class App {
    public static void main(String[] args) {
        App app = new App();
        List<String> linkedList = new LinkedList<>();
        List<String> arrayList = new ArrayList<>();
        //fill

        //count
        Map<String,Integer> map = app.wordCount(arrayList);
        Map<String,Integer> map2 = app.wordCount(linkedList);

        List<String> list = app.getList("name", new HashMap<>());

        for (String string : list) {
            System.out.println(string);
        }
        list.forEach(System.out::println);
    }

    public Map <String,Integer> wordCount(Collection<String> list){
        Map <String,Integer>hm = new TreeMap<>();
        //logic
        for (String s : list) {
            hm.put(s,hm.getOrDefault(s,0)+1);
        }
        return hm;
    }
    public List<String> getList(String name, Map<String,List<String>> map){
        return map.getOrDefault(name, Collections.emptyList());
    }
}