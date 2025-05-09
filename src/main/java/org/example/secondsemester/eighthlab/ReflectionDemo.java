package org.example.secondsemester.eighthlab;

import org.example.secondsemester.sixthlab.Human;

import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class ReflectionDemo {
    public static int SearchCountOfElementsOfHuman(ArrayList<Object> list){
        int count = 0;
        for (Object i : list){
            if (i instanceof Human){
                count++;
            }
        }
        return count;
    }

    public static ArrayList<String> getPublicMethods(Object object){
        if (object == null) {
           throw new IllegalArgumentException("Cannot be null");
        }

        Method[] methods = object.getClass().getMethods();

        List<String> methodNames = Arrays.stream(methods)
                .filter(method -> method.getModifiers() == Modifier.PUBLIC)
                .map(Method::getName)
                .distinct()
                .sorted()
                .toList();

        return new ArrayList<>(methodNames);
    }

    public static ArrayList<String> getAllNamesOfSuperClasses(Object object){
        ArrayList<String> list = new ArrayList<>();
        Class<?> clas = object.getClass();
        while (clas != null){
            list.add(clas.getName());
            clas = clas.getSuperclass();
        }
        return list;
    }

    public static int executeElementsImplementingExecutable(List<Object> list) {
        int count = 0;
        for (Object element : list) {
            if (element instanceof Executable) {
                ((Executable) element).execute();
                count++;
            }
        }
        return count;
    }

    public static List<String> getGettersAndSetters(Object object) {
        List<String> result = new ArrayList<>();

        if (object == null) {
            throw new IllegalArgumentException("Object cannot be null");
        }

        Class<?> clazz = object.getClass();
        Method[] methods = clazz.getMethods();

        for (Method method : methods) {
            int modifiers = method.getModifiers();

            if (Modifier.isPublic(modifiers) && !Modifier.isStatic(modifiers)) {
                String name = method.getName();
                Class<?> returnType = method.getReturnType();
                Class<?>[] params = method.getParameterTypes();

                if (name.startsWith("get") && name.length() > 3
                        && params.length == 0
                        && returnType != void.class) {
                    result.add(name);
                }

                else if (name.startsWith("set") && name.length() > 3
                        && params.length == 1
                        && returnType == void.class) {
                    result.add(name);
                }
            }
        }
        return result;
    }


}
