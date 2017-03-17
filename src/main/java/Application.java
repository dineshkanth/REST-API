import hello.SampleController;

import org.springframework.boot.*;
import org.springframework.boot.SpringApplication;

/**
 * Created by z002903 on 2/25/2017.
 */
public class Application {

    public static void main(String[] args) throws Exception {
        SpringApplication.run(SampleController.class, args);
    }

}
