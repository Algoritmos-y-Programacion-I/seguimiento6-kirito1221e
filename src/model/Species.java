package model;

abstract class Species {
	protected String name;
	protected String scientificName;

	public Species(String name, String scientificName) {
		this.name = name;
		this.scientificName = scientificName;
	}

	public String getName() {
		return name;
	}

	public String getCientificName() {
		return scientificName;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setCientificName(String scientificName) {
		this.scientificName = scientificName;
	}

	public abstract void showDetail(); // Método abstracto para mostrar detalles específicos
}