package com.lqs.hrm.config;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;

import com.alibaba.fastjson.serializer.SerializerFeature;
import com.alibaba.fastjson.support.config.FastJsonConfig;
import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;

/**
 * 配置fastjson处理null值
 * @author Administrator
 *
 */
@Configuration
public class FastJsonConfiguration extends WebMvcConfigurationSupport{
	
	@Override
	protected void configureMessageConverters(List<HttpMessageConverter<?>> converters) {
		FastJsonHttpMessageConverter converter = new FastJsonHttpMessageConverter();
		FastJsonConfig config = new FastJsonConfig();
		config.setSerializerFeatures(
				//保留Map空的字段
				SerializerFeature.WriteMapNullValue,
				//将String类型的null转换成""
				SerializerFeature.WriteNullStringAsEmpty,
				//将 Number类型的 null 转成 0
                SerializerFeature.WriteNullNumberAsZero,
                //将 List 类型的 null 转成 []
                SerializerFeature.WriteNullListAsEmpty,
                //将 Boolean 类型的 null 转成 false
                SerializerFeature.WriteNullBooleanAsFalse,
                //避免循环引用
                SerializerFeature.DisableCircularReferenceDetect
                );
		converter.setFastJsonConfig(config);
		converter.setDefaultCharset(Charset.forName("UTF-8"));
		List<MediaType> mediaTypeList = new ArrayList<>();
		// 解决中文乱码问题，相当于在 Controller 上的 @RequestMapping 中加了个属性 produces = "application/json"
        mediaTypeList.add(MediaType.APPLICATION_JSON);
        converter.setSupportedMediaTypes(mediaTypeList);
        converters.add(converter);
	}
}
