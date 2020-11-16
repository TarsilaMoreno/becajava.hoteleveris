package br.hoteleveris.app.service;

import java.util.List;

import br.hoteleveris.app.response.BaseResponse;
import br.hoteleveris.app.response.QuartoResponse;
import br.hoteleveris.app.response.TipoQuartoResponse;

public class ListQuartoResponse extends BaseResponse {

	private List<QuartoResponse> Quarto;

	public List<QuartoResponse> getTipoQuarto() {
		return Quarto;
	}

	public void setQuarto(List<QuartoResponse> Quarto) {
		Quarto = Quarto;
	}
}
