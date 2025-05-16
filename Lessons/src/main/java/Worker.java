public class Worker {
    private final AgedUser agedUser;
    private final String position;

    public Worker(String name, int age, String position) {
        this.agedUser = new AgedUser(name,age);
        this.position = position;
    }

    public String getName(){
        return agedUser.getName();
    }
}
