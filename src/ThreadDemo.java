public class ThreadDemo
{
    public static void main(String[] args) throws Exception {
        Thread t1 = new Thread(() ->
        {
            for(int i=1; i<=5; i++) {
                System.out.println("Hi " + Thread.currentThread().getPriority());
                try {
                    Thread.sleep(1000);    // suspend the thread for a second
                } catch (Exception e) {

                }

            }
        });

        Thread t2 = new Thread(() ->
        {
            for(int i=1; i<=5; i++) {
                System.out.println("Hello");
                try {
                    Thread.sleep(1000);    // suspend the thread for half a second
                } catch (Exception e) {

                }
            }
        });

        t1.setPriority(Thread.MIN_PRIORITY);
        t2.setPriority(Thread.MAX_PRIORITY);

        System.out.println(t1.getPriority());
        System.out.println(t2.getPriority());

        t1.start();
//        try {
//            Thread.sleep(10);    // suspend the main thread for 10 seconds so it will call t2.start() after 10 seconds
//        } catch (Exception e) {
//
//        }
        t2.start();

        t1.join();   // make mainthread wait
        t2.join();
        System.out.println("Bye");

    }
}