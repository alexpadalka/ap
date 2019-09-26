**Task 1. (5 points) A bit of concurrency**

Create several instances of Runnable interface with different behavior using lambda expressions. Run these lambdas via Thread API.

**Task 2. (5 points) A person stream**

Create:
1. Person class with name and age fields
2. A collection of Persons;
3. Two instances of Comparator<Person> interface using lambda expressions: first one for comparing by name, second one – by age

Then sort them using these comparators.
Use forEach method for printing information about all the persons. 
Try to use method reference if it is possible.
 
**Task 3. (10 points) Functional Interface Sandbox**

 1. Implement each of main Java Standard Library functional interfaces (supplier, predicate etc.) using lambda expressions.
2. Create your own functional interface and add several implementations using both lambda expressions and inner anonymous classes.
3. Add few default methods to it and use them.
4. Add few static methods to it and use them. 
 
**Task 4. (5 points) Custom Functional Interface**

1. Write your own functional interface ThreeFunction (it takes three arguments and produce result).
2. Implement this with two different lambdas
3. Provide client code with usage of this lambdas
 
**Task 5. (20 points) Collection to stream**

1. Create the following classes:
    1. Author with fields: 
        1. String name
        2. short age
        3. List<Book> books
    2. Book with fields
        1. String title
        2. List<Author> authors
        3. int numberOfPages
2. Create two arrays: Author[] authors and Book[] books. Their elements must use elements from the neighboring array.
3. Create a stream of books and then:
    1. check if some/all book(s) have more than 200 pages;
    2. find the books with max and min number of pages;
    3. filter books with only single author;
    4. sort the books by number of pages/title;
    5. get list of all titles;
    6. print them using forEach method;
    7. get distinct list of all authors
4. Use peek method for debugging intermediate streams during execution the previous task.
5. Use parallel stream with subtask #3.
6. Analyze with mentor results of previous subtask execution, explain him the difference between stream and parallel stream.
7. Use the Optional type for determining the title of the biggest book of some author.

**Task 6. (20 points) Custom collector**

Define a complex class A with a few fields with different types. This class will be an item in collection.
Define a few methods which calculates some stat over the fields of the A class.
Make stream from the collection of A’s instances.
Write custom collector to accumulate the information from elements of your stream.
1. Implement Collector interface
2. Don’t forget the final transformation
3. Try to use Characteristics for the optimization purpose.
4. Add tests for your collector.
Test your Collector with the parallel streams for significant amount of items in stream.
Look at the Collector interface and read about combine method if something is going wrong.

**Task 7. (15 points) Math collector for the IntStream**
1. Write a custom collector for the IntStream or integer generator like Stream.iterate(0,i->i+10).limit(1_000_000)
2. This collector should calculate the sum, count, average, min, max over the stream items.
3. Define your own object to keep math stats.
4. Add tests for your collector.
5. Tune performance with Characteristics and collect the results into the small performance report that should be attached to your final solution. Discuss with mentor the given results.
6. It should support parallel streams.

**Task 8. (20 points) Magic Tree**
You have class Tree with a few unsupported operations. 
```
class Tree {
    private int value;
    private List<Tree> children = new LinkedList<>();
    public Tree(int value, List<Tree> children) {
        super();
        this.value = value;
        this.children.addAll(children);
    }
    public Tree(int value, Tree... children) {
        this(value, asList(children));
    }
    public int getValue() {
        return value;
    }
    public List<Tree> getChildren() {
        return Collections.unmodifiableList(children);
    }
    public Stream<Tree> flattened() {
// ***
    }
}
```
Implement flattened() method. It should return Stream of all childrens in Pre-order.
for tree
```
     0
    1 2
11 12 21 22
```
it should return
```
0 1 11 12 2 21 22
```

Also, add and implement next methods
```
// Get all values in the tree: 
List<Integer> getAllValues
// Get even values: 
List<Integer> getEvenValues 
// Sum of even values: 
Optional<Integer> sumOfEvenValues
// Does it contain 13? 
Boolean isContains13
```