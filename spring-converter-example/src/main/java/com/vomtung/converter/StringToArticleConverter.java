package com.vomtung.converter;

import org.springframework.core.convert.ConversionFailedException;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.core.convert.converter.Converter;

import com.vomtung.entity.Article;
	 
public class StringToArticleConverter implements Converter<String, Article> {

	@Override
	public Article convert(String articleAsString) {

		if (articleAsString == null) {
			throw new ConversionFailedException(
					TypeDescriptor.valueOf(String.class),
					TypeDescriptor.valueOf(String.class), articleAsString, null);
		}

		String[] tempArray = articleAsString.split(",");
		Article article = new Article(tempArray[0], tempArray[1]);
		return article;
	}

}
