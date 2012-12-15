package com.apress.prospring3.ch6.profiling;

import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;
import org.springframework.util.StopWatch;
import java.lang.reflect.Method;

public class ProfilingInterceptor implements MethodInterceptor {
    @Override
    public Object invoke(MethodInvocation invocation) throws Throwable {
        // Запустить StopWatch.
        StopWatch sw = new StopWatch();
        sw.start(invocation.getMethod().getName());

        Object returnValue = invocation.proceed();

        sw.stop();
        dumpInfo(invocation, sw.getTotalTimeMillis());
        return returnValue;
    }

    private void dumpInfo(MethodInvocation invocation, long ms) {
        Method m = invocation.getMethod();
        Object target = invocation.getThis();
        Object[] args = invocation.getArguments();

        System.out.println("Executed method: " + m.getName()); // Выполняемый метод
        System.out.println("On object of type: " + target.getClass().getName()); // класс объекта
        System.out.println("With arguments:"); // аргументы
        for (int x = 0; x < args.length; x++) {
            System.out.print("     > " + args[x]);
        }
        System.out.print("\n");

        System.out.println("Took: " + ms + " ms"); // время выполнения
    }
}
