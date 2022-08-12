package selecao.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;
/*
@Author MATHEUS MACEDO LONGO
 */
@SpringBootApplication
public class SelecaoCandidatosApplication {

	public static void main(String[] args) {
		SpringApplication.run(SelecaoCandidatosApplication.class, args);
		String candidatos[] = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
		for (String candidato : candidatos) {
			entrandoEmContato(candidato);
		}
	}
		static void entrandoEmContato(String candidato){
		int tentativasRealizadas= 1;
		boolean continuarTentando= true;
		boolean atendeu=false;
		do {
		atendeu = atender();
		continuarTentando= !atendeu;
		if (continuarTentando)
				tentativasRealizadas++;
		else
			System.out.println("CONTATO REALIZADO COM SUCESSO");
		}while (continuarTentando && tentativasRealizadas<3);
		if (atendeu)
			System.out.println("CONSEGUIMOS CONTATO COM " + candidato + " NA " + tentativasRealizadas + " TENTATIVA ");
		else
			System.out.println("NÃO CONSEGUIMOS CONTATO COM " + candidato + ", NUMERO MAXIMO DE TENTATIVAS " + tentativasRealizadas);
		}
		static boolean atender(){
		return new Random().nextInt(3)==1;
		}
		static void imprimirSelecionados(){
		String candidatos [] ={"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO"};
			System.out.println("IMPRIMINDO OBTENDO O INDICE");
			for (int indice = 0; indice< candidatos.length; indice++ ){
				System.out.println("O CANDIDATO DE NUMERO: " + (indice+1) + " É :"+ candidatos[indice]);
			}
		}
		static void selecaoCandidatos(){
			String[] candidatos = {"FELIPE", "MARCIA", "JULIA", "PAULO", "AUGUSTO", "MONICA", "FABRICIO", "MIRELA", "DANIELA"};
			int candidatosSelecionados = 0;
			int candidatosAtual = 0;
			double salarioBase = 2000.0;
			while (candidatosSelecionados < 5 && candidatosAtual < candidatos.length) {
				String candidato = candidatos[candidatosAtual];
				double salarioPretendido = valorPretendido();
				System.out.println("O CANDIDATO " + candidato + " SOLICITOU ESTE VALOR DE SALARIO " + salarioPretendido);
				if (salarioBase >= salarioPretendido) {
					System.out.println("O CANDIDATO " + candidato + " FOI SELECIONADO PARA VAGA");
					candidatosSelecionados++;
				}
				candidatosAtual++;
			}
		}
		static double valorPretendido () {
			return ThreadLocalRandom.current().nextDouble(1800, 2000);
		}

		static void analisarCandidato ( double salarioPretendido){
			double salarioBase = 2000.0;
			if (salarioBase > salarioPretendido) {
				System.out.println("LIGAR PARA O CANDIDATO");
			} else if (salarioBase == salarioPretendido) {
				System.out.println("LIGAR PARA O CANDIDATO COM CONTRA PROPOSTA");
			} else {
				System.out.println("AGUARDADANDO O RESULTADO DOS DEMAIS CANDIDATOS");
			}
		}
	}

