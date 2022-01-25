package cn.itlemon.best.arthas.http.config;

import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;

import com.fasterxml.jackson.databind.ObjectMapper;

import cn.itlemon.best.arthas.http.serializer.CustomizeNullJsonSerializer;
import cn.itlemon.best.arthas.http.serializer.CustomizeSerializerModifier;

/**
 * 自定义Jackson相关配置
 *
 * @author itlemon <lemon_jiang@aliyun.com>
 * Created on 2022-01-25
 */
@Configuration
public class JacksonConfig {

    @Bean
    @Primary
    @ConditionalOnMissingBean(ObjectMapper.class)
    public ObjectMapper objectMapper(Jackson2ObjectMapperBuilder builder) {
        ObjectMapper objectMapper = builder.createXmlMapper(false).build();
        // 为objectMapper注册一个带有SerializerModifier的Factory
        objectMapper.setSerializerFactory(objectMapper.getSerializerFactory()
                .withSerializerModifier(new CustomizeSerializerModifier()));

        objectMapper.getSerializerProvider().setNullValueSerializer(new CustomizeNullJsonSerializer
                .NullObjectJsonSerializer());
        return objectMapper;
    }


}
