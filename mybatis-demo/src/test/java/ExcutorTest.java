import org.junit.Test;

import java.util.concurrent.*;

public class ExcutorTest {

    @Test
    public void test() throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(() -> sayHello("zs"));
        new Thread(futureTask).start();
        System.out.println("bbbbbbbbb");
        System.out.println(futureTask.get());

    }

    private String sayHello(String name) throws InterruptedException {
        System.out.println("aaaaaaaaa");
        Thread.sleep(2000);
        return "hello~" + name;
    }


}
