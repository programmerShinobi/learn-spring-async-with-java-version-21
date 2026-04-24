package programmershinobi.spring;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.time.Duration;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Future;

@Slf4j
@SpringBootTest
class HelloAsyncTest {

    @Autowired
    private HelloAsync helloAsync;

    @Test
    void helloName() throws ExecutionException, InterruptedException {
        Future<String> future = helloAsync.hello("Faqih");
        log.info("after call hello(Faqih)");
        String response = future.get();
        log.info(response);
    }

    @Test
    void hello() throws InterruptedException {
        for (int i = 0; i < 16; i++) {
            helloAsync.hello();
        }
        log.info("after call hello()");
        Thread.sleep(Duration.ofSeconds(10));
    }
}