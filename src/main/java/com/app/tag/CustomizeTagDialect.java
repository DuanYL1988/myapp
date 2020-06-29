package com.app.tag;

import java.util.HashSet;
import java.util.Set;

import org.thymeleaf.dialect.AbstractProcessorDialect;
import org.thymeleaf.processor.IProcessor;
import org.thymeleaf.standard.StandardDialect;

public class CustomizeTagDialect extends AbstractProcessorDialect{
    /* 方言名称 */
    private static final String DIALECT_NAME = "Dyl Dialect";

    /* 前缀 */
    private static final String DIALECT_PREFIX = "dyl";

    public CustomizeTagDialect() {
        super(DIALECT_NAME, DIALECT_PREFIX , StandardDialect.PROCESSOR_PRECEDENCE);
    }

    @Override
    public Set<IProcessor> getProcessors(String dialectPrefix) {
        final Set<IProcessor> processors = new HashSet<IProcessor>();
        processors.add(new OptionsTagProcessor(dialectPrefix));
        processors.add(new RadioProcessor(dialectPrefix));
        processors.add(new CheckboxProcessor(dialectPrefix));
        return processors;
    }
}
