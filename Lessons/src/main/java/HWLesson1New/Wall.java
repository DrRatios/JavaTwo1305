package HWLesson1New;

public class Wall extends Obstacle{
    private int length;

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public Wall(int length) {
        this.length = length;
    }

    @Override
    ObstacleType getType() {
        return ObstacleType.WALL;
    }
}
