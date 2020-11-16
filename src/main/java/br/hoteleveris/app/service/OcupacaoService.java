package br.hoteleveris.app.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Ocupacao;
import br.hoteleveris.app.repository.OcupacaoRepository;
import br.hoteleveris.app.request.OcupacaoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.OcupacaoResponse;

@Service
public class OcupacaoService {

	@Autowired
	private OcupacaoRepository _repository;

	public BaseResponse inserir(OcupacaoRequest request) {
		Ocupacao ocupacao = new Ocupacao();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;

		if (request.getData() == null) {
			base.message = "Insira uma data valida";
			return base;
		}
		if (request.getQtdDiarias() == 0) {
			base.message = "Preencha a quantidade de diárias...";
			return base;
		}
		if (request.getSituacao() == "") {
			base.message = "Digite a situação do pagamento!";
			return base;
		}

		ocupacao.setData(request.getData());
		ocupacao.setQtdDiarias(request.getQtdDiarias());
		ocupacao.setSituacao(request.getSituacao());

		_repository.save(ocupacao);
		base.statusCode = 201;
		base.message = "Ocupação inserida com sucesso!!!";
		return base;

	}

	public OcupacaoResponse obter(Long id) {
		Optional<Ocupacao> ocupacao = _repository.findById(id);
		OcupacaoResponse response = new OcupacaoResponse();

		if (ocupacao == null) {
			response.message = "Comodidade não localizada!";
			response.statusCode = 404;
			return response;
		}

		response.setData(ocupacao.get().getData());
		response.setQtdDiarias(ocupacao.get().getQtdDiarias());
		response.setSituacao(ocupacao.get().getSituacao());

		response.message = "Ocupação localizada com sucesso!!!";
		response.statusCode = 200;
		return response;
	}
}
