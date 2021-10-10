package org.yeasheng.jvm.chapter03;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.net.URLClassLoader;

/**
 * @author yansh
 * @version 2021/5/16
 **/
public class ClassLoaderTest {

    public static void main(String[] args) {
        ClassLoader systemClassLoader = ClassLoader.getSystemClassLoader();
        System.out.println(systemClassLoader.toString());

        ClassLoader extendClassLoader = systemClassLoader.getParent();
        System.out.println(extendClassLoader.toString());

        ClassLoader bootstrap = extendClassLoader.getParent();
        System.out.println(bootstrap);


        Class<ClassLoaderTest> clazz = ClassLoaderTest.class;
        ClassLoader classLoader = clazz.getClassLoader();
        System.out.println(classLoader);

        System.out.println("+++++++");
        System.out.println(URLClassLoader.class.getClassLoader());
        System.out.println(ClassLoader.class.getClassLoader());
    }
}
