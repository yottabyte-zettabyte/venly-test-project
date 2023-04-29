package com.venly.testproject.config;

import java.util.List;
import org.modelmapper.Converter;
import org.modelmapper.ModelMapper;
import org.modelmapper.PropertyMap;
import org.modelmapper.config.Configuration.AccessLevel;
import org.modelmapper.convention.NamingConventions;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MapperConfig {

    @Bean
    public ModelMapper modelMapper(List<Converter<?, ?>> converters, List<PropertyMap<?, ?>> propertyMaps) {
        ModelMapper mapper = new ModelMapper();
        mapper.getConfiguration()
                .setSkipNullEnabled(true)
                .setFieldMatchingEnabled(true)
                .setFieldAccessLevel(AccessLevel.PROTECTED)
                .setSourceNamingConvention(NamingConventions.NONE);

        converters.forEach(mapper::addConverter);
        propertyMaps.forEach(mapper::addMappings);

        mapper.validate();
        return mapper;
    }
}
