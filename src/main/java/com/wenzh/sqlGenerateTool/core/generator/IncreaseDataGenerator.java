package com.wenzh.sqlGenerateTool.core.generator;

import com.wenzh.sqlGenerateTool.core.schema.TableSchema;

import java.util.ArrayList;
import java.util.List;
import org.apache.commons.lang3.StringUtils;

/**
 * 递增值数据生成器
 *
 * @author wenzhou
 */
public class IncreaseDataGenerator implements DataGenerator {

    @Override
    public List<String> doGenerate(TableSchema.Field field, int rowNum) {
        String mockParams = field.getMockParams();
        List<String> list = new ArrayList<>(rowNum);
        if (StringUtils.isBlank(mockParams)) {
            mockParams = "1";
        }
        int initValue = Integer.parseInt(mockParams);
        for (int i = 0; i < rowNum; i++) {
            list.add(String.valueOf(initValue + i));
        }
        return list;
    }
}
