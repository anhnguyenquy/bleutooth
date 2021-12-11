package frc.robot;

public class CustomFunctions {

    public static void setTimeout(Runnable runnable, int delay) {
        new Thread(() -> {
            try {
                Thread.sleep(delay);
                runnable.run();
            } catch (Exception e) {
                System.err.println(e);
            }
        }).start();
    }

    public static double map(double s, double a1, double a2, double b1, double b2) {
        return b1 + ((s - a1) * (b2 - b1)) / (a2 - a1);
    }

}
