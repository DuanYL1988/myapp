package com.app.tag;

import java.util.List;
import java.util.Map;

import org.thymeleaf.context.ITemplateContext;
import org.thymeleaf.engine.AttributeName;
import org.thymeleaf.model.IProcessableElementTag;
import org.thymeleaf.processor.element.AbstractAttributeTagProcessor;
import org.thymeleaf.processor.element.IElementTagStructureHandler;
import org.thymeleaf.templatemode.TemplateMode;

import com.app.common.CommonContent;
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
     *                      templateMode: 模板模式，这里使用HTML模板。 dialectPrefix:
     *                      标签前缀。即xxx:text中的xxx。<br>
     *                      elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。<br>
     *                      prefixElementName: 标签名是否要求前缀。 attributeName:
     *                      自定义标签属性名。即xxx:yyy中的yyy。<br>
     *                      prefixAttributeName：属性名是否要求前缀，如果为true，Thymeeleaf会要求使用text属性时必须加上前缀，即xxx:text。<br>
     *                      precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。
     *                      removeAttribute：标签处理后是否移除自定义属性。<br>
     */
    public RadioProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, true);
    }

    /**
     * attributeName:标签属性名 attributeValue:页面上标签设定的值
     */
    @Override
    public void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
            String attributeValue, IElementTagStructureHandler structureHandler) {

        JdbcConnectUtil dbUtil = new JdbcConnectUtil();
        dbUtil.mode = 1;
        String name = CommonContent.getMapping(attributeValue);
        String value = tag.getAttributeValue("value");

        String query = "select CODE_ID,IMG_SRC from HERO_CONTENT where CATEGORY_ID = '" + attributeValue
                + "' order by code_id";

        List<Map<String, String>> resultMap = dbUtil.excuteSelectQuery(query);
        StringBuilder html = new StringBuilder();

        for (Map<String, String> result : resultMap) {
            String id = result.get("CODE_ID");
            String text = CommonContent.IMG_MYAPP_FEH + result.get("IMG_SRC");
            text = "<img src=\"" + text + "\"></img>";
            html.append("<div class=\"custom-control custom-radio\">" + CRLF);
            html.append("<input id=\"" + name + id + "\" class=\"custom-control-input\" type=\"radio\" value=\"" + id
                    + "\" name=\"hero." + name + "\" ");
            if (id.equals(value)) {
                html.append(" checked " + CRLF);
            }
            html.append(" required>" + CRLF);
            html.append("<label for=\"" + name + id + "\" class=\"custom-control-label\" style='margin-left:25px' >"
                    + text + "</label>" + CRLF);
            html.append("</div>" + CRLF);
        }

        structureHandler.setBody(html.toString(), false);
    }

}
