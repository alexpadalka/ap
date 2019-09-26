package com.epam.jmp.lesson03_gc.task05;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

public class CustomClassLoader extends ClassLoader {

  @Override
  public Class<?> findClass(String className) throws ClassNotFoundException {
    byte[] bytes = loadClassData(className);
    return defineClass(className, bytes, 0, bytes.length);
  }

  private byte[] loadClassData(String className) {
    InputStream inputStream = getClass().getClassLoader().getResourceAsStream(className.replace(".", "/") + ".class");
    ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
    int length = 0;
    try {
      while ((length = inputStream.read()) != -1) {
        byteArrayOutputStream.write(length);
      }
      inputStream.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return byteArrayOutputStream.toByteArray();
  }
}
