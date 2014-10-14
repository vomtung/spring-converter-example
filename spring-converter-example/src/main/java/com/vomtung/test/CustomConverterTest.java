package com.vomtung.test;

import org.springframework.core.convert.converter.Converter;
import org.springframework.core.convert.support.GenericConversionService;

import com.vomtung.converter.ArticleToStringConverter;
import com.vomtung.converter.StringToArticleConverter;
import com.vomtung.entity.Article;
	 
	public class CustomConverterTest {
	 
	    public static void main(String[] args) {
	 
	//      test1();
	        test2();
	        test3();
	    }
	 
	    private static void test1(){
	 
	        GenericConversionService conversionService = new GenericConversionService();
	 
	        Converter<Article, String> customConverter = new ArticleToStringConverter();
	        conversionService.addConverter(customConverter);
	 
	        String result = customConverter.convert(null);
	        System.out.println("Result is " + result);
	    }
	 
	    private static void test2(){
	 
	        GenericConversionService conversionService = new GenericConversionService();
	 
	        Converter<Article, String> customConverter = new ArticleToStringConverter();
	        conversionService.addConverter(customConverter);
	 
	        Article article = new Article("Introduction to Spring Converters", "Core Spring");
	        String result = conversionService.convert(article, String.class);
	        System.out.println("Result is '" + result + "'");
	    }
	 
	    private static void test3(){
	 
	        GenericConversionService conversionService = new GenericConversionService();
	 
	        Converter<String, Article> customConverter = new StringToArticleConverter();
	        conversionService.addConverter(customConverter);
	 
	        String articleAsString = new String(
	            "Introduction to Spring Converters,Core Spring");
	        Article result = conversionService.convert(articleAsString, Article.class);
	        System.out.println("Article name is " + result.getName());
	        System.out.println("Article category is " + result.getCategory());
	    }
	}
