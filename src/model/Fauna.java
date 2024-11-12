package model;

class Fauna extends Species {
    private boolean migration;
    private double weightMax;

   

    public Fauna(String name, String scientificName, boolean migration, double weightMax) {
        super(name, scientificName);
        this.migration = migration;
        this.weightMax = weightMax;
    }



    public boolean getMigration() {
        return migration;
    }



    public void setMigration(boolean migration) {
        this.migration = migration;
    }



    public double getWeightMax() {
        return weightMax;
    }



    public void setWeightMax(double weightMax) {
        this.weightMax = weightMax;
    }

    
    @Override
    public String toString() {
        return "Fauna" + "\nName:" + name + "\n Migration:" + migration + "\n ScientificName:" + scientificName
                + "\n WeightMax:" + weightMax;
    }



    @Override
    public void showDetail() {
        System.out.println("Fauna - Nombre: " + name + ", Nombre Científico: " + scientificName +
                           ", Es Migratoria: " + migration + ", Peso Máximo: " + weightMax + " kg.");
    }
}