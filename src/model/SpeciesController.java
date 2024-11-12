package model;

public class SpeciesController {

	private Species[] species;

	public SpeciesController() {
		species = new Species[100];

	}

	public boolean registerFaunaSpecies(String name, String scientificName, boolean migration, double weightMax) {

		Fauna newSpecie = new Fauna(name, scientificName, migration, weightMax);

		for (int i = 0; i < species.length; i++) {

			if (species[i] == null) {
				species[i] = newSpecie;
				return true;
			}

		}

		return false;
	}

	public boolean registerFloraSpecies(String name, String scientificName, boolean flowers, boolean fruits,
			double maxHeight) {

		Flora newSpecie = new Flora(name, scientificName, flowers, fruits, maxHeight);

		for (int i = 0; i < species.length; i++) {

			if (species[i] == null) {
				species[i] = newSpecie;
				return true;
			}

		}

		return false;
	}

	public boolean deleteSpeciesToList(String name) {
		for (int i = 0; i < species.length; i++) {
			if (species[i] != null && species[i].getName().equalsIgnoreCase(name)) {
				species[i] = null;
				return true;
			}
		}

		return false;
	}

	public String editFloraSpecies(String name, String newName, String scientificName, boolean flowes, boolean fruits,
			double maxheight) {
		for (int i = 0; i < species.length; i++) {
			if (species[i] instanceof Flora && species[i].getName().equalsIgnoreCase(name)) {
				Flora floraToEdit = (Flora) species[i];
				floraToEdit.setName(newName);
				floraToEdit.setCientificName(scientificName);
				floraToEdit.setFlowes(flowes);
				floraToEdit.setFruits(fruits);
				floraToEdit.setMaxHeight(maxheight);
				return "Especie de flora editada exitosamente.";
			}
		}
		return null;
	}

	public String editFaunaSpecies(String name, String newName, String scientificName, boolean migration,
			double weightMax) {
		for (int i = 0; i < species.length; i++) {
			if (species[i] instanceof Fauna && species[i].getName().equalsIgnoreCase(name)) {
				Fauna faunaToEdit = (Fauna) species[i];
				// Actualiza los atributos de la especie de fauna
				faunaToEdit.setName(newName);
				faunaToEdit.setCientificName(scientificName);
				faunaToEdit.setMigration(migration);
				faunaToEdit.setWeightMax(weightMax);
				return "Especie de fauna editada exitosamente.";
			}
		}
		return null;
	}

	public String consultSpecies(String name) {

		
		if (species == null) {
			return "Species array is not initialized.";
		}
	
		for (Species especie : species) {
			if (especie != null && especie.getName().equalsIgnoreCase(name)) {
				return especie.toString(); // Llama a toString() del objeto encontrado
			}
		}
		return null;
	}

	public String showSpeciesList() {

		StringBuilder floraList = new StringBuilder();
		StringBuilder faunaList = new StringBuilder();

		for (Species especie : species) {
			if (especie instanceof Flora) {
				floraList.append(especie.getName()).append(" (").append(especie.getCientificName()).append(")\n");
			} else if (especie instanceof Fauna) {
				faunaList.append(especie.getName()).append(" (").append(especie.getCientificName()).append(")\n");
			}
		}

		StringBuilder result = new StringBuilder();
		if (floraList.length() > 0) {
			result.append("Flora Species:\n").append(floraList);
		}
		if (faunaList.length() > 0) {
			result.append("Fauna Species:\n").append(faunaList);
		}

		return result.toString();
	}

	public String showFloraSpeciesList() {
		StringBuilder floraList = new StringBuilder();

		for (Species especie : species) {
			if (especie instanceof Flora) {
				floraList.append(especie.getName())
						.append(" (")
						.append(especie.getCientificName())
						.append(")\n");
			}
		}

		if (floraList.length() == 0) {
			return "No hay especies de flora registradas.";
		}

		return "Flora Species:\n" + floraList.toString();
	}

	public String showFaunaSpeciesList() {
		StringBuilder faunaList = new StringBuilder();

		for (Species especie : species) {
			if (especie instanceof Fauna) {
				faunaList.append(especie.getName())
						.append(" (")
						.append(especie.getCientificName())
						.append(")\n");
			}
		}

		if (faunaList.length() == 0) {
			return "No hay especies de fauna registradas.";
		}

		return "Fauna Species:\n" + faunaList.toString();
	}
	
}