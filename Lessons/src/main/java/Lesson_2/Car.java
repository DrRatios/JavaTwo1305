package Lesson_2;

public class Car {

    private final String COLOR;
    private final String VIN;
    private final int YEAR;
    private final int POWER;


    private Car (Builder builder){
        this.COLOR = builder.color;
        this.VIN = builder.vin;
        this.YEAR = builder.year;
        this.POWER = builder.power;
    }

    @Override
    public String toString() {
        return "Car{" +
                "COLOR='" + COLOR + '\'' +
                ", VIN='" + VIN + '\'' +
                ", YEAR=" + YEAR +
                ", POWER=" + POWER +
                '}';
    }

    public static class Builder {
        private String color;
        private String vin;
        private int year;
        private int power;

        public Builder setColor(String color) {
            this.color = color;
            return this;
        }

        public Builder setVin(String vin) {
            this.vin = vin;
            return this;
        }

        public Builder setYear(int year) {
            this.year = year;
            return this;
        }

        public Builder setPower(int power) {
            this.power = power;
            return this;
        }

        public Car build(){
            return new Car (this);
        }
    }




}
