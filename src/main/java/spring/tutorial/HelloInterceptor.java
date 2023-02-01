package spring.tutorial;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Component
public class HelloInterceptor implements HandlerInterceptor {

    private final MyLogger myLogger;

    public HelloInterceptor(MyLogger myLogger) {
        this.myLogger = myLogger;
        System.out.println(myLogger.getClass());
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        myLogger.setRequest(request);
        myLogger.log();
        return true;
    }
}
