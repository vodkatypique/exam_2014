public class Voiture extends Vehicule {
    private final double calculerCout = 20;
    public Voiture(String immat, int puissance, double conso){
        super(immat, puissance, conso);
    }

    @Override
    public String toString() {
        return "Voiture : " + super.toString();
    }

    @Override
    public double calculerCout() {
        return super.calculerCout()+calculerCout;
    }

}
