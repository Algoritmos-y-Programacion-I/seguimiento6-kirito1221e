package ui;

import java.util.Scanner;

import model.SpeciesController;

public class SpeciesExecutable {

	private Scanner reader;
	private SpeciesController speciesController;

	public static void main(String[] args) {
		SpeciesExecutable exe = new SpeciesExecutable();
		exe.showMainMenu();
	}

	public SpeciesExecutable() {

		reader = new Scanner(System.in);
		speciesController = new SpeciesController();
	}

	public void showMainMenu() {

		System.out.println("Welcome to Icesi Species");

		boolean stopFlag = false;

		while (!stopFlag) {

			System.out.println("\nType an option");
			System.out.println("1. Register a Species");
			System.out.println("2. Edit a Species");
			System.out.println("3. Delete a Species");
			System.out.println("4. show a specie");
			System.out.println("0. Exit");

			int mainOption = reader.nextInt();

			switch (mainOption) {

				case 1:
					System.out.println("Do you want to register?");
					System.out.println("1. Fauna" +
							"\n2. Flora");
					int option = reader.nextInt();
					switch (option) {
						case 1:
							registerFauna();
							break;
						case 2:
							registerFlora();
							break;
						default:
							break;
					}
					break;
				case 2:

					System.out.println("Do you want to edit?");
					System.out.println("1. Fauna" +
							"\n2. Flora");
					int option2 = reader.nextInt();
					switch (option2) {
						case 1:
							editFaunaSpecies();
							break;
						case 2:
							editFloraSpecies();
							break;
						default:
							break;
					}
					break;
				case 3:
					deleteSpecies();
					break;
				
				case 4:
					showSpecies();
					break;
				case 0:
					System.out.println("Thanks for using our system");
					stopFlag = true;
					break;
				default:
					System.out.println("You must type a valid option");
					break;

			}

		}

	}

	public void registerFauna() {

		System.out.println("Type the new fauna species' name: ");
		String name = reader.next();

		reader.nextLine();

		System.out.println("Type the new fauna species' scientific name: ");
		String scientificName = reader.next();

		System.out.println("Is a migration fauna specie? (true or false): ");
		boolean migration = reader.nextBoolean();

		System.out.println(" Max weight the new fauna specie:");
		double weightMax = reader.nextDouble();

		if (speciesController.registerFaunaSpecies(name, scientificName, migration, weightMax)) {

			System.out.println("Species registered successfully");

		} else {

			System.out.println("Error, Species couldn't be registered");
		}

	}

	public void registerFlora() {

		System.out.println("Type the new Species' name: ");
		String name = reader.next();

		System.out.println("Type the new Species' scientific name: ");
		String scientificName = reader.next();

		System.out.println("does the flora species have flowers? (true or false):");
		boolean flowers = reader.nextBoolean();

		System.out.println("does the flora species have fruits? (true or false):");
		boolean fruits = reader.nextBoolean();

		System.out.println("Max height the new flora specie:");
		double maxheight = reader.nextDouble();

		if (speciesController.registerFloraSpecies(name, scientificName, flowers, fruits, maxheight)) {

			System.out.println("Species registered successfully");

		} else {

			System.out.println("Error, Species couldn't be registered");
		}

	}

	public void editFaunaSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showFaunaSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			reader.nextLine();
			
			System.out.println("Choose the specie that you want to edit: ");
			String name = reader.nextLine();

			System.out.println("What is the new name for the fauna specie?:");
			String newName = reader.nextLine();

			System.out.println("what is the new scientificName for the fauna specie?:");
			String scientificName = reader.nextLine();

			System.out.println("Is a migration fauna specie? (true or false): ");
			boolean migration = reader.nextBoolean();

			System.out.println(" Max weight the fauna specie:");
			double weightMax = reader.nextDouble();

			if(speciesController.editFaunaSpecies(name, newName, scientificName, migration, weightMax) != null){

				System.out.println("The edit was succeful");
			}else{
				System.out.println("Error: The edit was unsucceful");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void editFloraSpecies() {

		System.out.println("Which Species do you want to edit?");

		String query = speciesController.showFloraSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			reader.nextLine();

			System.out.println("Choose the specie that you want to edit: ");
			String name = reader.nextLine();

			System.out.println("What is the new name for the fauna specie?:");
			String newName = reader.nextLine();

			System.out.println("what is the new scientificName for the fauna specie?:");
			String scientificName = reader.nextLine();

			System.out.println("does the flora species have flowers? (true or false):");
			boolean flowers = reader.nextBoolean();

			System.out.println("does the flora species have fruits? (true or false):");
			boolean fruits = reader.nextBoolean();

			System.out.println("Max height the flora specie:");
			double maxheight = reader.nextDouble();

			if(speciesController.editFloraSpecies(name, newName, scientificName, flowers, fruits, maxheight) != null){

				System.out.println("The edit was succeful");
			}else{

				System.out.println("Error: the edit was unsuccesul");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void deleteSpecies() {

		System.out.println("Which Species do you want to delete?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			reader.nextLine();

			System.out.println("What is the name of the specie");
			String name =reader.nextLine();

			if(speciesController.deleteSpeciesToList(name)== true){

				System.out.println("The specie was delete");
			}else{

				System.out.println("Error: The specie was not delete");
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}

	public void showSpecies() {

		System.out.println("Which Species do you want to review?");

		String query = speciesController.showSpeciesList();

		if (!query.equals("")) {
			System.out.println(query);

			reader.nextLine();

			System.out.println("What is the name of the specie");
			String name = reader.nextLine();

			String specie = speciesController.consultSpecies(name);
			if(specie==null){

				System.out.println("The specie was not found");

			}else{

				System.out.println("The specie is:" + specie);
			}

		} else {
			System.out.println("There aren't any species registered yet");
		}

	}
}