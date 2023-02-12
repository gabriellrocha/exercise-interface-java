package model.entities;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import model.exceptions.DomainException;

public class Contract {
	
	private Integer number;
	private LocalDate date;
	private Double totalValue;
	
	private List<Installment> installments = new ArrayList<>();
	
	public Contract(Integer number, LocalDate date, Double totalValue) throws DomainException {
		this.number = number;
		this.date = date;
		if (totalValue <=0) {
			throw new DomainException("Valor do contrato não pode ser zero ou negativo.");
		}
		this.totalValue = totalValue;
	}

	public Integer getNumber() {
		return number;
	}

	public void setNumber(Integer number) {
		this.number = number;
	}

	public LocalDate getDate() {
		return date;
	}

	public void setDate(LocalDate date) {
		this.date = date;
	}

	public Double getTotalValue() {
		return totalValue;
	}

	public void setTotalValue(Double totalValue) {
		this.totalValue = totalValue;
	}

	public List<Installment> getInstallments() {
		return installments;
	}
	
	public void setInstallments(Installment installment) {
		installments.add(installment);
	}
	
}
