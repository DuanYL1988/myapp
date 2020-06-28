package com.app.tag;

import java.util.List;
import java.util.Map;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.app.jdbc.JdbcConnectUtil;

public class RadioProcessor extends AbstractAttributeTagProcessor {

    private static final String ATTR_NAME = "radioImage";
    private static final String CRLF = "\r\n";

    private static final int PRECEDENCE = 10000;

    /**
     *
     * 一个类相当于一个标签名,在 doProcess定义具体操作<br>
     * 将这个类在CustomizeTagDialect.java中添加使用<br>
     *
     * @param dialectPrefix 标签方言前缀
     *
     * templateMode: 模板模式，这里使用HTML模板。 dialectPrefix: 标签前缀。即xxx:text中的xxx。<br>
     * elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。<br>
     * prefixElementName: 标签名是否要求前缀。 attributeName: 自定义标签属性名。即xxx:yyy中的yyy。<br>
     * prefixAttributeName：属性名是否要求前缀，如果为true，Thymeeleaf会要求使用text属性时必须加上前缀，即xxx:text。<br>
     * precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。 removeAttribute：标签处理后是否移除自定义属性。<br>
     */
    public RadioProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, true);
    }

    /**
     * attributeName:标签属性名
     * attributeValue:页面上标签设定的值
     */
    @Override
    public void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
            String attributeValue, IElementTagStructureHandler structureHandler) {

        JdbcConnectUtil dbUtil = new JdbcConnectUtil();
        String category = "9999";
        if("color".equals(attributeValue)) {
            category = "0003";
        }
        String query = "select CODE_ID,CODE_NAME from feh_content_master where CATEGORY_ID = '"+category+"' order by code_id";
        List<Map<String, String>> resultMap = dbUtil.excuteSelectQuery(query);
        StringBuilder html = new StringBuilder();

        for(Map<String, String> result :resultMap) {
            String id = result.get("CODE_ID");
            String text = result.get("CODE_NAME");
            html.append("<div class=\"custom-radio\">"+CRLF);
            html.append("<input id=\"color"+id+"\" class=\"custom-control-input\" type=\"radio\" th:name=\"hero.color\" name=\"color\">"+CRLF);
            html.append("<label for=\"color"+id+"\" class=\"custom-control-label\">"+text+"</label>"+CRLF);
            html.append("</div>"+CRLF);
        }

        structureHandler.setBody(html.toString(), false);
    }

}
