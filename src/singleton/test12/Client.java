package singleton.test12;

public class Client extends Thread {
    private String name;
    private static  int base = 0;
    private int price = 50;

    public Client() {
        base++;
        price += base;
        name = "Client-" + base;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 3; i++) {
            new Client().start();
        }
    }

    @Override
    public void run() {
        UpdatableSingleton us = UpdatableSingleton.getInstance();
        try {
            us.updateProduct(name, "Book", price);
        } catch(InterruptedException e) {
            System.out.println("InterruptedException " + e.getMessage());
        }
    }

}
