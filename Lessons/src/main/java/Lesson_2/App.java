package Lesson_2;

import java.util.Arrays;


public class App {

    public static void main(String[] args) {
        //Month[] months = new Month[]{Month.JAN, Month.FEB, Month.MAR, Month.APR, Month.MAY};
        for (Month month : Month.values()) {
            System.out.println(month.ordinal() + " " + month + " " + month.getFullName() + " " + month.getNumber() + " " + month.isSpring());

        }


        Month month = Month.JAN;
        Month month1 = Month.JAN;


        // if (month == month1) при этом equals не нужен;

        switch (month) {
            case JAN:
            case FEB: {
                System.out.println("Winter");

            }
            case MAR:
            case APR:
            case MAY:{
                System.out.println("Spring");
                break;
            }

        }



    }
}
