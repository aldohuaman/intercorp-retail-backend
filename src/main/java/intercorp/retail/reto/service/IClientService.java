package intercorp.retail.reto.service;

import java.util.List;

import intercorp.retail.reto.domain.Client;
import intercorp.retail.reto.dto.CalculationDto;
import intercorp.retail.reto.dto.ClientWebDto;

public interface IClientService {
	
	public ClientWebDto createClient(ClientWebDto clientWebDto);
	
	public List<Client> listClients();
	
	public CalculationDto calculate();
}
