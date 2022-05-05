package com.fc.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResultVo {
    private String requestId;
    private String operator;
    private long timestamp;
    private Integer code;
    private String info;
    private Object data;
}
