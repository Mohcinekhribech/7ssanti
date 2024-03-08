package com.orcamo.hssanti.app.dtos.request;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.orcamo.hssanti.app.entities.ReservationEtat;
import lombok.Data;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;

@Data
public class ReservationReq {
    private Integer id;
    private LocalDate date;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime startTime;
    @JsonFormat(pattern = "HH:mm")
    private LocalTime endTime;
    private ReservationEtat etat;
    private Integer clientId;
}