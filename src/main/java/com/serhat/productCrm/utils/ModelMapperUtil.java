package com.serhat.productCrm.utils;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

//https://www.baeldung.com/java-performance-mapping-frameworks
@Component
public class ModelMapperUtil {
    @Autowired
    private ModelMapper modelMapper;

    public <T,K> T convertToModel(K obje,Class<T> classObject) {
        T convertedObje = modelMapper
                .map(obje, classObject);
        return convertedObje;
    }

    public <D, T> List<D> mapAll(final Collection<T> entityList,
                                 Class<D> outCLass) {
        return entityList.stream()
                .map(entity -> convertToModel(entity, outCLass))
                .collect(Collectors.toList());
    }
}