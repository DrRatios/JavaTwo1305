package HWLesson1New;

public class Human implements Passable{

    private static final int DEFAULT_RUN_LIMIT = 42195;

    private final String name;
    private final int runLimit;

    public Human(String name, int runLimit) {
        this.name = name;
        this.runLimit = runLimit;
    }

    @Override
    public boolean jump(Wall wall) {
        return false;
    }

    @Override
    public boolean run(Road road) {
        return false;
    }
}
