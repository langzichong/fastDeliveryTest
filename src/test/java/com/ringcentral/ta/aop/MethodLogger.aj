package com.ringcentral.ta.aop;



import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.testng.Reporter;

import java.lang.annotation.Annotation;
import java.util.Arrays;

/**
 * Created by alexander.zaverukha on 2/18/15.
 */
@Aspect
public class MethodLogger {
    @Around("execution(public * *(..)) && @annotation(Get) && within(@Component *)")
    public Object aroundGet(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();

        Annotation annotation = methodSignature.getMethod().getAnnotation(Get.class);

        String actionName = ((Get) annotation).name();


        return proceed(point, "Get value", actionName);
    }

    @Around("execution(public * *(..)) && @annotation(Set) && within(@Component *)")
    public Object aroundSet(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();

        Annotation annotation = methodSignature.getMethod().getAnnotation(Set.class);
        String actionName = ((Set) annotation).name();

        return proceed(point, "Set value", actionName);
    }

    @Around("execution(public * *(..)) && @annotation(Action) && within(@Component *)")
    public Object aroundAction(ProceedingJoinPoint point) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        Annotation annotation = methodSignature.getMethod().getAnnotation(Action.class);
        String actionName = ((Action) annotation).name();

        return proceed(point, "Perform", actionName);
    }

    private static String getComponentName(ProceedingJoinPoint point, MethodSignature methodSignature) {
        String componentName = ((Component) methodSignature.getDeclaringType().getAnnotation(Component.class)).name();
        if (componentName.isEmpty()) {
            componentName = point.getTarget().getClass().getName();
        }
        return componentName;
    }

    private static String getMethodInputParams(ProceedingJoinPoint point) {
        Object[] args = point.getArgs();
        String inputValue = "(";
        String[] paramNames = ((MethodSignature) point.getSignature()).getParameterNames();
        for (int i = 0; i < paramNames.length; i++) {
            Object arg = args[i];
            String argValue = valueToString(arg);

            inputValue += String.format("%s:%s", paramNames[i], argValue);
            if(i < paramNames.length-1){
                inputValue += ", ";
            }
        }

        inputValue += ")";

        return inputValue;
    }


    private static Object proceed(ProceedingJoinPoint point, String prefix, String name) throws Throwable {
        MethodSignature methodSignature = (MethodSignature) point.getSignature();
        String componentName = getComponentName(point, methodSignature);
        if (name.isEmpty()) {
            name = methodSignature.getMethod().getName();
        }

        String params = getMethodInputParams(point);
//        ReporterNG.logComponent(String.format("%s for '%s' at '%s' with parameters '%s'", prefix, name, componentName, params));
        Reporter.log("test AOP");
        Object result = point.proceed();

        if (methodSignature.getMethod().getReturnType().equals(Void.TYPE)) {
//            ReporterNG.logComponent(String.format("%s for '%s' at '%s' with parameters '%s' completed without result", prefix, name, componentName, params));
        }else {
//            ReporterNG.logComponent(String.format("%s for '%s' at '%s' with parameters '%s' completed with result '%s'", prefix, name, componentName, params, valueToString(result)));
        }

        return  result;
    }

    private static boolean isArray(final Object obj) {
        return obj instanceof Object[] || obj instanceof boolean[] ||
                obj instanceof byte[] || obj instanceof short[] ||
                obj instanceof char[] || obj instanceof int[] ||
                obj instanceof long[] || obj instanceof float[] ||
                obj instanceof double[];
    }

    private static String valueToString(Object o) {
        String result;
        if (isArray(o)) {
            result = Arrays.toString((Object[]) o);
        } else if (o == null) {
            result = "null";
        } else {
            result = o.toString();
        }
        return result;
    }

}