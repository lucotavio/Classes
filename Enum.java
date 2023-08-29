<#if package?? && package != "">
package ${package};

</#if>
<#if interfaces?? && interfaces != "">
    <#list "${interfaces}"?split("\n") as interface>
        <#if interface?? && interface != "" && !interface?starts_with("java.lang") && !interface?matches(package + "\\.\\w+")>
import ${interface};
        </#if>
    </#list>

</#if>
<#if interfaces?? && interfaces != "">
    <#assign implementation = "">
    <#list "${interfaces}"?split("\n") as interface>
        <#assign implementation += "${interface}"[("${interface}"?last_index_of(".") + 1)..] + ", ">
    </#list>
    <#assign implementation = "${implementation}"?remove_ending(", ")>
</#if>
public enum ${name}<#if implementation?? && implementation != ""> implements ${implementation}</#if> {

}