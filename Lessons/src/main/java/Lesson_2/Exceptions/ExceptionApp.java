package Lesson_2.Exceptions;

public class ExceptionApp {

    public static void main(String[] args) throws Exception {
        int c = div(10, 1);
        System.out.println(c);
        // exc(10, 0);
        String num = "11d00";
        try {
            int i = Integer.parseInt(num);
        } catch (NumberFormatException nfe){
            System.out.println("Тут вовсе не число");
        }
    }

    static int div(int a, int b) throws Exception {
        try {
            return a / b;
        } catch (ArithmeticException | IllegalArgumentException e) {
            //handle
            System.out.println("Handle" + e.getMessage());
            e.printStackTrace(System.out);
            return 0;
        } catch (RuntimeException rte) {

        } catch (Exception e){

        }catch (Throwable tw){

        }
        return 0;
    }

    static void exc(int a, int b) throws Exception {
        throw new MyUncheckedException("Unimplemented");
    }

    public static void readFile(){
        try {
            //file.open
        } catch (Exception e){
            System.out.println();

        } finally {
            // file.close
        }
    }

}
