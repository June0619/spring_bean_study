package spring.tutorial;

import org.springframework.context.annotation.Scope;
import org.springframework.context.annotation.ScopedProxyMode;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

@Component
@Scope(value = "request", proxyMode = ScopedProxyMode.TARGET_CLASS)
public class MyLogger {

    private String uuid;
    private String log;
    private HttpServletRequest request;

    public void setRequest(HttpServletRequest request) {
        this.request = request;
    }

    public void log() {
        log = String.format("[%s] %s\n", uuid, request.getRequestURL().toString());
        System.out.print(log);
    }

    @PostConstruct
    private void init() {
        uuid = UUID.randomUUID().toString();
    }

    @PreDestroy
    private void close() {
        try {
            BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("log.txt", true));
            bos.write(log.getBytes());
            bos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
