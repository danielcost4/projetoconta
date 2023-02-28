package conta;

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
		
		int opcao, numero, agencia, tipo, aniversario;
		String titular;
		float saldo, limite;

		System.out.println("\n Criar Contas \n");
		
		ContaCorrente cc1 = new ContaCorrente(contas.gerarNumero(), 123, 1, "João da Silva", 1000f, 100.00f);
		contas.cadastrar(cc1);
		ContaCorrente cc2 = new ContaCorrente(contas.gerarNumero(), 124, 1, "Maria da Silva", 1000f, 100.00f);
		contas.cadastrar(cc2);
		ContaPoupanca cp1 = new ContaPoupanca(contas.gerarNumero(), 125, 1, "Claudio da Silva", 4000f, 12);
		contas.cadastrar(cp1);
		ContaPoupanca cp2 = new ContaPoupanca(contas.gerarNumero(), 126, 1, "José da Silva", 1000f, 15);
		contas.cadastrar(cp2);
		
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

			opcao = leia.nextInt();

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

					break;
				case 7:
					System.out.println("Depósito\n\n");

					break;
				case 8:
					System.out.println("Transferência entre Contas\n\n");

					break;
				default:
					System.out.println("\nOpção Inválida!\n");
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
		// TODO Auto-generated method stub
		
	}
}
