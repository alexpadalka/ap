*Note: all tasks should be developed with Java 8 at least (except Task 1)*

**Task 1. (5 0 points) Performance Report**

Take your backend application/pet-project and reduce typical (or default) -Xmx in 2x (or 4x/8x). Try different GC (G1, CMS, Parallel GC, Serial GC) and generation sizes. Compare the results with the GC log output. Run it on Java 7,8,9,10,11 (optional). After that tune Heap and PermGen (or Metaspace) and try to utilize and uberize free memory. 
Try to reach next goals if possible
1. Highest throughput in a single processor environment (don’t think about latency and pauses)
2. Highest throughput in a multi-processor environment (don’t think about latency and pauses)
3. Highest throughput and latency below 200ms in 95th percentile (or another interval agreed with your mentor)  in a multi-processor environment
4. Lowest possible latency in a multi-processor environment with fixed throughput (agreed with mentor for your system)

You can use next tools to analyze:
1. jmap
2. jVisualVM
3. https://github.com/chewiebug/GCViewer
4. http://gceasy.io/

Put your results in performance report in free form with charts, tables and screenshots.

**Task 2. (10 points) Visual VM + GC Plugin**

Take the code and run
```
public class Main {
    public static void main(String[] args) {
        List<Object> list = new ArrayList<Object>();
        while(true) {
             list.add(new Object());
        }
    }
}
```
Connect to the running JVM with VisualVM with installed GC plugin. Observe GC curve and memory regions.
1. Apply changes to the following app code to make GC curve have peaks that are more frequent.
2. Tune GC settings via JVM flags (change GC, maybe) to make GC curve have peaks that are more frequent.
3. Tune Heap regions via JVM flags to make GC curve have peaks that are more frequent.

Make screenshots for each subtask and prove your power of JVM – master!

**Task 3. (10 points) Find leaks with MAT**

Install MAT for eclipse. Review plugin features. Use one of apps from previous tasks and investigate leak suspects. Try to find other tools to detect memory leaks. Compare with MAT. Describe results in special document and share with your mentor.

**Task 4. (15 points) Prepare memory leaks and find them with YourKit Profiler**

Create simple java application (for example text file parsing or something else) with at least two memory leaks and find them using Yourkit Profiler tool.


**Task 5. (15 points) Custom classloader**

1. Create a console application with possibility of dynamic loading/updating development functionality.
2. Implement a custom classloader with a class-caching mechanism. 
3. Keep new functionality in a specified directory. Archive it in jar.
4. The application should have console menu to choose an option (add new/update existing class, demonstrate new functionality - invoke methods of the new class). 
5. Implement the output via log4j library.
