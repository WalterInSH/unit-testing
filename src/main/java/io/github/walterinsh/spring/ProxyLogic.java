package io.github.walterinsh.spring;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

/**
 * Created by Walter on 8/13/16.
 */
@Aspect
public class ProxyLogic {

    @Before("execution(* io.github.walterinsh.spring.AOPSpringBean.run())")
    public void beforeRun() {
        System.out.println("before run");
    }
}
