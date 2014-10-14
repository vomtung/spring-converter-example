package com.vomtung.test;

import java.util.List;

import org.springframework.core.convert.support.ConversionServiceFactory;
import org.springframework.core.convert.support.DefaultConversionService;
import org.springframework.core.convert.support.GenericConversionService;

import com.vomtung.converter.StringToArticleConverter;
import com.vomtung.entity.Article;


	public class BuiltInForArrayTypeTest {
			 
			    public static void main(String[] args) {
			 
			        GenericConversionService conversionService = new DefaultConversionService();
			 
			        testToCollection(conversionService);
			        testToString(conversionService);
			        testToObject(conversionService);
			    }
			 
			    private static void testToCollection (GenericConversionService conversionService){
			 
			        @SuppressWarnings("unchecked")
			        List<String> listOfColors = conversionService.convert(
			            new String[]{"Red","Blue","Green"}, List.class);
			        for (String color : listOfColors){
			            System.out.println("Color is " + color);
			        }
			    }
			 
			    private static void testToString(GenericConversionService conversionService){
			 
			        String colors = conversionService.convert(
			            new String[]{"Red","Blue","Green"}, String.class);
			        System.out.println("Colors is " + colors);
			    }
			 
			    private static void testToObject(GenericConversionService conversionService){
			 
			        conversionService.addConverter(new StringToArticleConverter());
		
			        Article article = conversionService.convert(
			            new String[]{"Introduction to Google Guice,Google Guice"}, Article.class);
			        System.out.println("Article name is " + article.getName());
			        System.out.println("Article category is " + article.getCategory());
			    }
			 
		}
