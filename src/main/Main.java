package main;

public class Main {
    public static void main(String[] args) {
        java.util.Scanner in = new java.util.Scanner(System.in);
        Clock clock = new Clock(in.nextInt(), in.nextInt(), in.nextInt());
        clock.tick();
        System.out.println(clock);
        in.close();
    }
}

class Clock {
    private Display hour = new Display(24);
    private Display minute = new Display(60);
    private Display second = new Display(60);

    public Clock(int hour, int minute, int second) {
        this.hour.setValue(hour);
        this.minute.setValue(minute);
        this.second.setValue(second);
    }

    public void tick() {
        this.second.increase();
        if (this.second.getValue() == 0) {
            this.minute.increase();
            if (this.minute.getValue() == 0) {
                this.hour.increase();
            }
        }
    }
    public String toString() {
        return String.format("%02d:%02d:%02d",this.hour.getValue(),this.minute.getValue(),this.second.getValue());
    }
}

class Display {
    private int value = 0;
    private int limit = 0;

    public void setValue(int value) {
        this.value = value;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getValue() {
        return this.value;
    }

    public Display() {
    }

    public Display(int limit) {
        this.limit = limit;
    }

    public void increase() {
        value++;
        if (value == limit) {
            value = 0;
        }
    }
}