import java.util.Objects;

public class Camion extends Utilitaire {
    private double poids;

    public Camion(String immat, int puissance, double conso, double hauteur, double poids) {
        super(immat, puissance, conso, hauteur);
        this.poids = poids;
    }

    public double getPoids() {
        return poids;
    }

    @Override
    public String toString() {
        return "Camion : " + super.toString() +
                ", poids=" + poids;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        Camion camion = (Camion) o;
        return Double.compare(camion.getPoids(), poids) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), poids);
    }

    @Override
    public double calculerCout() {
        return super.calculerCout() + (this.getPoids()>2000 ? (Math.floor((this.getPoids()-2000)/200)*2) : 0);
    }
}
