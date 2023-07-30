package com.wenzh.sqlGenerateTool.core.generator;

import com.wenzh.sqlGenerateTool.core.model.enums.MockParamsRandomTypeEnum;
import com.wenzh.sqlGenerateTool.core.schema.TableSchema;
import com.wenzh.sqlGenerateTool.core.utils.FakerUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

/**
 * 随机值数据生成器
 *
 * @author wenzhou
 */
public class RandomDataGenerator implements DataGenerator {

    @Override
    public List<String> doGenerate(TableSchema.Field field, int rowNum) {
        String mockParams = field.getMockParams();
        List<String> list = new ArrayList<>(rowNum);
        for (int i = 0; i < rowNum; i++) {
            MockParamsRandomTypeEnum randomTypeEnum = Optional.ofNullable(
                            MockParamsRandomTypeEnum.getEnumByValue(mockParams))
                    .orElse(MockParamsRandomTypeEnum.STRING);
            String randomString = FakerUtils.getRandomValue(randomTypeEnum);
            list.add(randomString);
        }
        return list;
    }
}
