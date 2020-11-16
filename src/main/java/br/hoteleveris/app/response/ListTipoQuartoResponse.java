package br.hoteleveris.app.response;

import java.util.List;

public class ListTipoQuartoResponse extends BaseResponse {

	private List<TipoQuartoResponse> TipoQuarto;

	public List<TipoQuartoResponse> getTipoQuarto() {
		return TipoQuarto;
	}

	public void setTipoQuarto(List<TipoQuartoResponse> tipoQuarto) {
		tipoQuarto = tipoQuarto;
	}

	public void setDescricao(Object tipoQuartoResponse) {
		// TODO Auto-generated method stub
		
	}
}
