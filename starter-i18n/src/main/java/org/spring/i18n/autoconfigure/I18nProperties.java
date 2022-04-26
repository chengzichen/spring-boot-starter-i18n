package org.spring.i18n.autoconfigure;

import org.spring.i18n.core.I18nOptions;
import org.springframework.boot.context.properties.ConfigurationProperties;

/**
 * @author hccake
 */
@ConfigurationProperties(prefix = "ballcat.i18n")
public class I18nProperties extends I18nOptions {

}
