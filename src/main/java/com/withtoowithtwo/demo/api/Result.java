package com.withtoowithtwo.demo.api;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
class Result<T> {
    private T data;
}
