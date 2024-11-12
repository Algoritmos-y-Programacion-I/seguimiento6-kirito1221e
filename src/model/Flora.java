package model;

class Flora extends Species {
    private boolean flowers;
    private boolean fruits;
    private double maxheight;

    

    public Flora(String name, String scientificName, boolean flowers, boolean fruits, double maxheight) {
        super(name, scientificName);
        this.flowers = flowers;
        this.fruits = fruits;
        this.maxheight = maxheight;
    }

   

    public boolean getFlowes() {
        return flowers;
    }



    public void setFlowes(boolean flowes) {
        this.flowers = flowes;
    }



    public boolean Fruits() {
        return fruits;
    }



    public void setFruits(boolean fruits) {
        this.fruits = fruits;
    }



    public double getMaxheight() {
        return maxheight;
    }



    public void setMaxHeight(double maxheight) {
        this.maxheight = maxheight;
    }


    @Override
    public String toString() {
        return "Flora" + "\n Name:" + name + "\n Flowers:" + flowers + "\n ScientificName:" + scientificName + "\n Fruits:"
                + fruits + "\n Maxheight=" + maxheight;
    }



    @Override
    public void showDetail() {
        System.out.println("Flora - Nombre: " + name + ", Nombre Científico: " + scientificName +
                           ", Tiene Flores: " + flowers + ", Tiene Frutas: " + fruits +
                           ", Altura Máxima: " + maxheight + " metros.");
    }
}
