**Task 1. (15 points) Factorial via FJK**

Use FJK to calculate factorial. Compare with the sequential implementation. Use BigInteger to keep values.

**Task 2. (15 points) Multithreading Sorting via FJK**

Implement Merge Sort or Quick Sort algorithm that sorts huge array of integers in parallel using Fork/Join framework.

**Task 3. (25 points) File Scanner via FJK**

Create CLI application that scans a specified folder and provides detailed statistics: 
1. File count 
2. Folder count 
3. Size (sum of all files size) (Similar like windows context menu "properties") 

Since the folder may contain huge number of files the scanning process should be executed in a separate thread displaying an informational message with some simple animation like progress bar in CLI (up to you, but I'd like to see that task is in progress). 
Once task is done, the statistics should be displayed in the output immediately. 
Additionally, there should be ability to interrupt the process pressing some reserved key (for instance "c"). 
Of course, use Fork-Join Framework for implementation parallel scanning.

**Task 4. (20 points) Completable Future help to build Open Salary Society**

Assume, we have REST endpoint that returns a list of Hired Employees.
1. REST endpoint is wrapped by Java service class that consuming this endpoint.
2. Fetch a list of Employee objects asynchronously by calling the hiredEmployees()
3. Join another CompletionStage<List> that takes care of filling the salary of each hired employee, by calling the getSalary(hiredEmployeeId) method which returns a CompletionStage that asynchronously fetches the salary (again could be consuming a REST endpoint).
4. When all Employee objects are filled with their salaries, we end up with a List<CompletionStage>, so we call <special operation on CF> to get a final stage that completes upon completion of all these stages.
5. Print Hired Employees with their salaries via <special operation on CF> on final stage.

Provide correct solution with CF usage and use appropriate CF operators instead <special operation on CF>.
Why does the CF usage improve performance here in comparison with synchronous approach? Discuss it with mentor. How thread waiting is implemented in synchronous world?

**Task 5. (40 points + 15 points for bonus tasks) PC assembly line with Akka**

Automatize PC assembly line with Akka Framework (use Java API).
Requirements:
1. Create PC object and fill it with data from operation to operation
2. Make more than 2 levels-hierarchy of actors
3. Log all steps and meta info about Self and Sender with AkkaLogger
4. Create 1 actor (or more) for each step of process and 1 router to route all requests for assembling
5. Write Service layer with CompletableFutures in signatures (handle router answers or inbox events) where it is possible
6. Provide client code to call Service layer methods (your choice)
7. Try with different dispatchers and pick one for your solution
8. Tune ForkJoin executor for your environment (change configuration)
9. The choice should be based on performance tests*
10. Throughput of assembly line should be more than 100 000 assembled PCs per second*
11. Throughput of assembly line should be more than 1 000 000 assembled PCs per second**

*-optional points (5 points per subtask)

*An example of actions is described in next paper: http://techreport.com/review/23624/how-to-build-a-pc-the-tech-report-guide*
