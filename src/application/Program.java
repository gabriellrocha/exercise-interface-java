package application;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.InputMismatchException;
import java.util.Scanner;

import model.entities.Contract;
import model.entities.Installment;
import model.exceptions.DomainException;
import model.services.ContractService;
import model.services.PaypalService;

public class Program {

	public static void main(String[] args) {
		
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		
		Scanner sc = new Scanner(System.in);
			
		System.out.println("Entre com os dados do contrato:");
		
		try {
			System.out.print("Numero: ");
			int numero = sc.nextInt();
			System.out.print("Data (dd/MM/yyyy): ");
			LocalDate data = LocalDate.parse(sc.next(), fmt);
			System.out.print("Valor do contrato: ");
			double valor = sc.nextDouble();
			System.out.print("Número de parcelas: ");
			int parcelas = sc.nextInt();
			
			Contract contrato = new Contract(numero, data, valor);
			ContractService service = new ContractService(new PaypalService());
			
			service.processContract(contrato, parcelas);
			
			System.out.println("Parcelas: ");
			for (Installment installment : contrato.getInstallments()) {
				System.out.println(installment);
			}
			
		} catch(DomainException | NullPointerException e) {
			System.out.println(e.getMessage());
		} catch(DateTimeParseException e) {
			System.out.println("Formato de data inválido.");
		} catch(InputMismatchException e) {
			System.out.println("ERRO");
		}
		
		sc.close();

	}

}
