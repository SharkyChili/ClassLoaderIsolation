package org.wayne.util;


import org.wayne.enums.EnvEnum;

import java.io.File;
import java.util.Arrays;
import java.util.stream.Collectors;

public class ClassLoaderUtil {

    public static String getRelativePath(EnvEnum envEnum){
        String[] strings = {
                "target",
                envEnum.toString(),
                envEnum.toString() + "_Driver_WithDenpendency.jar"
        };
        String collect = Arrays.stream(strings)
                .collect(Collectors.joining(File.separator));
        return collect;
    }

}
