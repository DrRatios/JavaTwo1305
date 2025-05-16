package HWLesson1New;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DemoApp {
    public static void main(String[] args) {
        Human[] human = new Human[]{new Human("Garold", 100, 100),
                new Human("Ger", 50, 50),
                new Human("Gur", 10, 50),
                new Human("Far", 20, 50),
                new Human("Fur", 3000, 50),
                new Human("Kit", 5, 50)};
        Road[] o = new Road[]{new Road(1000),
                new Road(500),
                new Road(100),
                new Road(1),};

        for (Human human1 : human) {
            human1.info();
            for (Road road : o) {
                System.out.println(road.getType() + " length = " + road.getLength() + " " + human1.pass(road));

            }
        }
    }
}
