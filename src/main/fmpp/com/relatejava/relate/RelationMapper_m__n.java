<@pp.dropOutputFile />
<#assign level1s = 1..4> 
<#assign level2s = 1..4> 
<#list level1s as level1>
<#list level2s as level2>
<@pp.changeOutputFile name="RelationMapper_" + level1 + "__" + level2 + ".java" />
/* 
 * Copyright (C) 2015 Ilmo Euro
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package com.relatejava.relate;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * A class that maps relational data to object trees. Use <code>root</code>
 * to set up roots, <code>relate_*</code> to set up relations, and
 * <code>build</code> to obtain the object graph.
 *
 * @author Ilmo Euro
 * @param <R> The type of the root object
<#list 1..level1 as s1>
 * @param <S${s1}> The type of sub-objects
</#list>
<#list 1..level2 as s2>
 * @param <S1S${s2}> The type of sub-sub-objects
</#list>
 */
public class RelationMapper_${level1}__${level2}
<R,
<#list 1..level1 as s1>
S${s1},
</#list>
<#if (level2 > 1) >
    <#list 1..(level2 - 1) as s2>
S1S${s2},
    </#list>
</#if>
S1S${level2}
> {

    /**
     * A builder interface for object tree roots.
     * @param <T> The type of the resulting object tree
     * @param <R> The type of the root object
    <#list 1..level1 as s1>
     * @param <S${s1}> The type of sub-objects
    </#list>
    <#list 1..level2 as s2>
     * @param <S1S${s2}> The type of sub-sub-objects
    </#list>
     */
    public interface CompositeFactory<T, R,
<#list 1..level1 as s1>
S${s1},
</#list>
<#if (level2 > 1) >
    <#list 1..(level2 - 1) as s2>
S1S${s2},
    </#list>
</#if>
S1S${level2}
    > {
        T build(R root,
<#list 1..level1 as s1>
Set<S${s1}> sub${s1},
</#list>
<#if (level2 > 1) >
    <#list 1..(level2 - 1) as s2>
Map<S1, Set<S1S${s2}>> sub1sub${s2},
    </#list>
</#if>
Map<S1, Set<S1S${level2}>> sub1sub${level2});
    }
    
    private final Set<R> roots = new LinkedHashSet<>();
<#list 1..level1 as s1>
    private final Map<R, Set<S${s1}>> sub${s1}s = new LinkedHashMap<>();
</#list>
<#list 1..level2 as s2>
    private final Map<Tuple2<R, S1>, Set<S1S${s2}>> sub1sub${s2}s = new LinkedHashMap<>();
</#list>

<#list 1..level2 as s2>
    private Map<S1, Set<S1S${s2}>> getMap${s2}(R root) {
        final LinkedHashMap<S1, Set<S1S${s2}>> result = new LinkedHashMap<>();

        for (S1 s1 : sub1s.get(root)) {
            result.put(
                s1,
                sub1sub${s2}s.get(new Tuple2<>(root, s1)));
        }

        return result;
    }
</#list>

    /**
     * Add a root object to the object graph.
     * 
     * @param root The root object to add
     */
    public void root(R root) {
        roots.add(root);
    }

<#list 1..level1 as s1>
    /** Add a relation between a root object and a sub-object
     * 
     * @param root The root object to relate to
     * @param sub${s1} The related sub-object
     */
    public void relate_${s1}(R root, S${s1} sub${s1}) {
        sub${s1}s.putIfAbsent(root, new LinkedHashSet<S${s1}>());
        sub${s1}s.get(root).add(sub${s1});
    }

</#list>

<#list 1..level2 as s2>
    /** Add a relation between a sub-object and a sub-sub-object
     * 
     * @param root The root object to relate to
     * @param sub1 The sub-object to relate to
     * @param sub1sub${s2} The related sub-sub-object
     */
    public void relate_1_${s2}(R root, S1 sub1, S1S${s2} sub1sub${s2}) {
        Tuple2<R, S1> tuple = new Tuple2<>(root, sub1);
        sub1sub${s2}s.putIfAbsent(tuple, new LinkedHashSet<S1S${s2}>());
        sub1sub${s2}s.get(tuple).add(sub1sub${s2});
    }

</#list>

    public <T> List<T> build(
CompositeFactory<T, R, 
<#list 1..level1 as s1>
S${s1},
</#list>
<#if (level2 > 1) >
    <#list 1..(level2 - 1) as s2>
S1S${s2},
    </#list>
</#if>
S1S${level2}>
factory) {
        final ArrayList<T> result = new ArrayList<>();
        for (R r : roots) {
            result.add(factory.build(r,
<#list 1..level1 as s1>
sub${s1}s.get(r),
</#list>
<#if (level2 > 1) >
    <#list 1..(level2 - 1) as s2>
getMap${s2}(r),
    </#list>
</#if>
getMap${level2}(r)
));
        }
        return result;
    }
}

</#list>
</#list>