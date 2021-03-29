package intercorp.retail.reto.domain;

import java.io.Serializable;
import java.util.Date;

import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.DateTimeFormat;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.Setter;

@Getter
public class Client implements Serializable {

	private static final long serialVersionUID = -3945149407719822259L;

	@JsonProperty("nombre")
	@NotNull(message = "Nombre es requerido")
	private String name;

	@JsonProperty("apellido")
	@NotNull(message = "Apellido es requerido")
	private String lastName;

	@JsonProperty("edad")
	@NotNull(message = "Edad es requerido")
	private int age;

	@JsonProperty("fechaNacimiento")
	@NotNull(message = "Fecha de nacimiento es requerido")
	@JsonFormat(pattern = "dd/MM/yyyy")
	private Date birthDate;

	@JsonProperty("fechaMuerte")
	@JsonFormat(pattern = "dd/MM/yyyy")
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Setter
	private Date deathDate;
}
