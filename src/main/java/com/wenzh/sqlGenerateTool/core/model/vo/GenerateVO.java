package com.wenzh.sqlGenerateTool.core.model.vo;

import com.wenzh.sqlGenerateTool.core.schema.TableSchema;
import java.io.Serializable;
import java.util.List;
import java.util.Map;
import lombok.Data;

/**
 * 生成的返回值
 *
 * @author wenzhou
 */
@Data
public class GenerateVO implements Serializable {

    /**
     * 表概要
     */
    private TableSchema tableSchema;

    /**
     * 建表语句
     */
    private String createSql;

    /**
     * 模拟数据列表
     */
    private List<Map<String, Object>> dataList;

    /**
     * 插入语句
     */
    private String insertSql;

    /**
     * 模拟数据的 JSON 格式
     */
    private String dataJson;

    /**
     * Java 实体代码
     */
    private String javaEntityCode;

    /**
     * Java 对象代码
     */
    private String javaObjectCode;

    /**
     *  typescript代码，前端代码
     */
    private String typescriptTypeCode;

    private static final long serialVersionUID = 7122637163626243606L;
}
