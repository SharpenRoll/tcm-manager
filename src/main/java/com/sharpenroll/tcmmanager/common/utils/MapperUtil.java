package com.sharpenroll.tcmmanager.common.utils;

import com.github.dozermapper.core.DozerBeanMapperBuilder;
import com.github.dozermapper.core.Mapper;

import java.util.List;
import java.util.stream.Collectors;

public class MapperUtil {

    private static final Mapper mapper = DozerBeanMapperBuilder.buildDefault();

    public static <T> List<T> mapList(List<?> originList, Class<T> targetClass) {
        return originList.stream()
                .map(originObj -> mapper.map(originObj, targetClass))
                .collect(Collectors.toList());
    }

    public static <T> T map(Object originObj, Class<T> targetClass) {
        return mapper.map(originObj, targetClass);
    }

}
