package com.can.bi.utils;

import com.alibaba.excel.EasyExcel;
import com.alibaba.excel.support.ExcelTypeEnum;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.IntStream;

/**
 * @Author: Yang Hengcan
 * @Date: 2024/1/14 15:22
 * @Description:
 */
@Slf4j
public class ExcelUtils {

    /**
     * excel 转 csv
     *
     * @param multipartFile
     * @return
     */
    public static String excelToCsv(MultipartFile multipartFile) {
//        File file = null;
//        try {
//            file = ResourceUtils.getFile("classpath:网站数据.xlsx");
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        }
        // 数据读取
        List<Map<Integer, String>> list = null;
        try {
            list = EasyExcel.read(multipartFile.getInputStream())
                    .excelType(ExcelTypeEnum.XLSX)
                    .sheet()
                    .headRowNumber(0)
                    .doReadSync();
        } catch (IOException e) {
            log.error("表格处理错误: ", e);
        }
        if (CollectionUtils.isEmpty(list)) {
            return "";
        }
        // 转成csv
        StringBuilder stringBuilder = new StringBuilder();
        LinkedHashMap<Integer, String> headerMap = (LinkedHashMap<Integer, String>) list.get(0);
        List<String> headList = headerMap.values().stream().filter(Objects::nonNull).toList();
        stringBuilder.append(StringUtils.join(headList, ",")).append("\n");
        List<Map<Integer, String>> finalList = list;
        IntStream.range(1, list.size()).forEach(i -> {
            LinkedHashMap<Integer, String> dataMap = (LinkedHashMap<Integer, String>) finalList.get(i);
            List<String> dataList = dataMap.values().stream().filter(Objects::nonNull).toList();
            stringBuilder.append(StringUtils.join(dataList, ",")).append("\n");
        });
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        String s = excelToCsv(null);
        System.out.println("s = " + s);
    }
}
