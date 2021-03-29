package intercorp.retail.reto.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import intercorp.retail.reto.domain.Client;
import intercorp.retail.reto.dto.CalculationDto;
import intercorp.retail.reto.dto.ClientWebDto;
import intercorp.retail.reto.service.IClientService;

@RestController
public class ClientController {

	@Autowired
	private IClientService clientService;

	@PostMapping(value = "/crearcliente")
	@RequestMapping(value = "/crearcliente", method = RequestMethod.POST, name = "Crear Cliente")
	public HttpEntity<ClientWebDto> createClient(@Valid @RequestBody ClientWebDto request) {
		ClientWebDto response = clientService.createClient(request);
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/listclientes")
	@RequestMapping(value = "/listclientes", method = RequestMethod.GET, name = "Listar Cliente")
	public HttpEntity<List<Client>> listClients() {
		List<Client> response = clientService.listClients();
		return ResponseEntity.ok(response);
	}

	@GetMapping(value = "/kpidclientes")
	@RequestMapping(value = "/kpidclientes", method = RequestMethod.GET, name = "Desviación estandar y promedio de edades")
	public HttpEntity<CalculationDto> calculate() {
		CalculationDto response = clientService.calculate();
		return ResponseEntity.ok(response);
	}
}
