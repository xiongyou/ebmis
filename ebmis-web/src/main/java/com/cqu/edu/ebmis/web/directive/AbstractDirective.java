/**
 * xiaolong.mxl @copyRight 2016-2017
 */
package com.cqu.edu.ebmis.web.directive;

import java.io.IOException;
import java.io.Writer;

import org.apache.velocity.context.InternalContextAdapter;
import org.apache.velocity.exception.MethodInvocationException;
import org.apache.velocity.exception.ParseErrorException;
import org.apache.velocity.exception.ResourceNotFoundException;
import org.apache.velocity.runtime.directive.Directive;
import org.apache.velocity.runtime.parser.node.Node;
import org.apache.velocity.tools.view.ViewToolContext;

/**
 * <p>
 * velocity 自定义标签抽象类
 * </p>
 * 
 * @author mxl
 * @version $ AbstractDirective.java v1.0, 2017年4月25日 下午7:00:30 mxl Exp $
 */
public abstract class AbstractDirective extends Directive {
	
	/**
	 * @see org.apache.velocity.runtime.directive.Directive#render(org.apache.velocity.context.InternalContextAdapter,
	 *      java.io.Writer, org.apache.velocity.runtime.parser.node.Node)
	 */
	@Override
	public boolean render(InternalContextAdapter internalContext,
			Writer writer, Node node) throws IOException,
			ResourceNotFoundException, ParseErrorException,
			MethodInvocationException {
	
		ViewToolContext context = (ViewToolContext) internalContext
				.getInternalUserContext();
		return doRender(internalContext , context , writer , node);
	}
	
	protected abstract boolean doRender(InternalContextAdapter internalContext,
			ViewToolContext context, Writer writer, Node node)
			throws IOException, ResourceNotFoundException, ParseErrorException,
			MethodInvocationException;
	
}
