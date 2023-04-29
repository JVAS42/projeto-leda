package MAIN;

import java.io.IOException;
import java.util.Scanner;

import Ordenacoes.OrdenacaoPrimeiraForma;
import Ordenacoes.OrdenacaoSegundaForma;
import Ordenacoes.OrdenacaoTerceiraForma;
import Transformacoes.PrimeiraTransformacao;
import Transformacoes.SegundaTransformacao;
import Transformacoes.TerceiraTransformação;

public class Main {
	public static void main(String args[]) {

		try {
			// Gerando a transformação 1

			Scanner leitor = new Scanner(System.in);
			System.out.println("Aguarde enquanto os arquivos das transformações estão sendo gerados neste momento.");
			PrimeiraTransformacao trans1 = new PrimeiraTransformacao();
			trans1.leStations();
			trans1.leMetroTrips();
			SegundaTransformacao trans2 = new SegundaTransformacao();
			trans2.newFile();
			TerceiraTransformação trans3 = new TerceiraTransformação();
			trans3.newFile2();

			System.out.println("O processo foi concluído com sucesso. "
					+ "Por gentileza, verifique a pasta onde o projeto está armazenado para acessar os arquivos gerados.\n");

			int opc = 0;
			int tamanho = 0;
			do {
				System.out.println("Por gentileza, indique qual passo de ordenação você deseja executar: ");
				System.out.println("\n1 - Passo 1-\n2 - Passo 2\n3 - Passo 3\n4 - Sair");
				opc = leitor.nextInt();
				System.out.println("Por favor, informe a quantidade de linhas que deseja ordenar,"
						+ " lembrando que o limite máximo é 1.250.836 linhas: ");
				tamanho = leitor.nextInt();

				switch (opc) {
				case 1:
					OrdenacaoPrimeiraForma passo1 = new OrdenacaoPrimeiraForma();
					passo1.allMediumCases();
					passo1.insertionFiles(tamanho); // Limitando o tamanho do arquivo para ordenação
					passo1.selectionFiles(tamanho);
					passo1.mergeSortFiles();
					passo1.quickSortFiles();
					passo1.heapSortFiles(tamanho);
					break;
				case 2:
					OrdenacaoSegundaForma passo2 = new OrdenacaoSegundaForma();
					passo2.allMediumCases();
					passo2.countingFiles();
					passo2.mergeSortFiles();
					passo2.insertionFiles(tamanho);
					passo2.selectionFiles(tamanho);
					passo2.heapSortFiles();
					passo2.quickSort3tFiles(tamanho);
					passo2.quickSortFiles(tamanho);
					break;
				case 3:
					OrdenacaoTerceiraForma passo3 = new OrdenacaoTerceiraForma();
					passo3.allMediumCases();
					passo3.heapSortFiles(tamanho);
					passo3.insertionFiles(tamanho);
					passo3.selectionFiles(tamanho);
					passo3.quickSortFiles(tamanho);
					passo3.quickSort3tFiles(tamanho);
					passo3.mergeSortFiles(tamanho - 1);
					break;
				case 4:
					System.out.println("Saindo...\n...\nPronto!");
					break;
				default:
					System.out.println("Não conseguimos entender essa opção!");
					break;
				}
			} while (opc < 4 && opc > 0);
		} catch (IOException e) {
			System.out.println("Algo deu errado  : (\nInicie o programa novamente.\n");
			System.out.println(e);
		}
	}
}
