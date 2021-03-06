import java.util.concurrent.locks.ReentrantLock;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        int totalOrders = 7;//количество выполненных заказов
        int executedOrders = 4;//максимальное количество исполняемых заказов
        int countWaiters = 3;
        int timeForWaiting = 2_000;
        int timeForExecute = 4_000;

        ReentrantLock lock = new ReentrantLock();
        Restaurant restaurant = new Restaurant(lock, totalOrders, executedOrders, timeForWaiting, timeForExecute, countWaiters);
        restaurant.start();

        for (int i = 0; i < totalOrders; i++) {
            Guest guest = new Guest(restaurant);
            guest.setName("Гость-" + i);
            guest.start();
        }


    }
}