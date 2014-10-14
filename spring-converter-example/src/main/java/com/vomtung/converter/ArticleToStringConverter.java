package com.vomtung.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.vomtung.entity.Article;

public class ArticleToStringConverter implements Converter<Article, String> {

	@Override
	public String convert(Article article) {

		if (article == null) {
			throw new ConversionFailedException(
					TypeDescriptor.valueOf(Article.class),
					TypeDescriptor.valueOf(String.class), article, null);
		}

		StringBuilder builder = new StringBuilder();
		builder.append(article.getName());
		builder.append("-");
		builder.append(article.getCategory());
		return builder.toString();
	}

}
