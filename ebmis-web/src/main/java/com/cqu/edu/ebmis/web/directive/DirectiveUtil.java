/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.directive;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.runtime.parser.node.SimpleNode;

import com.cqu.edu.ebmis.web.directive.OverrideDirective.OverrideNodeWrapper;

/**
 * 
 * @author mxl
 * @version $ DirectiveUtil.java v1.0, 2017年4月25日 下午7:04:30 mxl Exp $
 */
public class DirectiveUtil {
	
	static String	BLOCK					= "__vm_override__";
	
	static String	OVERRIDE_CURRENT_NODE	= "__vm_current_override_node__";
	
	static String getOverrideVariableName(String name) {
	
		return BLOCK + name;
	}
	
	static String getRequiredArgument(InternalContextAdapter context,
			Node node, int argumentIndex, String directive)
			throws ParseErrorException {
	
		SimpleNode sn_value = (SimpleNode) node.jjtGetChild(argumentIndex);
		if (sn_value == null) {
			throw new ParseErrorException(
					"required argument is null with directive:#" + directive
							+ "(),argumentIndex=" + argumentIndex);
		}
		
		String value = (String) sn_value.value(context);
		if (value == null) {
			throw new ParseErrorException(
					"required argument is null with directive:#" + directive
							+ "(),argumentIndex=" + argumentIndex);
		}
		return value;
	}
	
	public static void setParentForTop(OverrideNodeWrapper topParentNode,
			OverrideNodeWrapper node) {
	
		OverrideNodeWrapper top = node;
		while (top.parentNode != null) {
			top = top.parentNode;
		}
		top.parentNode = topParentNode;
	}
}
