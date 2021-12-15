package com.ibm.academia.apirest.models.DTO;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CarreraDTO {
	
	private Integer id;

	@NotNull(message = "No puede ser nulo")
	@NotEmpty(message = "No puede ser vacio")
	@Size(max = 80, min = 5)
	private String nombre;

	@Positive(message = "Debe ser mayor a cero")
	private Integer cantidadMaterias;

	@Positive(message = "Debe ser mayor a cero")
	private Integer cantidadAnios;


	

}
