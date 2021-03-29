package intercorp.retail.reto.dto;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonInclude.Include;

import intercorp.retail.reto.domain.Client;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

import javax.validation.Valid;

@NoArgsConstructor
@Getter
@Setter
@JsonInclude(Include.NON_NULL)
public class ClientWebDto implements Serializable {
	
	private static final long serialVersionUID = 3797170014472284596L;
	
	@JsonProperty("cliente")
	@Valid
	private Client client;
	
	private boolean processResult;
}
