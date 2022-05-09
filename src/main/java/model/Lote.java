package model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Lote {
	private int idLote;
	private LocalDateTime dataCompra;
	private LocalDate dataValidade;
	
	public Lote() {
		idLote = -1;
		dataCompra = LocalDateTime.now().truncatedTo(ChronoUnit.SECONDS);
		dataValidade = LocalDate.now().plusMonths(6);
	}

	public Lote(int id, LocalDateTime compra, LocalDate v) {
		setIdLote(id);
		setDataCompra(compra);
		setDataValidade(v);
	}		
	
	public int getIDLote() {
		return idLote;
	}

	public void setIdLote(int id) {
		this.idLote = id;
	}
	
	public LocalDate getDataValidade() {
		return dataValidade;
	}

	public LocalDateTime getDataCompra() {
		return dataCompra;
	}

	public void setDataCompra(LocalDateTime dataCompra) {
		LocalDateTime agora = LocalDateTime.now();
		if (agora.compareTo(dataCompra) >= 0)
			this.dataCompra = dataCompra;
	}

	public void setDataValidade(LocalDate dataValidade) {
		if (getDataCompra().isBefore(dataValidade.atStartOfDay()))
			this.dataValidade = dataValidade;
	}

	public boolean emValidade() {
		return LocalDateTime.now().isBefore(this.getDataValidade().atTime(23, 59));
	}


	@Override
	public String toString() {
		return "Lote: " + "   Fabricação: " + dataCompra  + "   Data de Validade: " + dataValidade;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getIDLote() == ((Lote) obj).getIDLote());
	}	
}
