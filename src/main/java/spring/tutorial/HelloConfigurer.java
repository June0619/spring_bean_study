package spring.tutorial;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Component
public class HelloConfigurer implements WebMvcConfigurer {

    private final HelloInterceptor helloInterceptor;

    public HelloConfigurer(HelloInterceptor helloInterceptor) {
        this.helloInterceptor = helloInterceptor;
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(helloInterceptor)
                .addPathPatterns("/hello");
    }
}
