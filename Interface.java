<#if package?? && package != "">
package ${package};

</#if>
<#if superclass?? && superclass != "" && !superclass?starts_with("java.lang") && !superclass?matches(package + "\\.\\w+")>
import ${superclass};

</#if>
<#if superclass?? && superclass != "">
    <#assign extension = "${superclass}"[("${superclass}"?last_index_of(".") + 1)..]>
</#if>
public interface ${name}<#if extension?? && extension != ""> extends ${extension}</#if> {

}