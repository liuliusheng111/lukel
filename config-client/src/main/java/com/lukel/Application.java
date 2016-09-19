package com.lukel;

/**
 * Created by admin on 16/9/17.
 */
    import org.springframework.beans.factory.annotation.Value;
    import org.springframework.boot.SpringApplication;
    import org.springframework.boot.autoconfigure.SpringBootApplication;
    import org.springframework.boot.context.embedded.ConfigurableEmbeddedServletContainer;
    import org.springframework.boot.context.embedded.EmbeddedServletContainerCustomizer;
    import org.springframework.boot.context.web.SpringBootServletInitializer;
    import org.springframework.web.bind.annotation.RequestMapping;
    import org.springframework.web.bind.annotation.RestController;

    /**
     * Created by liaokailin on 16/4/28.
     */
    @SpringBootApplication
    @RestController
    public class Application  extends SpringBootServletInitializer implements EmbeddedServletContainerCustomizer {
        @Value("${my.message}")
        String bar;

        @RequestMapping("/")
        String hello() {
            return "Hello " + bar + "!";
        }

        public static void main(String[] args) {
            SpringApplication.run(Application.class, args);
        }

        @Override
        public void customize(ConfigurableEmbeddedServletContainer container) {
            container.setPort(9999);
        }
    }
