<@pp.dropOutputFile />
<#list 1..7 as subObjects>
<#assign firstIndependentSubObject = 1>
<#assign numsub1s = subObjects>
<#if (numsub1s > 4)>
    <#assign numsub1s = 4>
</#if>

<#list 0..numsub1s as sub1subObjects>
<#if (sub1subObjects > 0)>
    <#assign firstIndependentSubObject = 2>
</#if>
<#assign numsub2s = sub1subObjects>
<#if (subObjects < 2)>
    <#assign numsub2s = 0>
</#if>

<#list 0..numsub2s as sub2subObjects>
<#if (sub2subObjects > 0)>
    <#assign firstIndependentSubObject = 3>
</#if>
<#assign numsub3s = sub2subObjects>
<#if (subObjects < 3)>
    <#assign numsub3s = 0>
</#if>

<#list 0..numsub3s as sub3subObjects>
<#if (sub3subObjects > 0)>
    <#assign firstIndependentSubObject = 4>
</#if>
<#assign numsub4s = sub3subObjects>
<#if (subObjects < 4)>
    <#assign numsub4s = 0>
</#if>

<#list 0..numsub4s as sub4subObjects>
<#if (sub4subObjects > 0)>
    <#assign firstIndependentSubObject = 5>
</#if>

<#assign className="RelationMapper_" + subObjects>
<#if (sub1subObjects > 0)>
    <#assign className=className + "__" + sub1subObjects>
</#if>
<#if (sub2subObjects > 0)>
    <#assign className=className + "_" + sub2subObjects>
</#if>
<#if (sub3subObjects > 0)>
    <#assign className=className + "_" + sub3subObjects>
</#if>
<#if (sub4subObjects > 0)>
    <#assign className=className + "_" + sub4subObjects>
</#if>
<@pp.changeOutputFile name=className + ".java" />
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
/* This code is auto-generated; do not modify */
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
 * <code>build</code> to obtain the object graphs.
 *
 * @author Ilmo Euro
 * @param <R> The type of the root object
<#list 1..subObjects as subObject>
 * @param <S${subObject}> The type of sub-objects
