package conta;

import java.util.Scanner;

public class Menu {

	public static void main(String[] args) {

		Scanner leia = new Scanner(System.in);

		int opcao;

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

					break;
				case 2:
					System.out.println("Listar todas as Contas\n\n");

					break;
				case 3:
					System.out.println("Consultar dados da Conta - por número\n\n");

					break;
				case 4:
					System.out.println("Atualizar dados da Conta\n\n");

					break;
				case 5:
					System.out.println("Apagar a Conta\n\n");

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
}
