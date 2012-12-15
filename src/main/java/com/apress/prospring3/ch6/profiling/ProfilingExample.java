package com.apress.prospring3.ch6.profiling;

import org.springframework.aop.framework.ProxyFactory;

public class ProfilingExample {
    public static void main(String[] args) {
        WorkerBean workerBean = getWorkerBean();
        workerBean.doSomeWork(10000000);
    }

    private static WorkerBean getWorkerBean() {
        WorkerBean target = new WorkerBean();

        ProxyFactory pf = new ProxyFactory();
        pf.setTarget(target);
        pf.addAdvice(new ProfilingInterceptor());

        return (WorkerBean) pf.getProxy();
    }
}
