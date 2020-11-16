package br.hoteleveris.app.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.model.TipoQuarto;
import br.hoteleveris.app.repository.QuartoRepository;
import br.hoteleveris.app.request.QuartoRequest;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.ListTipoQuartoResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

@Service
public class QuartoService {

	@Autowired
	private QuartoRepository _repository;

	public BaseResponse inserir(QuartoRequest request) {
		Quarto quarto = new Quarto();
		BaseResponse base = new BaseResponse();
		base.statusCode = 400;

		if (request.getAndar() == 0) {
			base.message = "Por favor preencha o andar que deseja";
			return base;
		}

		if (request.getNoQuarto() == 0) {
			base.message = "Número do quarto não preenchido";
			return base;
		}
		if (request.getSituacao() == "") {
			base.message = "Preencha a situação do quarto como Ativo ou Inativo";
			return base;
		}

		quarto.setAndar(request.getAndar());
		quarto.setNoQuarto(request.getNoQuarto());
		quarto.setSituacao(request.getSituacao());

		_repository.save(quarto);
		base.statusCode = 201;
		base.message = "Quarto foi inserido com sucesso!";
		return base;
	}

	public QuartoResponse obter(Long id) {
		Optional<Quarto> quarto = _repository.findById(id);
		QuartoResponse response = new QuartoResponse();

		if (quarto == null) {
			response.message = "Quarto não encontrado, tente novamente!";
			response.statusCode = 404;
			return response;
		}

		response.setAndar(quarto.get().getAndar());
		response.setNoQuarto(quarto.get().getNoQuarto());
		response.setSituacao(quarto.get().getSituacao());

		response.message = "Cliente localizado!!!";
		response.statusCode = 200;
		return response;

	}

// PRECISO REFAZER PARA ACHAR O ERRO
//	public ListQuartoResponse listar(List<QuartoResponse> quartoResponse) {
//		List<Quarto> lista = _repository.findAll();
//
//		List<QuartoResponse> quartoResponse1 = new ArrayList<QuartoResponse>();
//
//		for (Quarto Quarto : lista) {
//			QuartoResponse QuartoResponseList = new QuartoResponse();
//
//			QuartoResponseList.setAndar(Quarto.getAndar());
//			QuartoResponseList.setNoQuarto(Quarto.getNoQuarto());
//			QuartoResponseList.setSituacao(Quarto.getSituacao());
//
//			TipoQuartoResponse.add(QuartoResponseList);
//
//			ListQuartoResponse response = new ListQuartoResponse();
//
//			response.setQuarto(quartoResponse1);
//			response.statusCode = 200;
//			response.message = "Tipo de quarto listado com sucesso";
//			return response;
//
//		}
//	
//	}
}
