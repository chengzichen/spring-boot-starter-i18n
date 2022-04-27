package org.spring.i18n.api;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.springframework.core.annotation.AliasFor;

/**
 * 用于标注在需要国际化的 String 类型的属性上，用于标记其需要国际化。 必须在拥有 {@link I18nClass} 注解标记的类上
 * @author hccake
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface I18nField {

	/**
	 * <p>
	 * This is an alias for {@link #code}
	 * </p>
	 * @return String
	 */
	@AliasFor("code")
	String value() default "";

	/**
	 * 国际化的唯一标识, 当不传值时，则使用被标注的元素的值作为 code
	 * @return String
	 */
	@AliasFor("value")
	String code() default "";


	/**
	 * 指定国际化的唯一标识属性, 当不传值时，则使用被标注的元素的值作为 code
	 * @return String
	 */
	@AliasFor("codeProperty")
	String codeProperty() default "";

	/**
	 * 是否进行国际化的条件判断语句（SpEL 表达式），默认未 “”，表示永远翻译
	 * @return 返回 boolean 的 SpEL 表达式
	 */
	String condition() default "";



	/**
	 * 为了方便使用id作为code重复添加一个前缀 prefix
	 * @return String
	 */
	String prefix() default "";

}
