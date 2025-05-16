package HomeworkLesson_1;

public class Cat {
    private String name;
    private int jumpPosibility;
    private int runPosibility;

    public Cat(String name, int jumpPosibility, int runPosibility) {
        this.name = name;
        this.jumpPosibility = jumpPosibility;
        this.runPosibility = runPosibility;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getJumpPosibility() {
        return jumpPosibility;
    }

    public void setJumpPosibility(int jumpPosibility) {
        this.jumpPosibility = jumpPosibility;
    }

    public int getRunPosibility() {
        return runPosibility;
    }

    public void setRunPosibility(int runPosibility) {
        this.runPosibility = runPosibility;
    }

    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", jumpPosibility=" + jumpPosibility +
                ", runPosibility=" + runPosibility +
                '}';
    }

    public void info(){
        System.out.println(toString());
    }


    public void run(RunRoad road)  {
        if (runPosibility > road.getLength()) {
            System.out.println(this.name +" Cat Run through RunRoad");
        } else {
            System.out.println(this.name +" Cat exhausted, can't run trough this Road");

        }

    }

    public void jump (Wall wall){
        if (jumpPosibility > wall.getHigh()) {
            System.out.println(this.name +" Cat jump through Wall");
        }
        else {
            System.out.println(this.name +" Cat is small and can't jump trough this Wall");


        }

    }
}