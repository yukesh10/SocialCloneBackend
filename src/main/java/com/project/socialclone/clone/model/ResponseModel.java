package com.project.socialclone.clone.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ResponseModel {
    private String message;
    private Object object;
    private List<Object> objectList;
    private boolean isSuccessful = false;
}
