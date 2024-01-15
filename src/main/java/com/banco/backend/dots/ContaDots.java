package com.banco.backend.dots;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ContaDots(@NotNull @NotBlank int clienteID, float saldo) {}
