**From relations to object graphs - a relation mapper for POJOs.**

This is a package package for mapping relational data to object
graphs. The data can originate anywhere, but the most typical use-case
is result sets produced by joining tables in a relational database. The
mapping is type-safe, so there's multiple mappers with different
child-parent relationships and different number of type parameters.

**Setting up for Maven**

```xml
<project ...>

    ...

    <repositories>
        <repository>
            <snapshots>
                <enabled>false</enabled>
            </snapshots>
            <id>relate-java</id>
            <name>relate-java</name>
            <url>http://dl.bintray.com/relate-java/relate-java</url>
        </repository>
    </repositories>

    ...

    <dependencies>
        <dependency>
            <groupId>com.relatejava</groupId>
            <artifactId>relate</artifactId>
            <version>0.2</version>
        </dependency>
    <dependencies>

    ...

</project>
```

**Naming scheme of classes:**

    RelationMapper_a__b_c_d_e
    
    a = number of children of each root object
    b = number of sub-children of first child
    c = number of sub-children of second child
    d = number of sub-children of third child
    e = number of sub-children of fourth child

*(note the double underscore after `a`)*
 
**Usage example:**

 ```java
 import java.util.List;
 import java.util.Arrays;
 import com.relatejava.relate.RelationMapper_1__1;
 
 public class RelateExample {
 
     public static class Department {
          public final String name;
          public final Map<String, Set<String>> personnel;
     
          public Department(String name, Map<String, Set<String>> personnel) {
              this.name = name;
              this.personnel = personnel;
          }
     }
 
     public static void main(String[] args) {
         List<List<String>> values = 
              Arrays.asList(
                  Arrays.asList("Accounting",     "Mark",    "mark@example.com"),
                  Arrays.asList("Accounting",     "Mark",    "mark.kish@example.com"),
                  Arrays.asList("Accounting",     "Jen",     "jen@example.com"),
                  Arrays.asList("IT",             "Fred",    "fred@example.com"),
                  Arrays.asList("IT",             "John",    "john@example.com"),
                  Arrays.asList("IT",             "John",    "john.doe@example.com"));
         
         // Root is department name, subobject is person, sub-subobject is email
         RelationMapper_1__1<String, String, String>
              mapper = new RelationMapper_1__1<>();
         for (List<String> row : values) {
              // The following 2 lines are optional in this case
              mapper.root(row.get(0));
              mapper.relate_1(row.get(0), row.get(1));
              mapper.relate_1_1(row.get(0), row.get(1), row.get(2));
         }
         
         // Java 8 syntax, works with 7 too
         List<Department> result = mapper.<Department>build(Department::new);
     }
 
 }
```
