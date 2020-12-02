public class Fourgonnette extends Utilitaire {
    public Fourgonnette(String immat, int puissance, double conso, double hauteur) {
        super(immat, puissance, conso, hauteur);
    }

    @Override
    public String toString() {
        return "Fourgonnette : " + super.toString();
    }
}
