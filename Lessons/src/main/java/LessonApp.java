public class LessonApp {
    public static void main(String[] args) {
        User user = new AgedUser("name", 15);
        User user3 = new AgedUser("name", 15);
        User user2 = user;
        if (user instanceof AgedUser) {
            AgedUser agedUser = (AgedUser) user;
            agedUser.getAge();
        }

        System.out.println(user == user3);
        System.out.println(user.equals(user3));

        System.out.println(user == user2);
        System.out.println(user.equals(user2));

        String s = "abc";
        String s2 = "abc";
        String s3 = new String("abc");
        System.out.println(s == s2);
        System.out.println(s == s3);
        System.out.println(s.equals(s3));
        System.out.println("_______________________");


        AgedUser aU = new AgedUser("u1", 18);
        Person person = new Person("u1");

        Workable workable = new AgedUser("u1", 18);
        Workable workable1 = new Person("u1");

        Workable[] workables = new Workable[]{workable, workable1};
        for (Workable w : workables) {
            w.work();
            w.rest();
        }

        Eatable eatable = aU;
        Eatable eatable1 = person;

    }


}
