package model.services;

import model.entities.Contract;
import model.entities.Installment;

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
	
	public void processContract(Contract contract, Integer months) {
		// responsável por gerar as parcelas
		double grossValue = contract.getTotalValue() / months;
		for (int i=1; i<=months; i++) {
			double interest = onlinePaymentService.interest(grossValue, i);
			double result = onlinePaymentService.paymentFee(interest);
			contract.setInstallments(new Installment(contract.getDate().plusMonths(i), result));
		}
		
		
	}
	
}
