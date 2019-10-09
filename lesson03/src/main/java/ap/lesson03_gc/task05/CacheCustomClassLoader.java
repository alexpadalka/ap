package ap.lesson03_gc.task05;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.Map;

import org.apache.log4j.Logger;

import ap.util.JMPUtils;

public class CacheCustomClassLoader extends CustomClassLoader {

  private Logger logger = JMPUtils.getLogger();

  private Map<String, Class<?>> cache = new HashMap<>();

  public Class<?> findClass(String className) {

    logger.info(String.format("Try to find class {} from cache", className));

    if (cache.containsKey(className)) {
      return cache.get(className);
    }

    logger.info(String.format("Try to load class {}", className));

    Class<?> aClass = null;
    try {
      aClass = super.findClass(className);
      cache.put(className, aClass);
    } catch (ClassNotFoundException e) {
      logger.error(e.getMessage());
    }

    return aClass;
  }

  public Object newInstance(String className) {

    logger.info(String.format("Try to create instance of class {}", className));

    try {
      return findClass(className).newInstance();
    } catch (InstantiationException | IllegalAccessException e) {
      logger.error(e.getMessage());
    }
    return null;
  }

  public void methodInvoke(String className, String methodName, String param) {

    logger.info(String.format("Try to invoke method {} in class {} with param '{}'", methodName, className, param));

    Class<?> aClass;
    Method method;
    try {
      aClass = findClass(className);
      method = param != null ? aClass.getMethod(methodName, String.class) : aClass.getMethod(methodName);
      Object obj = aClass.newInstance();
      if (param != null) {
        method.invoke(obj, param);
      } else {
        method.invoke(obj);
      }
    } catch (NoSuchMethodException | InvocationTargetException | IllegalAccessException | InstantiationException e) {
      logger.error(e.getMessage());
    }
  }
}
