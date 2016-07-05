package threadTest;

/**
 * Created by zhangyn on 2016/7/4.
 */
public class RunnableTest implements Runnable{

    private String name;
    public RunnableTest(String name ){
        this.name = name;
    }

    @Override
    public void run() {
        for (int i = 0; i < 5; i++) {
            System.out.println(name + ":" + i);
            try {
                Thread.sleep((int)Math.random()*100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        new Thread(new RunnableTest("t1")).start();
        new Thread(new RunnableTest("t2")).start();
    }
}
