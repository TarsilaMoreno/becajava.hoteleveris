package br.hoteleveris.app.service;

import java.util.List;

import br.hoteleveris.app.model.Quarto;
import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

public class ListQuartoResponse extends BaseResponse {

	private List<QuartoResponse> quartos;

	public List<QuartoResponse> getQuartos() {
		return quartos;
	}

	public void setQuartos(List<QuartoResponse> quartos) {
		this.quartos = quartos;
	}

	
		
	}

