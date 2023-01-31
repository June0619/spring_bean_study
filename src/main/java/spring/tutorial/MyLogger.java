package spring.tutorial;

import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
public class MyLogger {

    private String uuid;
    private HttpServletRequest request;

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void log() {
        uuid = UUID.randomUUID().toString();
        System.out.printf("[%s] %s\n", uuid, request.getRequestURL().toString());
    }

}