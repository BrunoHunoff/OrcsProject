package com.orcs.orcamentos.dtos;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;

public record OrcDto(@NotBlank String content,@NotNull BigDecimal value) {
}
