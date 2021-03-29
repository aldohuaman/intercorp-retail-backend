package intercorp.retail.reto.service.impl;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import intercorp.retail.reto.domain.Client;
import intercorp.retail.reto.domain.Parameters;
import intercorp.retail.reto.dto.CalculationDto;
import intercorp.retail.reto.dto.ClientWebDto;
import intercorp.retail.reto.repository.ClientRepository;
import intercorp.retail.reto.repository.ParametersRepository;
import intercorp.retail.reto.service.IClientService;
import intercorp.retail.reto.util.OperationUtils;

@Service
public class ClientServiceImpl implements IClientService {

	@Autowired
	private ClientRepository clientRepository;

	@Autowired
	private ParametersRepository parametersRepository;

	@Override
	public ClientWebDto createClient(ClientWebDto clientWebDto) {
		Client clientDto = clientWebDto.getClient();
		clientRepository.insert(clientDto);
		ClientWebDto response = new ClientWebDto();
		response.setProcessResult(true);
		return response;
	}

	@Override
	public List<Client> listClients() {
		List<Client> clients = clientRepository.findAll();
		Parameters parameterResult = parametersRepository.findLifeExpectancy();
		Integer lifeExpectancy = Integer.parseInt(parameterResult.getValue());
		return clients.parallelStream().map(c -> {
			Date deathDate = OperationUtils.calculateDeathDate(c.getBirthDate(), lifeExpectancy);
			c.setDeathDate(deathDate);
			return c;
		}).collect(Collectors.toList());

	}

	@Override
	public CalculationDto calculate() {
		List<Client> clients = clientRepository.findAll();
		int[] clientsarray = clients.stream().mapToInt(c -> c.getAge()).toArray();
		double average = OperationUtils.calculateAverage(clientsarray);
		double standardDeviation = OperationUtils.standardDeviation(clientsarray);

		CalculationDto response = new CalculationDto();
		response.setAverage(average);
		response.setStandardDeviation(standardDeviation);
		return response;
	}

}
