**Task 1. (5 points) Create simple tasks**

1. Download gradle from http://gradle.org/downloads and extract it.
2. Add an environment variable GRADLE_HOME pointing to the top-level directory of the Gradle distribution.
3. Add $GRADLE_HOME/bin to the PATH environment variable. (Windows: %GRADLE_HOME%\bin)
4. Activate the Gradle Daemon by setting the environment variable GRADLE_OPTS to ```-Dorg.gradle.daemon=true```.
5. Open a terminal and execute gradle -v.
6. Start the UI with gradle –gui
7. Add a ‘startGradle’ task that prints 'The Gradle is building'.
8. Execute this task
9. Add a ‘MyDate’ task that prints out the current date.
10. Execute this task

**Task 2. (5 points) Create custom task**

Write a custom task class of type Salary. Add a property ‘amount’ for the size of salary. Assign a default value to it. The task action should print the ‘amount’ value property. 
Add two tasks (MySalary and Mom's Friend's Son’s Salary) to your build script, both of type Salary. One should assign a custom value to the ‘amount’ property. Execute both tasks.

**Task 3. (5 points) Task dependencies**

Requirement: you should make Task 1.

1. Make the ‘MyDate’ task depend on the ‘startGradle’ task.
2. Execute the ‘MyDate’ task.
3. Execute gradle tasks --all.
4. The --dry-run (or -m) command line option executes the build but disables all actions. Execute ‘MyDate’ with the dry-run option.
5. Add some top level println statements to the script.
6. Add a println statement to the configuration block of the ‘MyDate’ task.
7. Execute the ‘startGradle’ task and analyze the output.

**Task 4. (10 points) Test power**

Take a Gradle-based project with a few unit-tests

1. Run the tests with different settings for forkEvery. What do you see?
2. Run the tests with different settings for maxParallelForks. What do you see?
3. Experiment with some of the testLogging options. (It may help to make some tests fail first.)
4. (Optional) Add a listener that, if a test fails, opens the test results XML file.

*Hints:

The test results XML file can be found at build/test-results/TEST-<test-class-name>.xml.
To execute an external command in Groovy, use "command args".execute().
Check the Javadoc of the org.gradle.api.tasks.testing.Test.afterTest method to learn about its arguments.*

**Task 5. (10 points) Dependencies**

1. Add the Maven Central repository and a configuration named myConfig. 
2. Assign the org.apache.httpcomponents:httpclient:4.5.6 dependency to myConfig.
3. Add a task showDeps that prints out the files of the myConfig configuration. 
4. Add task copyDeps that copies the files of the myConfig configuration into the build/deps dir.
5. Execute gradle dependencies.

**Task 6. (15 points) Multi-module Gradle Project**

Create multi-module gradle project with 5 modules (based on your pet – project or production code).
1. Every module must build in deployable jar executable file. 
2. Make profiling with build scans
3. Optimize building time. 
4. Optimize imports (dependencies) for each module.
5. Discuss the given result with your mentor
Read the performance-guide: https://guides.gradle.org/performance/

**Task 7. (10 points) EAR project**

Create simple (any source) EAR project. 
1. It should have modular structure: ejb, web, ear.
2. Build this project with Maven 
3. Build this project with Gradle for the same source.

**Task 8. (20 points) Maven multi-module project**

Create multi-module Maven project with the following structure:
1. web
    1. domain
    2. service
    3. resources

Add a few fake JSP pages and Java classes with simple print to logs or console

Make next features:
1. The whole project should be built in a one war (use compiler-plugin, war-plugin)
2. Deploy to Tomcat (use tomcat-maven-plugin ) or to another webserver with servlet container
3. Create 2 profiles: Dev and Prod (For example: Dev should use settings and mysql db connector and Prod should use oracle. You can use your own option)
4. Use different scopes for dependencies (test, compile, provided)
5. Use plugins for static code analyze (findbugs and/or pmd), check the code.
6. Use checkstyle plugin, (you can take from http://checkstyle.sourceforge.net/google_style.html or any other)
7. Use maven-resources-plugin for compile all resources to the directory with compiled   .class-files 
8. Add some simple tests and use the cobertura-maven-plugin (or maven-surefire-plugin)
9. Create your own archetype

**Task 9. (15 points)**

Develop build scripts for your pet application or production app or for empty project with structure from task 7 or 8. Design dependency management for mentoring pet application.

Acceptance criteria:
1.	One build script should be developed using Maven.
2.	Another build script should be developed using Gradle.
3.	Build script should do the following:
    1.	Compile code.
    2.	Build code.
    3.	Run unit tests.
    4.	Create html tests results report.
    5.	Run Checkstyle or PMD (optional).
    6.	Create war.
    7.	Deploy to application server (optional).
4.	For Gradle build script: meaningful custom task should be developed.
5.	3rd party dependencies should be managed by build tool.
6.	Compare Maven and Gradle as tools.
    1.	Provide 3 pros and 3 cons for each tool in report for mentor.

The task should be demonstrated using build tools running on local machine.

**Task 10. (15 points) Migration from Maven to Gradle**

1. Migrate Maven-managed project to Gradle
    1. Migrate your mentoring pet application to be built using Gradle 
        1. reconfigure modules to be managed by Gradle
        2. integrate your mentoring pet application to the root Maven [create it with a few fake modules] module using exec-maven-plugin
    2. Add and configure static code analyzing using FindBugs
    3. Add and configure code coverage using JaCoCo
2. Artifact publishing
    1. Install and run Nexus repository locally
    2. Add appropriate step to couple of your existing Gradle and Maven projects to publish artifacts and sources to local Nexus repository
