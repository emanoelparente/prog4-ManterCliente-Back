package br.ueg.aula01;

import br.ueg.aula01.model.Aluno;
import br.ueg.aula01.repository.AlunoRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class Aula01Application {

	public static void main(String[] args) {
		SpringApplication.run(Aula01Application.class, args);
	}

	@Bean
	public CommandLineRunner commandLineRunner(AlunoRepository alunoRepository){
		return args -> {
			Aluno a1 = new Aluno(1L, "João", "Augusto", "joao@dom.com", 20);
			alunoRepository.save(a1);

			a1 = new Aluno(2L, "Maria", "Fernanda", "maria@dom.com", 18);
			alunoRepository.save(a1);
		};
	};
}
