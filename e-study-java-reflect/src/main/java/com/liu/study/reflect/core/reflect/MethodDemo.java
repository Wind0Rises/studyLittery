package com.liu.study.reflect.core.reflect;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

/**
 *
 * @author lwa
 * @version 1.0.0
 * @createTime 2020/8/17 17:34
 */
public class MethodDemo {

    private void privateNoArg() {
        System.out.println("------- private --- no -- args -------------");
    }

    protected void protectedNoArg() throws Exception {
        System.out.println("------- protected --- no -- args -------------");
    }

    public String publicNoArg() {
        System.out.println("------- public --- no -- args -------------");
        return "sucess";
    }


    public void publicHasArg(String username) {
        System.out.println("------- public --- have -- args -------------" + username);
    }

    public static void main(String[] args) throws Exception {

        List<String> methodNames = Arrays.asList("privateNoArg", "protectedNoArg", "publicNoArg", "publicHasArg");

        Class<MethodDemo> methodDemoClass = MethodDemo.class;
        Method[] declaredMethods = methodDemoClass.getDeclaredMethods();
        Stream.of(declaredMethods).forEach(item -> {

            System.out.println("---------------------------------------");
            System.out.println(item.getModifiers());
            System.out.println(item.getReturnType());
            System.out.println(item.getGenericReturnType());
            System.out.println(item.getExceptionTypes().length > 0 ? item.getExceptionTypes()[0].getSimpleName() : "");
            System.out.println(item.getAnnotations());
            System.out.println("---------------------------------------");

            if (methodNames.contains(item.getName())) {
                Parameter[] parameters = item.getParameters();
                if (parameters.length == 0) {
                    try {
                        item.invoke(methodDemoClass.newInstance());
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }

                for (Parameter param : parameters) {
                    try {
                        item.invoke(methodDemoClass.newInstance(), "liwe");
                    } catch (IllegalAccessException e) {
                        e.printStackTrace();
                    } catch (InvocationTargetException e) {
                        e.printStackTrace();
                    } catch (InstantiationException e) {
                        e.printStackTrace();
                    }
                }

            }
        });
    }

}