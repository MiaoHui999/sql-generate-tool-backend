package com.wenzh.sqlGenerateTool.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.wenzh.sqlGenerateTool.common.ErrorCode;
import com.wenzh.sqlGenerateTool.exception.BusinessException;
import com.wenzh.sqlGenerateTool.mapper.ReportMapper;
import com.wenzh.sqlGenerateTool.model.entity.Report;
import com.wenzh.sqlGenerateTool.model.enums.ReportStatusEnum;
import com.wenzh.sqlGenerateTool.service.ReportService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Service;

/**
 *
 * @author wenzhou
 * @description 针对表【report(举报)】的数据库操作Service实现
 */
@Service
public class ReportServiceImpl extends ServiceImpl<ReportMapper, Report> implements ReportService {

    /**
     * 校验举报内容
     * @param report
     * @param add
     */
    @Override
    public void validReport(Report report, boolean add) {
        if (report == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR);
        }
        String content = report.getContent();
        Long reportedId = report.getReportedId();
        Integer status = report.getStatus();
        if (StringUtils.isNotBlank(content) && content.length() > 1024) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "内容过长");
        }
        // 创建时必须指定
        if (add) {
            if (reportedId == null || reportedId <= 0) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        } else {
            if (status != null && !ReportStatusEnum.getValues().contains(status)) {
                throw new BusinessException(ErrorCode.PARAMS_ERROR);
            }
        }
    }
}




