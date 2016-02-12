package br.com.favoritecollections.conf;

import java.util.concurrent.TimeUnit;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.guava.GuavaCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewResolverRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.velocity.VelocityConfigurer;
import org.springframework.web.servlet.view.velocity.VelocityView;
import org.springframework.web.servlet.view.velocity.VelocityViewResolver;

import com.google.common.cache.CacheBuilder;

@Configuration
@EnableWebMvc
@ComponentScan(basePackages = {"br.com.favoritecollections", "br.com.favoritecollections.gibi.controller"})
@EnableCaching
public class WebAppConfiguration extends WebMvcConfigurerAdapter {
	
	@Bean
	public VelocityConfigurer velocityConfig() {
		VelocityConfigurer velocityConfigurer = new VelocityConfigurer();
		velocityConfigurer.setResourceLoaderPath("/WEB-INF/collections/");
		return velocityConfigurer;
	}
	
	@Override
	public void configureViewResolvers(ViewResolverRegistry registry) {
		VelocityViewResolver viewResolver = new VelocityViewResolver();
		
		viewResolver.setViewClass(VelocityView.class);
		viewResolver.setCache(true);
		viewResolver.setPrefix("");
		viewResolver.setSuffix(".html");
		viewResolver.setExposeSpringMacroHelpers(true);
		
		registry.viewResolver(viewResolver);
	}
	
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler("/resources/**").addResourceLocations("/resources/");
		registry.addResourceHandler("/webjars/**").addResourceLocations("classpath:/META-INF/resources/webjars/");
	}

	@Bean
	public CacheManager cacheManager() {
		CacheBuilder<Object, Object> builder = 
				CacheBuilder.newBuilder()
				.maximumSize(100)
				.expireAfterAccess(5, TimeUnit.MINUTES);
		GuavaCacheManager  cacheManager = new GuavaCacheManager();
		cacheManager.setCacheBuilder(builder);
		return cacheManager;
	}
}
