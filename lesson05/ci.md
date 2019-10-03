**Task 1. (20 points) Play with Jenkins**

1. Download LTS version of Jenkins
2. Install Jenkins (as a service)
3. Install JDK7, Maven, Ant
4. Configure Jenkins with installed JDK, Maven, Ant
5. Configure Jenkins with additional JDK (auto-installed)
6. Install 10 Jenkins plugins (Git, Parametrized trigger, email-ext, Scriptler, Groovy postbuild, Green Balls etc.)
7. Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and developer user (build job, cancel builds)
8. Create simple free-style job
9. Setup simple trigger and build action (echo current build number)
10. Send email about build result

**Task 2. (40 points) CI for Petclinic app**

1. Create GitHub account
2. Install Jenkins
3. Install SonarQube
    1. Configure Jenkins to use local SonarQube installation.
    2. Configure custom SonarQube quality profile.
4. Fork Spring Petclinic application (https://github.com/spring-projects/spring-petclinic/)
5. Configure Jenkins build job to checkout Petclinic project from your GitHub account
6. Configure polling interval (5 minutes)
7. Setup Petclinic build with Maven
8. Ensure unit tests are executed
9. Ensure unit test results are display on Jenkins project and build pages
10. Commit any change to your GitHub project and this should result in Jenkins automated build triggered
11. For every push to repository Jenkins should build the build when the following statement are true: 
    1. Sonar has been run. 
    2. JUnit tests has been run. 
    3. if PointA or PointB are failed, then the build must be failed too. In this case the pusher should get the notification with the report.
12. If the build is failed, send email to the authors of last commits with the reason of fail
13. Add ability to generate a version number for each release. It should be incremented since start of the year, for example 1.0.2, where 2 is the second build since the start of the current year.

**Task 3. (10 points) Simple plugin**

1. Create simple plugin which will add new Action to Jenkins project page
2. Run Jenkins with custom plugin from IDE (Eclipse, IDEA) using mvn hpi:run
3. Ensure new link (custom action) appeared on project page

**Task 4. (20 points) Openshift**

1. Create account on Openshift https://www.openshift.com/ 
2. Install one cartridge (Jboss / Wildfly) 
3. Add Jenkins to this cartridge 
4. Configure Jenkins with to use your repository with Spring app
5. Build you Spring app. 
6. Install same Jenkins plugins (Git, Parametrized trigger, email-ext, Scriptler, Groovy postbuild, Green Balls etc.) 
7. Configure Jenkins security (install Role strategy plugin). Remove anonymous access. Create administrator user (all permissions) and developer user (build job, cancel builds) 
8. Create simple free-style job 
9. Setup simple trigger and build action (echo current build number) 
10. Send email about build result

As result you should have two cartridges (Openshift provided free three cartridges) one with built Spring app and second with Jenkins
