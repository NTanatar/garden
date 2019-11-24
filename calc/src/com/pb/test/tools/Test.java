package com.pb.test.tools;

import com.pb.test.calc.Calculator;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

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
        Field[] allFields = c.getDeclaredFields();
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
        Method[] methods = c.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println("method " + method.getName());
        }
        System.out.println("====  ");
    }

    private static void invokeMethodByName(Object obj, String methodName, Class[] paramTypes, Object[] paramValues) {
        Class c = obj.getClass();
        try {
            Method method = c.getDeclaredMethod(methodName, paramTypes);
            method.setAccessible(true);
            Object result = method.invoke(obj, paramValues);
            System.out.println(" = " + result);
        } catch (NoSuchMethodException e) {
            System.out.println("wrong guess");
        } catch (IllegalAccessException e) {
            System.out.println("cannot access method");
        } catch (InvocationTargetException e) {
            System.out.println("invocation target exception");
        }
    }

    private static Object createInstanceByClassName(String name) {
        Object obj = null;
        try {
            Class c = Class.forName(name);
            obj = c.newInstance();
        } catch (ClassNotFoundException e) {
            System.out.println("class not found");
        } catch (Exception e) {
            System.out.println("something went wrong");
        }
        return obj;
    }

    public static void main(String[] args) {
        Class[] paramTypes = new Class[] {char.class, int.class, int.class};
        Object[] params = new Object[] {new Character('+'), new Integer(41), new Integer(13)};
        Calculator calculator = (Calculator) createInstanceByClassName("com.pb.test.calc.Calculator");
        invokeMethodByName(calculator, "doCalculation", paramTypes, params);
    }
}
