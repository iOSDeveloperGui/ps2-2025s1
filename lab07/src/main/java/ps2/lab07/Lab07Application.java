package ps2.lab07;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import static java.lang.System.out;
import java.util.Scanner;

@SpringBootApplication
public class Lab07Application implements CommandLineRunner{
	
	//Reference
	@Autowired
	private MusicsRepo musicsRepo;
	
	//Scanner
	Scanner scanner = new Scanner(System.in);

	public static void main(String[] args) {
		SpringApplication.run(Lab07Application.class, args);
	}

	@Override
	public void run(String... args){
		out.println("# Musics Manager!");
		boolean exit = true;

		while (!exit) {
			out.println("## MUSICS MANAGER ##");
			out.println("(1) Create Music");
			out.println("(2) Read Music");
			out.println("(3) Update Music");
			out.println("(4) Delete Music");
			out.println("(5) Exit");
			out.print("Enter a option: ");
			int opcao = Integer.parseInt(scanner.nextLine());
			switch(opcao) {
				case 1: createMusics(); break; 
				case 2: readMusics(); break; 
				case 3: updateMusics(); break;
				case 4: deleteMusics(); break;
				case 5: exit = true; break;
				default:
					out.println("## Invalid option! ##");
			}
		}
	}

	//CreateMethod
	public void createMusics(){
		out.print("Enter the music name: ");
		String name = scanner.nextLine();
		out.print("Enter the composer's name: ");
		String composer = scanner.nextLine();
		out.print("Enter the year of the music: ");
		int year = Integer.parseInt(scanner.nextLine());
		Musics m = new Musics(name, composer, year);
		musicsRepo.save(m);
	}

	//ReadMethod
	public void readMusics(){
		Iterable<Musics> m = musicsRepo.findAll();
		for(Musics musics : m){
			out.println(musics.getTitle() + " - " + musics.getcomposer() + " - " + musics.getYear());
		}
	}

	//UpdateMethod
	public void updateMusics(){

	}

	//DeleteMethod
	public void deleteMusics(){
		out.print("Enter the ID of the music to delete: ");
        try {
            Long id = Long.parseLong(scanner.nextLine());
            if (musicsRepo.existsById(id)) {
                musicsRepo.deleteById(id);
                out.println("Music with ID " + id + " deleted successfully!");
            } else {
                out.println("## Music with ID " + id + " not found. ##");
            }
        } catch (NumberFormatException e) {
            out.println("## Invalid ID format. Please enter a valid number. ##");
        }
	}

}
