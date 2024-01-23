package JavaConventions;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

public class GetterAndSetterTest {
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_RED = "\u001B[31m";
    public static void testGettersAndSettersName(Class c) {

        HashMap<Field, boolean[]> allFields = new HashMap<Field, boolean[]>();

        for (Field f : c.getDeclaredFields()){

            boolean hasGetter = false;
            boolean hasSetter = false;

            for(Method m : c.getDeclaredMethods()){
                if(m.getName().equals("get" + (f.getName().substring(0,1)).toUpperCase() + (f.getName().substring(1)) )){
                    hasGetter = true;
                }
                if(m.getName().equals("set" + (f.getName().substring(0,1)).toUpperCase() + (f.getName().substring(1)) )){
                    hasSetter = true;
                }
            }

            /* field: has getter, has setter,*/
            allFields.put( f, new boolean[] { hasGetter, hasSetter });
            for (Field field : allFields.keySet()){
                String fieldName = field.getName();
                String getter = (allFields.get(f)[0]) ? ANSI_GREEN + "TRUE" + ANSI_RESET : ANSI_RED + "FALSE" + ANSI_RESET;
                String setter = (allFields.get(f)[1]) ? ANSI_GREEN + "TRUE" + ANSI_RESET : ANSI_RED + "FALSE" + ANSI_RESET;
                System.out.println("FIELD: " + fieldName + "\t\t" + getter + "\t" + setter);
            }
        }

    }
}
