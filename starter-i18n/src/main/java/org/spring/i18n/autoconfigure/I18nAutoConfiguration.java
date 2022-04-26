package org.spring.i18n.autoconfigure;

import org.spring.i18n.core.I18nResponseAdvice;
import org.springframework.boot.autoconfigure.AutoConfigureAfter;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author hccake
 */
@Configuration(proxyBeanMethods = false)
@AutoConfigureAfter(I18nMessageSourceConfiguration.class)
@EnableConfigurationProperties(I18nProperties.class)
public class I18nAutoConfiguration {

	@Bean
	@ConditionalOnMissingBean
	public I18nResponseAdvice i18nResponseAdvice(MessageSource messageSource, I18nProperties i18nProperties) {
		return new I18nResponseAdvice(messageSource, i18nProperties);
	}

}
