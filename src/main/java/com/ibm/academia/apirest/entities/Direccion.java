package com.ibm.academia.apirest.entities;

import java.io.Serializable;

import javax.persistence.Embeddable;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class Direccion implements Serializable {

	private String calle;

	private String numero;

	private String codigoPostal;

	private String departamento;

	private String piso;

	private String localidad;

	private static final long serialVersionUID = -4973343644323889546L;
}
