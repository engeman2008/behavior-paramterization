public class Lambda {
  public static void main(String args[]) {

    //lambda function
    Runnable r1 = () -> System.out.println("Hello world 1");

    //anonymous class
    Runnable r2 = new Runnable() {
      @Override
      public void run() {
        System.out.println("Hello world 2");
      }
    };

    process(r1);
    process(r2);
    process(() -> System.out.println("Hello world 3")); //lambda passed directly
  }

  public static void process(Runnable r) {
    r.run();
  }
}
