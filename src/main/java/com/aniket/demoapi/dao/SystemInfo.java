package com.aniket.demoapi.dao;

import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class SystemInfo {
    private String status;
    private LocalDate localDate;
}
