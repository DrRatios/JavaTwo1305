package HWLesson1New;

public interface Passable extends Runable, Jumpable{

    default boolean pass(Obstacle obstacle){
        switch (obstacle.getType()){
            case ROAD -> {
                return run((Road)obstacle);
            }
            case WALL -> {
                return jump((Wall) obstacle);
            }
            default -> throw new IllegalArgumentException("Unknown obstacle");
            }
        }




//        if (obstacle instanceof Road) {
//            return run((Road)obstacle);
//        }
//        else if (obstacle instanceof Wall){
//            return jump((Wall)obstacle);
//        }
//        else throw new IllegalArgumentException("Unknown obstacle");
    }

