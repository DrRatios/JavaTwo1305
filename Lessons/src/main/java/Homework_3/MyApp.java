package Homework_3;

import java.util.*;

public class MyApp {

    public static void main(String[] args) {


//        List<String> strings = new ArrayList<String>();
//        strings.add("Abel");
//        strings.add("Abel");
//        strings.add("Babel");
//        strings.add("Babel");
//        strings.add("Cruel");
//        strings.add("Duker");
//        strings.add("Even");
//        strings.add("Founder");
//        strings.add("Gigi");
//        strings.add("Gigi");
//
//        Set<String> set = new HashSet<>(strings);
//
//        System.out.println(set);
//        System.out.println(set.size());
//
//        Map<String, Integer> stringMap = new HashMap<>();
//        for (String word : strings) {
//            if (stringMap.containsKey(word)) {
//                stringMap.put(word, stringMap.get(word) + 1);
//            } else {
//                stringMap.put(word, 1);
//            }
//        }
//
//        System.out.println();
//
//        for (String word : stringMap.keySet()) {
//            System.out.println(word + " повторяется " + stringMap.get(word));
//        }

        NumberDirectory numberDirectory = new NumberDirectory();
        numberDirectory.add("Golubev","96017887-99");
        numberDirectory.add("Golubev","96017887-98");
        numberDirectory.add("Ivanov","96017887-97");
        numberDirectory.add("Ivanov","96017887-96");
        numberDirectory.add("Petrov","96017887-95");

        System.out.println(numberDirectory);


        numberDirectory.get("Golubev");
        numberDirectory.get("Ivanov");
        numberDirectory.get("Petrov");


    }
}


//        Iterator<String> iterator = set.iterator();
//        int count = 0;
//        while (iterator.hasNext()) count++;
//        System.out.println(count);


//        Iterator<String> iterator = linkedStrings.iterator();
//        int count = 0;
//        int index = 0;
//        while (iterator.hasNext()) {
//            if (iterator.next().equals(linkedStrings.get(index))) {
//                count++;
//                index++;
//                System.out.println(iterator.next());
//            }
//
//        }
//        System.out.println(count);



    







