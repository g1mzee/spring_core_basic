package hello.core.lifecycle;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.lang.annotation.Annotation;

public class BeanLifeCycleTest {

    @Test
    void lifeCycleTest() {
        ConfigurableApplicationContext cac = new AnnotationConfigApplicationContext(LifeCycleConfig.class);
        NetworkClient client = cac.getBean(NetworkClient.class);
        cac.close();
    }

    @Configuration
    static class LifeCycleConfig {
                                    // destroyMethod의 defualt값은 (inferred)이다. 말그대로 추론하는 기능. close, shutdown으로 된
                                    // 메서드명을 검색하여 destroyMethod로서 기능하게 연결해 준다.
//        @Bean( initMethod = "init", destroyMethod = "close")
        @Bean
        public NetworkClient networkClient() {
            NetworkClient networkClient = new NetworkClient();
            networkClient.setUrl("http://hello-spring.dev");
            return networkClient;
        }
    }
}
