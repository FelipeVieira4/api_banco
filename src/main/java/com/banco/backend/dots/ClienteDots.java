package com.banco.backend.dots;

import com.banco.backend.models.Genero;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ClienteDots(@NotNull @NotBlank String nome, @NotNull @NotBlank String telefone,
                          @NotNull @NotBlank String cpf, @NotNull @NotBlank String senha,@NotNull @NotNull Genero genero) {}
