package Exam;
public class Stopwatch {
    private long startTime;
    private boolean running;

    public void start() {
        if (!running) {
            startTime = System.currentTimeMillis();
            running = true;
            System.out.println("Stopwatch started.");
        } else {
            System.out.println("Stopwatch is already running.");
        }
    }

    public void stop() {
        if (running) {
            long endTime = System.currentTimeMillis();
            long elapsedTime = endTime - startTime;
            running = false;
            System.out.println("Stopwatch stopped.");
            System.out.println("Elapsed time: " + elapsedTime + " milliseconds");
        } else {
            System.out.println("Stopwatch is not running.");
        }
    }

    public void reset() {
        if (!running) {
            startTime = 0;
            System.out.println("Stopwatch reset.");
        } else {
            System.out.println("Stopwatch is running. Please stop it first.");
        }
    }
}