package lab06;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.Scanner;

@SpringBootApplication
public class Lab06Application implements CommandLineRunner{

	@Autowired
	private ProfessorRepo ProfessorRepo;
	
	@Autowired
	private FaculdadeRepo faculdadeRepo;

	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(Lab06Application.class, args);
	}

	@Override
	public void run(String... args){
		out.println("# Gerenciador de Professores e Faculdades!");
		boolean sair = false;
		while (!sair) {
			out.println("## GERENCIADOR DE TITULARES ##");
			out.println("(1) Cadastrar Faculdade");
			out.println("(2) Listar Faculdades");
			out.println("(3) Cadastrar Professor");
			out.println("(4) Listar professores");
			out.println("(5) Sair");
			out.print("Escolha uma opção: ");
			int opcao = Integer.parseInt(scanner.nextLine());
			switch(opcao) {
				case 1: createUniversity(); break; 
				case 2: readUniversities(); break; 
				case 3: createTeacher(); break;
				case 4: readTeachers(); break;
				case 5: sair = true; break;
				default:
					out.println("## Opção inválida! ##");
			}
		}
	}

	public void createUniversity(){
		out.print("# Name of the university: ");
		String name = scanner.nextLine();
		out.print("# Year of foundation: ");
		int year = Integer.parseInt(scanner.nextLine());
		Faculdade f = new Faculdade(name, year);
		faculdadeRepo.save(f);
	}

	public void readUniversities(){
		Iterable<Faculdade> universites = faculdadeRepo.findAll();
		out.println("Universidades cadastradas: ");
		for(Faculdade f : universites){
			out.println(f.getNome() + " - " + f.getAnoFundacao());
		}
	}

	public void createTeacher(){
		out.print("# Teacher's name: ");
		String name = scanner.nextLine();
		out.print("# Teacher's CPF: ");
		String cpf = scanner.nextLine();
		out.print("Enter the registration: ");
		int registration = Integer.parseInt(scanner.nextLine());
		Professor p = new Professor(name, cpf, registration);
		ProfessorRepo.save(p);
	}

	public void readTeachers(){
		Iterable<Professor> teachers = ProfessorRepo.findAll();
		out.println("Professores cadastrados: ");
		for(Professor p : teachers){
			out.println(p.getNome() + " - " + p.getCpf() + " - " + p.getMatricula());
		}

	}

}
