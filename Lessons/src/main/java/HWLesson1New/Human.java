package HWLesson1New;

public class Human implements Passable{

    private static final int DEFAULT_RUN_LIMIT = 42195;

    private final String name;
    private final int runLimit;
    private final int jumpLimit;

    public Human(String name, int runLimit,int jumpLimit) {
        this.name = name;
        this.runLimit = runLimit;
        this.jumpLimit = jumpLimit;
    }

    @Override
    public boolean jump(Wall wall) {
        if (jumpLimit>= wall.getLength()){
            return true;
        }
        return false;
    }
    public void info(){
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Human{" +
                "name='" + name + '\'' +
                ", runLimit=" + runLimit +
                ", jumpLimit=" + jumpLimit +
                '}';
    }

    @Override
    public boolean run(Road road) {
        if (runLimit>= road.getLength()){
            return true;
        }
        return false;
    }
}
