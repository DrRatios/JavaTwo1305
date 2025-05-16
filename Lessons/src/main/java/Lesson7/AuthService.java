package Lesson7;
/**
 * Сервис авторизации
 */
public interface AuthService {

    void start();

    void stop();

    /**
     * Получить никнейм
     */
    String getNickByLoginAdPass(String login,String pass);


}