</#list>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
 * @param <S1S${sub1subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
 * @param <S2S${sub2subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
 * @param <S3S${sub3subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
 * @param <S4S${sub4subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
 */
public class ${className}<
     R
<#list 1..subObjects as subObject>
    ,S${subObject}
</#list>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
    ,S1S${sub1subObject}
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
    ,S2S${sub2subObject}
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
    ,S3S${sub3subObject}
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
    ,S4S${sub4subObject}
</#list>
</#if>
> {

    /**
     * A builder interface for object tree roots.
     * 
     * @param <T> The type of the resulting object tree.
     * @param <R> The type of the root object.
<#list 1..subObjects as subObject>
     * @param <S${subObject}> The type of sub-objects.
</#list>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
     * @param <S1S${sub1subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
     * @param <S2S${sub2subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
     * @param <S3S${sub3subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
     * @param <S4S${sub4subObject}> The type of sub-objects of sub-objects.
</#list>
</#if>
     */
    public interface CompositeFactory<
         T
        ,R
<#list 1..subObjects as subObject>
        ,S${subObject}
</#list>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
        ,S1S${sub1subObject}
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
        ,S2S${sub2subObject}
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
        ,S3S${sub3subObject}
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
        ,S4S${sub4subObject}
</#list>
</#if>
    > {
        T build(
             R root
<#if (firstIndependentSubObject <= subObjects)>
<#list firstIndependentSubObject..subObjects as subObject>
            ,Set<S${subObject}> subObject${subObject}s
</#list>
</#if>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
            ,Map<S1, Set<S1S${sub1subObject}>> sub1subObject${sub1subObject}s
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
            ,Map<S2, Set<S2S${sub2subObject}>> sub2subObject${sub2subObject}s
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
            ,Map<S3, Set<S3S${sub3subObject}>> sub3subObject${sub3subObject}s
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
            ,Map<S4, Set<S4S${sub4subObject}>> sub4subObject${sub4subObject}s
</#list>
</#if>
        );
    }
    
    private final Set<R>
        roots = new LinkedHashSet<>();
<#if (firstIndependentSubObject <= subObjects)>
<#list firstIndependentSubObject..subObjects as subObject>
    private final Map<R, Set<S${subObject}>>
        sub${subObject}s = new LinkedHashMap<>();
</#list>
</#if>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
    private final Map<R, Map<S1, Set<S1S${sub1subObject}>>>
        sub1sub${sub1subObject}s = new LinkedHashMap<>();
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
    private final Map<R, Map<S2, Set<S2S${sub2subObject}>>>
        sub2sub${sub2subObject}s = new LinkedHashMap<>();
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
    private final Map<R, Map<S3, Set<S3S${sub3subObject}>>>
        sub3sub${sub3subObject}s = new LinkedHashMap<>();
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
    private final Map<R, Map<S4, Set<S4S${sub4subObject}>>>
        sub4sub${sub4subObject}s = new LinkedHashMap<>();
</#list>
</#if>

    /**
     * Add a root object to the object graph.
     * 
     * @param root The root object to add.
     */
    public void root(R root) {
        roots.add(root);
    }

<#list 1..subObjects as subObject>
    /** Add a relation between a root object and a sub-object.
     * 
     * @param root The root object to relate to.
     * @param sub${subObject} The related sub-object.
     */
    public void relate_${subObject}(R root, S${subObject} sub${subObject}) {
        root(root);
<#if (subObject < firstIndependentSubObject)>
    <#if (subObject == 1)>
        <#list 1..sub1subObjects as subsubObject>
        sub${subObject}sub${subsubObject}s.putIfAbsent(
            root,
            new LinkedHashMap<S${subObject}, Set<S${subObject}S${subsubObject}>>());
        sub${subObject}sub${subsubObject}s.get(root).putIfAbsent(
            sub${subObject},
            new LinkedHashSet<S${subObject}S${subsubObject}>());
        </#list>
    <#elseif (subObject == 2)>
        <#list 1..sub2subObjects as subsubObject>
        sub${subObject}sub${subsubObject}s.putIfAbsent(
            root,
            new LinkedHashMap<S${subObject}, Set<S${subObject}S${subsubObject}>>());
        sub${subObject}sub${subsubObject}s.get(root).putIfAbsent(
            sub${subObject},
            new LinkedHashSet<S${subObject}S${subsubObject}>());
        </#list>
    <#elseif (subObject == 3)>
        <#list 1..sub3subObjects as subsubObject>
        sub${subObject}sub${subsubObject}s.putIfAbsent(
            root,
            new LinkedHashMap<S${subObject}, Set<S${subObject}S${subsubObject}>>());
        sub${subObject}sub${subsubObject}s.get(root).putIfAbsent(
            sub${subObject},
            new LinkedHashSet<S${subObject}S${subsubObject}>());
        </#list>
    <#elseif (subObject == 4)>
        <#list 1..sub4subObjects as subsubObject>
        sub${subObject}sub${subsubObject}s.putIfAbsent(
            root,
            new LinkedHashMap<S${subObject}, Set<S${subObject}S${subsubObject}>>());
        sub${subObject}sub${subsubObject}s.get(root).putIfAbsent(
            sub${subObject},
            new LinkedHashSet<S${subObject}S${subsubObject}>());
        </#list>
    </#if>
<#else>
        sub${subObject}s.putIfAbsent(root, new LinkedHashSet<S${subObject}>());
        sub${subObject}s.get(root).add(sub${subObject});
</#if>
    }

</#list>

<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
    /** Add a relation between a sub-object and a sub-sub-object.
     * 
     * @param root The root object to relate to.
     * @param sub1 The sub-object to relate to.
     * @param sub1sub${sub1subObject} The related sub-sub-object.
     */
    public void relate_1_${sub1subObject}(
             R root
            ,S1 sub1
            ,S1S${sub1subObject} sub1sub${sub1subObject}) {
        root(root);
        sub1sub${sub1subObject}s.putIfAbsent(
             root
            ,new LinkedHashMap<S1, Set<S1S${sub1subObject}>>());
        sub1sub${sub1subObject}s.get(root).putIfAbsent(
             sub1
            ,new LinkedHashSet<S1S${sub1subObject}>());
        sub1sub${sub1subObject}s.get(root).get(sub1).add(
             sub1sub${sub1subObject});
    }

</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
    /** Add a relation between a sub-object and a sub-sub-object.
     * 
     * @param root The root object to relate to.
     * @param sub2 The sub-object to relate to.
     * @param sub2sub${sub2subObject} The related sub-sub-object.
     */
    public void relate_2_${sub2subObject}(
             R root
            ,S2 sub2
            ,S2S${sub2subObject} sub2sub${sub2subObject}) {
        root(root);
        sub2sub${sub2subObject}s.putIfAbsent(
             root
            ,new LinkedHashMap<S2, Set<S2S${sub2subObject}>>());
        sub2sub${sub2subObject}s.get(root).putIfAbsent(
             sub2
            ,new LinkedHashSet<S2S${sub2subObject}>());
        sub2sub${sub2subObject}s.get(root).get(sub2).add(
             sub2sub${sub2subObject});
    }

</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
    /** Add a relation between a sub-object and a sub-sub-object.
     * 
     * @param root The root object to relate to.
     * @param sub3 The sub-object to relate to.
     * @param sub3sub${sub3subObject} The related sub-sub-object.
     */
    public void relate_3_${sub3subObject}(
             R root
            ,S3 sub3
            ,S3S${sub3subObject} sub3sub${sub3subObject}) {
        root(root);
        sub3sub${sub3subObject}s.putIfAbsent(
             root
            ,new LinkedHashMap<S3, Set<S3S${sub3subObject}>>());
        sub3sub${sub3subObject}s.get(root).putIfAbsent(
             sub3
            ,new LinkedHashSet<S3S${sub3subObject}>());
        sub3sub${sub3subObject}s.get(root).get(sub3).add(
             sub3sub${sub3subObject});
    }

</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
    /** Add a relation between a sub-object and a sub-sub-object.
     * 
     * @param root The root object to relate to.
     * @param sub4 The sub-object to relate to.
     * @param sub4sub${sub4subObject} The related sub-sub-object.
     */
    public void relate_4_${sub4subObject}(
             R root
            ,S4 sub4
            ,S4S${sub4subObject} sub4sub${sub4subObject}) {
        root(root);
        sub4sub${sub4subObject}s.putIfAbsent(
             root
            ,new LinkedHashMap<S4, Set<S4S${sub4subObject}>>());
        sub4sub${sub4subObject}s.get(root).putIfAbsent(
             sub4
            ,new LinkedHashSet<S4S${sub4subObject}>());
        sub4sub${sub4subObject}s.get(root).get(sub4).add(
             sub4sub${sub4subObject});
    }

</#list>
</#if>

    /** Build the object graphs out of previously added relations.
     * The resulting <code>Set</code>s and <code>Map</code>s have their elements
     * in the <b>same order</b> as defined with <code>relate_*</code>.
     * 
     * @param <T> The type of the resulting object graph.
     * @param factory The factory object that builds the object graph.
     * @return The object graphs.
     */
    public <T> List<T> build(
        CompositeFactory<
             T
            ,R
<#list 1..subObjects as subObject>
            ,S${subObject}
</#list>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
            ,S1S${sub1subObject}
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
            ,S2S${sub2subObject}
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
            ,S3S${sub3subObject}
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
            ,S4S${sub4subObject}
</#list>
</#if>
        > factory) {
        final ArrayList<T> result = new ArrayList<>();
        for (R r : roots) {
            result.add(factory.build(
                 r
<#if (firstIndependentSubObject <= subObjects)>
<#list firstIndependentSubObject..subObjects as subObject>
                ,sub${subObject}s.get(r)
</#list>
</#if>
<#if (sub1subObjects > 0) >
<#list 1..sub1subObjects as sub1subObject>
                ,sub1sub${sub1subObject}s.get(r)
</#list>
</#if>
<#if (sub2subObjects > 0) >
<#list 1..sub2subObjects as sub2subObject>
                ,sub2sub${sub2subObject}s.get(r)
</#list>
</#if>
<#if (sub3subObjects > 0) >
<#list 1..sub3subObjects as sub3subObject>
                ,sub3sub${sub3subObject}s.get(r)
</#list>
</#if>
<#if (sub4subObjects > 0) >
<#list 1..sub4subObjects as sub4subObject>
                ,sub4sub${sub4subObject}s.get(r)
</#list>
</#if>
            ));
        }
        return result;
    }
}

</#list>
</#list>
</#list>
</#list>
</#list>