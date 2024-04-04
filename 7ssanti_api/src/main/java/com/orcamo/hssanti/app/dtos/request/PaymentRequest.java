package com.orcamo.hssanti.app.dtos.request;

import lombok.Data;

@Data
public class PaymentRequest {
    private int amount;
    private String currency;
    private String token;
}
