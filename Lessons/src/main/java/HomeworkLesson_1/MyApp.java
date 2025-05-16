package HomeworkLesson_1;

public class MyApp {

    public static void main(String[] args) throws Exception {

        System.out.println("\n Внимание, проведём челлендж между расами, КЕКВ, вот наши представители\n");

        Cat[] cats = new Cat[4];
        cats[0] = new Cat("Murs", 11, 1100);
        cats[1] = new Cat("Murd", 5, 60);
        cats[2] = new Cat("Murf", 7, 700);
        cats[3] = new Cat("Murg", 18, 2001);
        for (Cat cat : cats) {
            cat.info();
        }

        Human[] humans = new Human[4];
        humans[0] = new Human("Human1", 8, 4000);
        humans[1] = new Human("Human2", 2, 500);
        humans[2] = new Human("Human3", 3, 700);
        humans[3] = new Human("Human4", 20, 10000);

        for (Human human : humans) {
            human.info();
        }

        Robot[] robots = new Robot[4];
        robots[0] = new Robot("Robot1", 20, 5000);
        robots[1] = new Robot("Robot2", 40, 6000);
        robots[2] = new Robot("Robot3", 80, 7000);
        robots[3] = new Robot("Robot4", 100, 8000);

        for (Robot robot : robots) {
            robot.info();
        }

        RunRoad[] roads = new RunRoad[4];
        roads[0] = new RunRoad(500);
        roads[1] = new RunRoad(2000);
        roads[2] = new RunRoad(10);
        roads[3] = new RunRoad(600);

        Wall[] walls = new Wall[4];
        walls[0] = new Wall(5);
        walls[1] = new Wall(20);
        walls[2] = new Wall(30);
        walls[3] = new Wall(11);

        System.out.println("\nНашим участникам предстоит преодолеть препятствия в виде стены " +
                "и беговой дорожки, смогут ли они пройти их? Скоро увидим, начинаем челлендж\n");

        for (Cat cat : cats) {
            for (RunRoad road : roads) {
                if (cat.getRunPosibility() > road.length){
                    cat.run(road);
                }
                else {
                    System.out.println(cat.getName() +" Cat exhausted, can't run trough " +
                            "this Road and except from this challenge");
                    break;
                }
            }

        }

        for (Cat cat : cats) {
            for (Wall wall : walls) {
                cat.jump(wall);
            }

        }

        System.out.println("Итак, наши участники прошли испытания (или нет), такие дела, пока)");


    }


}
