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

public class OptionsTagProcessor extends AbstractAttributeTagProcessor {

    private static final String ATTR_NAME = "options";

    private static final int PRECEDENCE = 10000;

    JdbcConnectUtil dbUtil = new JdbcConnectUtil();

    /**
     * templateMode: 模板模式，这里使用HTML模板。 dialectPrefix: 标签前缀。即xxx:text中的xxx。<br>
     * elementName：匹配标签元素名。举例来说如果是div，则我们的自定义标签只能用在div标签中。为null能够匹配所有的标签。<br>
     * prefixElementName: 标签名是否要求前缀。 attributeName: 自定义标签属性名。即xxx:yyy中的yyy。<br>
     * prefixAttributeName：属性名是否要求前缀，如果为true，Thymeeleaf会要求使用text属性时必须加上前缀，即xxx:text。<br>
     * precedence：标签处理的优先级，此处使用和Thymeleaf标准方言相同的优先级。
     * removeAttribute：标签处理后是否移除自定义属性。<br>
     */
    public OptionsTagProcessor(final String dialectPrefix) {
        super(TemplateMode.HTML, dialectPrefix, null, false, ATTR_NAME, true, PRECEDENCE, true);
    }

    /**
     * attributeName:标签属性名 attributeValue:页面上标签设定的值
     */
    @Override
    public void doProcess(ITemplateContext context, IProcessableElementTag tag, AttributeName attributeName,
            String attributeValue, IElementTagStructureHandler structureHandler) {

        dbUtil.mode = 1;
        String query = "select CODE_ID,CODE_NAME from HERO_CONTENT where CATEGORY_ID = '" + attributeValue
                + "' and CODE_ID <> '00' order by code_id";
        List<Map<String, String>> resultMap = dbUtil.excuteSelectQuery(query);

        String baseHtml = "<option value='#id#' #selected#>#text#</option>";
        StringBuilder html = new StringBuilder();
        for (Map<String, String> result : resultMap) {
            String row = "";
            String id = result.get("CODE_ID");
            String text = result.get("CODE_NAME");
            String value = tag.getAttributeValue("value");
            row = baseHtml.replace("#id#", id);
            row = row.replace("#text#", text);
            if (text.equals(value) || id.equals(value)) {
                row = row.replace("#selected#", "selected='selected' ");
            }
            html.append(row);
        }

        structureHandler.setBody(html.toString(), false);
    }

}
