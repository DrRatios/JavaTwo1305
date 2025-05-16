package Homework_3;

import java.util.*;

public class NumberDirectory {

    private HashMap<String, List<String>> phoneBook = new HashMap<>();

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        NumberDirectory that = (NumberDirectory) o;
        return Objects.equals(phoneBook, that.phoneBook);
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(phoneBook);
    }

    @Override
    public String toString() {
        return "NumberDirectory{" +
                "phoneBook=" + phoneBook +
                '}';
    }

    public void add(String serName, String phoneNumber) {
        if (phoneBook.containsKey(serName)) {
            phoneBook.get(serName).add(phoneNumber);
        } else {
            ArrayList<String> numbers = new ArrayList<>();
            numbers.add(phoneNumber);
            phoneBook.put(serName, numbers);
        }
    }

    void get(String serName) {
        List<String> numbersOfX = phoneBook.get(serName);
        System.out.println("Телефоны "+ serName + ": ");
        for (String ofX : numbersOfX) {
            System.out.println(ofX);
        }

    }


}
