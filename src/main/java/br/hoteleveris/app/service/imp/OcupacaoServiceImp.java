package br.hoteleveris.app.service.imp;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Cliente;
import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListOcupacaoResponse;
import br.hoteleveris.app.response.OcupacaoResponse;

@Service
public class OcupacaoServiceImp {

	@Autowired
	private OcupacaoRepository _repository;

	public BaseResponse inserir(OcupacaoRequest request) {
		Ocupacao ocupacao = new Ocupacao();
		Cliente cliente = new Cliente();
		Quarto quarto = new Quarto();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;

		if (request.getData() == null) {
			base.message = "Insira uma data valida";
			return base;
		}
		if (request.getQtdDiarias() <= 0) {
			base.message = "Preencha a quantidade de diárias...";
			return base;
		}
		if (request.getSituacao() == "") {
			base.message = "Digite a situação do pagamento!";
			return base;
		}

		if (request.getClienteId() <= 0) {
			base.message = "Digite o Id do cliente!";
			return base;
		}

		if (request.getQuartoId() <= 0) {
			base.message = "Digite o Id do quarto!";
			return base;

		}

		if (ocupacao.getSituacao().isEmpty()) {
			ocupacao.setSituacao("N");
		}

		ocupacao.setData(request.getData());
		ocupacao.setQtdDiarias(request.getQtdDiarias());
		ocupacao.setSituacao(request.getSituacao());

		cliente.setId(request.getClienteId());
		ocupacao.setCliente(cliente);

		quarto.setId(request.getQuartoId());
		ocupacao.setQuarto(quarto);

		_repository.save(ocupacao);
		base.statusCode = 201;
		base.message = "Ocupação inserida com sucesso!!!";
		return base;

	}

	
	public ListOcupacaoResponse listar() {
		List<Ocupacao> lista = _repository.findAll();
		
		ListOcupacaoResponse response = new ListOcupacaoResponse();
		
		response.setOcupacoes(lista);
		response.statusCode = 200;
		response.message = "Ocupações listadas com sucesso!";
		return response;
		
		
				
		
	}
}
