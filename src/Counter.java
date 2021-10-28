public class Counter {

    private int count = 0;

    public int incrementAndGet() {
        synchronized (this) {
            this.count++;
            return this.count;
        }
    }

    public int getCount() {
        synchronized (this) {
            return this.count;
        }
    }
}
