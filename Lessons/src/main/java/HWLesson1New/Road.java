package HWLesson1New;

public class Road extends Obstacle{
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Road(int length) {
        this.length = length;
    }

    @Override
    ObstacleType getType() {
        return ObstacleType.ROAD;
    }
}
