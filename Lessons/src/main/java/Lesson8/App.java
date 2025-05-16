package Lesson8;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class App {
    public static void main(String[] args) {
        /**
         * Terminal
         * collect
         * reduce
         * forEach
         * findFirst
         * anyMatch
         * allMatch
         */

        /** non-Term
         * map
         * flatMap
         * filter
         * peek
         * skip
         * limit
         */

//        Stream<Integer> stream; //Бесконечный
//        stream.filter(i -> i < 0).skip(2).findFirst();

        List<String> words = new ArrayList<>();
        words.add("asdasdasdasd");
        words.add("asdasdasdasd");
        words.add("asd");
        words.add("asdasdaasdsdasd");
        words.add("a");
        words.add("b");
        words.add("c");
        words.add("ab");
//        System.out.println(words);

        //Получить новый клиентовый список со словами длинее трёх букв
        List<String> newList = words.stream().filter(w -> w.length() > 3).toList();
        System.out.println(newList);

        //получить список длинн слов
        List<Integer> wLengths = words.stream().map(String::length).sorted().toList();
        System.out.println(wLengths);

        //Посчитать Map -> слово::длина


        System.out.println(words.stream()
                .collect(Collectors.toMap(w -> w, w -> 1, Integer::sum))
                .entrySet().stream()
                .filter(e ->e.getValue()==1)
                .map(Map.Entry::getKey)
                .collect(Collectors.joining(", "))

        );


    }
}
