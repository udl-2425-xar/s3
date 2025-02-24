public class Example1 {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        for(int id=1; id <=5; id++){
            Thread t = new Thread(new ExampleThread(), "Thread "+id);
            t.start();
        }
    }
    public static class ExampleThread implements Runnable{
        @Override
        public void run() {
            String name = Thread.currentThread().getName();
            System.out.println("Hola sóc " + name);
            try{
                for (int i=0; i<5; i++){
                    System.out.println(name + ". Segon número " + i);
                    Thread.sleep(1000);
                }
                System.out.println(name + " adéu");
            }catch (Exception e){
                e.printStackTrace();
            }

        }
    }
}