package HWLesson1New;

public class Wall extends Obstacle{

    @Override
    ObstacleType getType() {
        return ObstacleType.WALL;
    }
}
