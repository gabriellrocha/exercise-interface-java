package model.services;

public class PaypalService implements OnlinePaymentService {

	@Override
	public Double interest(Double amount, Integer months) {
		return amount + (amount * months * 0.01);
	}
	
	@Override
	public Double paymentFee(Double amount) {
		return amount + (amount * 0.02);
	}

}
