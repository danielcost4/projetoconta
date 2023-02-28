package conta;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

import conta.controller.ContaController;
import conta.model.Conta;
import conta.model.ContaCorrente;
import conta.model.ContaPoupanca;
import conta.util.Cores;

public class Menu {

	public static void main(String[] args) {
		
		ContaController contas = new ContaController();
		
		Scanner leia = new Scanner(System.in);
		
		int opcao, numero, agencia, tipo, aniversario, numeroDestino;
		String titular;
		float saldo, limite, valor;

		System.out.println("\n Criar Contas \n");
		
		while (true) {

			System.out.println("**************************************************");
			System.out.println("                                                  ");
			System.out.println("                 Banco do Daniel                  ");
			System.out.println("                                                  ");
			System.out.println("**************************************************");
			System.out.println("                                                  ");
			System.out.println("         1 - Criar Conta                          ");
			System.out.println("         2 - Listar toda as contas                ");
			System.out.println("         3 - Buscar conta por número              ");
			System.out.println("         4 - Atualizar dados da conta             ");
			System.out.println("         5 - Apagar conta                         ");
			System.out.println("         6 - Sacar                                ");
			System.out.println("         7 - Depositar                            ");
			System.out.println("         8 - Transferir valores entre contas      ");
			System.out.println("         9 - Sair                                 ");
			System.out.println("                                                  ");
			System.out.println("**************************************************");
			System.out.println("                                                  ");
			System.out.println("Insira a opção desejada:");
				
			try {
				opcao = leia.nextInt();	
			} catch (InputMismatchException e){
				System.out.println("\nDigite valores inteiros!");
				leia.nextLine();
				opcao=0;
			}
			if (opcao == 9) {
				System.out.println("\nObrigado por escolher nossos serviços!");
				leia.close();
				System.exit(0);

				switch (opcao) {
				case 1:
					System.out.println("Criar Conta\n\n");
					
					System.out.println("Digite o número da Agência: ");
					agencia = leia.nextInt();
					System.out.println("Digite o Nome do Titular: ");
					leia.skip("\\R?");
					titular = leia.nextLine();
					
					do {
						System.out.println("Digite o Tipo da Conta (1 - CC ou 2 - CP)");
						tipo = leia.nextInt();
					}while(tipo < 1 && tipo > 2);
					
					System.out.println("Digite o Saldo da Conta (R$)");
					saldo = leia.nextFloat();
					
					switch(tipo) {
					case 1: {
						System.out.println("Digite o Limite de Crédito (R$): ");
						limite = leia.nextFloat();
						contas.cadastrar(newContaCorrente(contas.gerarNumero(), agencia, tipo, titular, saldo, limite));
					}
					case 2: {
						 System.out.println("Digite o dia do Aniversário da Conta: ");
						 aniversario = leia.nextInt();
						 contas.cadastrar(newContaPoupanca(contas.gerarNumero(), agencia, tipo, titular, saldo, aniversario));
					}
					}
					
					keyPress();
					break;
				case 2:
					System.out.println("Listar todas as Contas\n\n");
					contas.listarTodas();
					break;
				case 3:
					System.out.println("Consultar dados da Conta - por número\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					contas.procurarPorNumero(numero);
					
					keyPress();
					break;
				case 4:
					System.out.println("Atualizar dados da Conta\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					if (contas.buscarNaCollection(numero) != null) {
						
						System.out.println("Digite o Numero da Agência: ");
						agencia = leia.nextInt();
						System.out.println("Digite o Nome do Titular: ");
						leia.skip("\\R?");
						titular = leia.nextLine();
							
						System.out.println("Digite o Saldo da Conta (R$): ");
						saldo = leia.nextFloat();
						
						tipo = contas.retornaTipo(numero);
						
						switch(tipo) {
							case 1 -> {
								System.out.println("Digite o Limite de Crédito (R$): ");
								limite = leia.nextFloat();
								contas.atualizar(new ContaCorrente(numero, agencia, tipo, titular, saldo, limite));
							}
							case 2 -> {
								System.out.println("Digite o dia do Aniversario da Conta: ");
								aniversario = leia.nextInt();
								contas.atualizar(new ContaPoupanca(numero, agencia, tipo, titular, saldo, aniversario));
							}
							default ->{
								System.out.println("Tipo de conta inválido!");
							}
						}
						
					}else
						System.out.println("\nConta não encontrada!");

                    keyPress();

					break;
				case 5:
					System.out.println("Apagar a Conta\n\n");
					
					System.out.println("Digite o número da conta:");
					numero = leia.nextInt();
					
					contas.deletar(numero);
					
					keyPress();
					break;
				case 6:
					System.out.println("Saque\n\n");
					
					System.out.println("Digite o número da conta: ");
					numero = leia.nextInt();
					
					do { 
						System.out.println("Digite o valor do saque (R$): ");
						valor = leia.nextFloat();
					}while(valor <= 0);
					
					contas.sacar(numero, valor);

					keyPress();
					break;
				case 7:
					System.out.println("Depósito\n\n");
					
					System.out.println("Digite o Numero da conta: ");
					numero = leia.nextInt();
					
					do {
						System.out.println("Digite o Valor do Depósito (R$): ");
						valor = leia.nextFloat();
					}while(valor <= 0);

					contas.depositar(numero, valor);
					

					keyPress();
					break;
				case 8:
					System.out.println("Transferência entre Contas\n\n");

					System.out.println(Cores.TEXT_WHITE + "Transferência entre Contas\n\n");

					System.out.println("Digite o Numero da Conta de Origem: ");
					numero = leia.nextInt();
					System.out.println("Digite o Numero da Conta de Destino: ");
					numeroDestino = leia.nextInt();
					
					do {
						System.out.println("Digite o Valor da Transferência (R$): ");
						valor = leia.nextFloat();
					}while(valor <= 0);
					
					contas.transferir(numero, numeroDestino, valor);
					
					keyPress();
					break;
				default:
					System.out.println("\nOpção Inválida!\n");
					
					keyPress();
					break;
				}
			}
		}
	}

	private static Conta newContaPoupanca(Object gerarNumero, int agencia, int tipo, String titular, float saldo,
			int aniversario) {
		// TODO Auto-generated method stub
		return null;
	}

	private static Conta newContaCorrente(Object gerarNumero, int agencia, int tipo, String titular, float saldo,
			float limite) {
		// TODO Auto-generated method stub
		return null;
	}

	private static void keyPress() {
		
		try {
			
			System.out.println("\n Pressione Enter para continuar");
			System.in.read();
		}catch (IOException e) {
			
			System.out.println("Você pressionou uma tecla diferente de enter!");
			
		}
		
	}
}
