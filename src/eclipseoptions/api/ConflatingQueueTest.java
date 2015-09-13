package eclipseoptions.api;

/**
 * Created by antlen on 13/9/15.
 */
public class ConflatingQueueTest {

    public static void main(String args[] ){
        ConflatingQueue<String, Integer> queue = new ConflatingQueueImpl<String, Integer>();

        queue.offer(new KV("TEST", 1));
        queue.offer(new KV("TEST", 2));
        queue.offer(new KV("TEST", 3));
        queue.offer(new KV("TEST", 4));

        try {
            System.out.println("The value should be 4 : " + queue.poll().getValue());
        }catch(Exception e){
            e.printStackTrace();
        }
        new Thread(new Producer("Anthony", 10, 3000L, queue)).start();

        new Thread(new Producer("Anthony", 10, 1000L, queue)).start();

        new Thread(new Consumer(queue, 1)).start();

        new Thread(new Consumer(queue, 2)).start();

        new Thread(new Consumer(queue, 3)).start();
    }


    public static class Consumer implements Runnable{
        private final ConflatingQueue<String, Integer> queue;

        private int id;

        public Consumer(ConflatingQueue<String, Integer> queue, int id ) {
            this.queue=queue;
           this.id =id;
        }
        public void run() {
            while(true){
                try {
                    KeyedValue<String, Integer> v = queue.poll();
                    System.out.println("READ " +id +" " + v.getKey() + " : " + v.getValue());
                    Thread.sleep(2000);
                }catch(Exception e){
                    throw new RuntimeException(e);
                }
            }
        }
    }


    public static class Producer implements Runnable{
        private final String name;
        private int count;
        private final long sleep;
        private final ConflatingQueue<String, Integer> queue;


        public Producer(String name, int count, long sleep, ConflatingQueue<String, Integer> queue ) {
            this.name = name;
            this.count = count;
            this.sleep = sleep;
            this.queue=queue;
        }

        public void run() {
            while(count > 0){

                KeyedValue<String, Integer> v = new KV( name+count, (int)(count * sleep));

                System.out.println("WRITE " + v.getKey()+ " : " + v.getValue());
                queue.offer(v);

                try {
                    Thread.sleep(sleep);
                }catch (Exception e){
                    throw new RuntimeException(e);
                }
                count --;
            }
        }
    }


    private static class KV implements  KeyedValue<String, Integer>{
        private final String key;
        private final int value;

        public KV(String key, int value) {
            this.key = key;
            this.value = value;
        }

        public String getKey() {
            return key;
        }

            public Integer getValue() {
                return value;
            }
    }
}
