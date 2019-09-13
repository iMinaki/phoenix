package test;


public class Logger {
    // 保证 instance 在所有线程中同步，禁止指令重排序
    private static volatile Logger instance = new Logger();

    private Logger() {
    }

    public static Logger getLog() {
        return instance;
    }

    public void debug(String message) {
        System.out.println(this + " thread name : " + message);
    }

    public static void main(String[] args) throws InterruptedException {
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    Logger.getLog().debug(Thread.currentThread().getName());
                }
            }).start();
        }
    }
}
