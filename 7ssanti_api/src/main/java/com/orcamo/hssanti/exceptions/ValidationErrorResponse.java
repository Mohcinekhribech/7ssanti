package com.orcamo.hssanti.exceptions;

import lombok.Data;

import java.util.List;

@Data
public class ValidationErrorResponse {
    private List<String> errors;
}
