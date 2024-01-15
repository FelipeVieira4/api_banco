package com.banco.backend.dots;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

public record ContaDots(@NotNull @Positive int clienteID, @NotNull float saldo) {}
