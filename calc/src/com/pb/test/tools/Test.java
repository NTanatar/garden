package com.pb.test.tools;

import com.pb.test.calc.Calculator;

import java.lang.annotation.Annotation;
import java.lang.reflect.*;

public class Test {
    public static void reflect(Object obj) {
        Class c = obj.getClass();
        System.out.println("==== name: " + c.getName());
        int modi = c.getModifiers();
        System.out.println("public: " + Modifier.isPublic(modi));
        System.out.println("superclass: " + c.getSuperclass().getName());
        Class[] interfaces = c.getInterfaces();
        System.out.println("interfaces: ");
        for (Class a : interfaces) {
            System.out.println("   " + a.getName());
        }
        reflectFields(obj);
        reflectMethods(c);
        System.out.println("===================  ");
    }

    public static void reflectFields(Object obj) {
        Field[] allFields = obj.getClass().getDeclaredFields();
        System.out.println("fields: ");
        for (Field field : allFields) {
            Class fieldType = field.getType();
            try {
                field.setAccessible(true);
                System.out.println("   " + field.getName() + " (" + fieldType.getName() + ") -> " + field.get(obj).toString());
            } catch (IllegalAccessException e) {
                System.out.println("could not access value " + field.getName());
            }
        }
    }

    public static void reflectMethods(Class c) {
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method " + method.getName());
            Annotation[][] parameterAnnotations = method.getParameterAnnotations();
            for (Annotation[] annotations : parameterAnnotations) {
                for (Annotation annotation : annotations) {
                    if (annotation instanceof Important) {
                        System.out.println("  -> Important parameter");
                    }
                }
            }
        }
    }

    public static void printInfoFromAnnotation(Class cl) {
        Annotation[] annotations = cl.getAnnotations();
        for (Annotation annotation : annotations) {
            if (annotation instanceof NewYearParty) {
                NewYearParty ann = (NewYearParty) annotation;
                System.out.println("day: " + ann.day());
                System.out.println("place: " + ann.place());
            }
        }
    }

    private static void invokeMethodByName(Object obj, String methodName, Class[] paramTypes, Object[] paramValues) {
        Class c = obj.getClass();
        try {
            Method method = c.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            Object result = method.invoke(obj, paramValues);
            System.out.println(" = " + result);
        } catch (NoSuchMethodException e) {
            System.err.println("no such method " + e.getMessage());
        } catch (IllegalAccessException e) {
            System.err.println("cannot access method");
        } catch (InvocationTargetException e) {
            System.err.println(e);
        } finally {
            System.out.println("Everything is under control");
        }
    }

    private static Object createInstanceByClassName(String name) {
        Object obj = null;
        try {
            Class c = Class.forName(name);
            obj = c.newInstance();
        } catch (ClassNotFoundException e) {
            System.err.println("class not found " + e.getMessage());
        } catch (Exception e) {
            System.err.println("something went wrong");
        }
        return obj;
    }

    public static void main(String[] args) {
        Class[] paramTypes = new Class[] {char.class, int.class, int.class};
        Object[] params = new Object[] {new Character('+'), new Integer(41), new Integer(13)};
        Calculator calculator = (Calculator) createInstanceByClassName("com.pb.test.calc.Calculator");
        invokeMethodByName(calculator, "doCalculation", paramTypes, params);

        createInstanceByClassName("com.pb.test.XXX");
        invokeMethodByName(calculator, "nonExisting", paramTypes, params);
    }
}
