package com.giggs13.springbootthymeleafdemo.entity.error;

import lombok.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class EmployeeErrorResponse {

    private int status;
    private String message;
    private long timeStamp;
}
