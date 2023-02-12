package model.entities;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

public class Installment { // parcela
	private static DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
	
	private LocalDate dueDate; // data vencimento
	private Double amount; // valor
	
	public Installment(LocalDate dueDate, Double amount) {
		this.dueDate = dueDate;
		this.amount = amount;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

	public Double getAmount() {
		return amount;
	}

	public void setAmount(Double amount) {
		this.amount = amount;
	}
	
	@Override
	public String toString() {
		return getDueDate().format(fmt) + " - R$" + String.format("%.2f", getAmount());
	}
	
}
