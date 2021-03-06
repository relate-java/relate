/* 
 * Copyright 2015 Ilmo Euro.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

/**
 * <p>From relations to object graphs - a relation mapper for POJOs.</p>
 * 
 * <p>This is a package package for mapping relational data to object
 * graphs. The data can originate anywhere, but the most typical use-case
 * is result sets produced by joining tables in a relational database. The
 * mapping is type-safe, so there's multiple mappers with different
 * child-parent relationships and different number of type parameters.</p>
 * 
 * <p><b>Naming scheme of classes:</b></p>
 * <pre>
 * 
 * RelationMapper_a__b_c_d_e
 * 
 * a = number of children of each root object
 * b = number of sub-children of first child
 * c = number of sub-children of second child
 * d = number of sub-children of third child
 * e = number of sub-children of fourth child
 * </pre>
 * 
 * <p><b>Usage example:</b></p>
 * 
 * <pre>
 * 
 * import java.util.List;
 * import java.util.Arrays;
 * import com.relatejava.relate.RelationMapper_1__1;
 * 
 * public class RelateExample {
 * 
 *     public static class Department {
 *          public final String name;
 *          public final Map&lt;String, Set&lt;String&gt;&gt; personnel;
 *     
 *          public Department(String name, Map&lt;String, Set&lt;String&gt;&gt; personnel) {
 *              this.name = name;
 *              this.personnel = personnel;
 *          }
 *     }
 * 
 *     public static void main(String[] args) {
 *         List&lt;List&lt;String&gt;&gt; values = 
 *              Arrays.asList(
 *                  Arrays.asList("Accounting",     "Mark",    "mark@example.com"),
 *                  Arrays.asList("Accounting",     "Mark",    "mark.kish@example.com"),
 *                  Arrays.asList("Accounting",     "Jen",     "jen@example.com"),
 *                  Arrays.asList("IT",             "Fred",    "fred@example.com"),
 *                  Arrays.asList("IT",             "John",    "john@example.com"),
 *                  Arrays.asList("IT",             "John",    "john.doe@example.com"));
 *         
 *         // Root is department name, subobject is person, sub-subobject is email
 *         RelationMapper_1__1&lt;String, String, String&gt;
 *              mapper = new RelationMapper_1__1&lt;&gt;();
 *         for (List&lt;String&gt; row : values) {
 *              // The following 2 lines are optional in this case
 *              mapper.root(row.get(0));
 *              mapper.relate_1(row.get(0), row.get(1));
 *              mapper.relate_1_1(row.get(0), row.get(1), row.get(2));
 *         }
 *         
 *         // Java 8 syntax, works with 7 too
 *         List&lt;Department&gt; result = mapper.&lt;Department&gt;build(Department::new);
 *     }
 * 
 * }
 * </pre>
 * 
 */
package com.relatejava.relate;