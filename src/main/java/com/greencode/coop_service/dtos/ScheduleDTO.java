package com.greencode.coop_service.dtos;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.greencode.coop_service.entities.Bus;
import lombok.*;

import java.time.LocalDateTime;
import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class ScheduleDTO {
    @EqualsAndHashCode.Include
    private UUID idSchedule;

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateCreate = LocalDateTime.now();

    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "yyyy-MM-dd'T'HH:mm:ss")
    private LocalDateTime dateSchedule;

    private Integer status = 1;
    private Bus idBus;
}
