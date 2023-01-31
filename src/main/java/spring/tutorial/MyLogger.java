package spring.tutorial;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.servlet.http.HttpServletRequest;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private HttpServletRequest request;

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void setUuid() {
        this.uuid = UUID.randomUUID().toString();
    }

    public void log() {
        System.out.printf("[%s] %s\n", uuid, request.getRequestURL().toString());
    }

}
