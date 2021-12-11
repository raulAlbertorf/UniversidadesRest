package com.ibm.academia.apirest;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;


class UniversidadesRestApplicationTests {

	Calculadora calculadora = new Calculadora();
	
	@Test
	@DisplayName("sumaValores")
	void sumValores() {
		//Given - - Define el contexto o la/s precondiciones(Qué necesitamos para que funcione)
		Integer a = 2;
		Integer b = 2;
		
		//When - - Ejecuta la acción (Qué quiere probar)
		Integer resultado = calculadora.sumar(a, b);	
		
		//Then - - Valida la ejecución
		Integer resultadoEsperado = 3;
		assertThat(resultado).isEqualTo(resultadoEsperado);
	}
	
	class Calculadora{
		Integer sumar(Integer a, Integer b) {
			return a+b;
		}
	}
	
	

}
