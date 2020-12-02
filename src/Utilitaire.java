import java.util.Objects;

public abstract class Utilitaire extends Vehicule {
    private double hauteur;
    private final double calculerCout = 30;

    public Utilitaire(String immat, int puissance, double conso, double hauteur) {
        super(immat, puissance, conso);
        this.hauteur = hauteur;
    }

    public double getHauteur() {
        return hauteur;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", hauteur=" + hauteur;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Utilitaire that = (Utilitaire) o;
        return Double.compare(that.getHauteur(), hauteur) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), hauteur);
    }

    @Override
    public double calculerCout() {
        return super.calculerCout()+this.calculerCout;
    }
}
