package org.spring.i18n.autoconfigure;

import org.spring.i18n.core.DynamicMessageSource;
import org.spring.i18n.core.I18nMessageProvider;
import org.spring.i18n.core.MessageSourceHierarchicalChanger;
import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.support.AbstractApplicationContext;

/**
 * @author hccake
 */
@Configuration(proxyBeanMethods = false)
@Import(CustomMessageSourceAutoConfiguration.class)
public class I18nMessageSourceConfiguration {

	@ConditionalOnBean(I18nMessageProvider.class)
	@ConditionalOnMissingBean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
	@Bean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME)
	public DynamicMessageSource messageSource(I18nMessageProvider i18nMessageProvider) {
		return new DynamicMessageSource(i18nMessageProvider);
	}

	@ConditionalOnBean(name = AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME, value = I18nMessageProvider.class)
	@Bean(name = DynamicMessageSource.DYNAMIC_MESSAGE_SOURCE_BEAN_NAME)
	public DynamicMessageSource dynamicMessageSource(I18nMessageProvider i18nMessageProvider) {
		return new DynamicMessageSource(i18nMessageProvider);
	}

	@ConditionalOnBean(name = { AbstractApplicationContext.MESSAGE_SOURCE_BEAN_NAME,
			DynamicMessageSource.DYNAMIC_MESSAGE_SOURCE_BEAN_NAME })
	@Bean
	public MessageSourceHierarchicalChanger messageSourceHierarchicalChanger() {
		return new MessageSourceHierarchicalChanger();
	}

}
