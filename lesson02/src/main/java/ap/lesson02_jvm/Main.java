package ap.lesson02_jvm;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

import ap.lesson02_jvm.task01.CustomClassLoader;
import ap.lesson02_jvm.task01.Utility;
import ap.lesson02_jvm.task04.Animal;

public class Main {

  public static void main(String[] args) {
//    executeTask01();
//    executeTask02();
//    executeTask03();
//    executeTask04();
//    executeTask05();
  }

  private static void executeTask01() {
    Utility.generateOOM_HeapSpace_1();
//    Utility.generateOOM_HeapSpace_2();
//    Utility.generateOOM_Metaspace(); //Run with -XX:MaxMetaspaceSize=1024M because by default metaspace doesn't have upper limit
//    Utility.generateSO_Recursive();
//    Utility.generateSO_NonRecursive();
  }

  private static void executeTask02() {
    // Run program with following flags
    /*
      Heap should be divided to Old and Young generations of equal size,
      where areas of Young generation are in following ratio:  3-Eden, 1-S0, 1-S1
    */
    // -XX:NewRatio=1 -XX:SurvivorRatio=3
    /*
      Heap should be of 512MB and divided to Old and Young generations of equal size,
      where areas of Young generation are in following ratio:  2-Eden, 1-S0, 1-S1
    */
    // -Xms=512M -Xmx=512M -XX:NewRatio=1 -XX:SurvivorRatio=2
    /*
      Heap should be of 512MB with Old generation of 128MB and Young generation
      with areas in following ratio:  3-Eden, 1-S0, 1-S1
    */
    // -Xms=512M -Xmx=512M -XX:NewSize=384M -XX:MaxNewSize=384M XX:SurvivorRatio=3
    /*
      Heap should be divided to Old generation of 128MB and Young generations
      with areas:  Eden of 384MB, S0 of 128MB, S1 of 128MB
    */
    // -Xms=768M -Xmx=768M -XX:NewSize=640M -XX:MaxNewSize=640M XX:SurvivorRatio=3
  }

  private static void executeTask03() {
    // Run with -XX:+HeapDumpOnOutOfMemoryError
    Utility.generateOOM_HeapSpace_2();
  }

  private static void executeTask04() {
    CustomClassLoader classLoader = new CustomClassLoader();
    List<Animal> animals = new ArrayList<>();
    Class<?> aClass = null;
    Method method = null;
    Animal animal = null;

    try {
      aClass = classLoader.findClass("com.epam.jmp.lesson02_jvm.task04.Cat");
      method = aClass.getMethod("setName", String.class);
      animal = (Animal) aClass.newInstance();
      method.invoke(animal, "Grey cardinal");
      animals.add(animal);

      aClass = classLoader.findClass("com.epam.jmp.lesson02_jvm.task04.Dog");
      method = aClass.getMethod("setName", String.class);
      animal = (Animal) aClass.newInstance();
      method.invoke(animal, "Max");
      animals.add(animal);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      e.printStackTrace();
    }

    animals.forEach(Animal::play);
    animals.forEach(Animal::voice);
  }

  private static void executeTask05() {
    // Run with -XX:+UseStringDeduplication

    CustomClassLoader classLoader = new CustomClassLoader();
    List<Animal> animals = new ArrayList<>();
    Class<?> aClass = null;
    Method method = null;
    Animal animal = null;

    try {
      aClass = classLoader.findClass("com.epam.jmp.lesson02_jvm.task04.Cat");
      method = aClass.getMethod("setName", String.class);
      animal = (Animal) aClass.newInstance();
      method.invoke(animal, "Grey cardinal");
      animals.add(animal);

      aClass = classLoader.findClass("com.epam.jmp.lesson02_jvm.task04.Dog");
      method = aClass.getMethod("setName", String.class);
      animal = (Animal) aClass.newInstance();
      method.invoke(animal, "Max");
      animals.add(animal);
    } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
      e.printStackTrace();
    }

    animals.forEach(Animal::play);
    animals.forEach(Animal::voice);
  }

}
