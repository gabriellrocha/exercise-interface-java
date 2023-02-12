package model.services;

import model.entities.Contract;
import model.entities.Installment;
import model.exceptions.DomainException;

public class ContractService {
	
	private OnlinePaymentService onlinePaymentService;
	
	public ContractService(OnlinePaymentService onlinePaymentService){
		this.onlinePaymentService = onlinePaymentService;
	}

	public OnlinePaymentService getOnlinePaymentService() {
		return onlinePaymentService;
	}

	public void setOnlinePaymentService(OnlinePaymentService onlinePaymentService) {
		this.onlinePaymentService = onlinePaymentService;
	}
	
	public void processContract(Contract contract, Integer months) throws DomainException, NullPointerException {
		if (months <=0) {
			throw new DomainException("Valor das parcelas não pode ser zero ou negativo.");
		}
		if (contract == null) {
			throw new NullPointerException("Deve existir um contrato.");
		}
		double grossValue = contract.getTotalValue() / months;
		for (int i=1; i<=months; i++) {
			double interest = onlinePaymentService.interest(grossValue, i);
			double result = onlinePaymentService.paymentFee(interest);
			contract.setInstallments(new Installment(contract.getDate().plusMonths(i), result));
		}
		
		
	}
	
}
