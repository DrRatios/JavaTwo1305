package Lesson_3;

import java.util.*;
import java.util.stream.Collectors;

public class App {
    public static void main(String[] args) {
        List<String> list = new LinkedList<>();
        list.add("a");
        list.add("test");
        list.add("String");

//        System.out.println(list);
//
//        System.out.println(list.get(1));
//
//        System.out.println(list.contains("a"));
//        System.out.println(list.contains("b"));

        Map<String,String> map = new HashMap<>();
        map.put("aaa","abc");
        map.put("bbb","bce");
        map.put("ccccc","bce");
        map.put("dasdasd","bce");
        map.put("edadas","bce");
        System.out.println(map);
        System.out.println(map.get("a"));
        System.out.println(map.get("c"));
        System.out.println(map.containsKey("c"));
        map.remove("b");
        System.out.println(map);

        for (String key : map.keySet()){
            System.out.println("Key = " + key + "value = " + map.get(key));
        }

        System.out.println("\n --------------Set----------------");
        Set<String> set = new HashSet<String>();
        set.add("aaa");
        set.add("bbb");
        System.out.println(set);

        System.out.println();
        System.out.println("---------------------Iterable----------------------");
        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()){
            System.out.println(iterator.next());
        }

        List<String> emptyList = new ArrayList<>();





        List<String> strings = new ArrayList<>(Arrays.asList("A","B","C","D","A"));
        System.out.println(strings.stream().distinct().skip(1).collect(Collectors.toList()));

//        Iterator<String> iter = strings.iterator();
//        while (iter.hasNext()) {
//            String s = iter.next();
//            if (s.equals("A")){
//                iter.remove();
//            }
//        }


    }

}
