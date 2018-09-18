package com.xyz.portal.exception.handler;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

@Data
@ToString
@AllArgsConstructor
public class ExceptionResponse {
    private long code;
    private String message;
}
