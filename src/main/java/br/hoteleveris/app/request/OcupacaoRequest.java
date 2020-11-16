package br.hoteleveris.app.request;

import java.sql.Date;

public class OcupacaoRequest {

	private Date data;
	private int qtdDiarias;
	private String situacao;

	public Date getData() {
		return data;
	}

	public void setData(Date data) {
		this.data = data;
	}

	public int getQtdDiarias() {
		return qtdDiarias;
	}

	public void setQtdDiarias(int qtdDiarias) {
		this.qtdDiarias = qtdDiarias;
	}

	public String getSituacao() {
		return situacao;
	}

	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}

}
