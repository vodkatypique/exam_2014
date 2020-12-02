import java.util.Objects;

public abstract class Vehicule {
    private String immat;
    private int puissance;
    private double conso;
    private Client proprio;

    public Vehicule(String immat, int puissance, double conso) {
            setConso(conso);
            setProprio(null);
            this.immat = immat;
            this.puissance = puissance;
    }

    public void setConso(double conso) {
        if (conso > 2) {
            this.conso = conso;
        }
        else {
            throw new IllegalArgumentException("conso trop faible");
        }
    }

    public double getConso() {
        return conso;
    }

    public int getPuissance() {
        return puissance;
    }

    public String getImmat() {
        return immat;
    }

    @Override
    public String toString() {
        return "immat='" + immat + '\'' +
                ", puissance=" + puissance +
                ", conso=" + conso;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Vehicule vehicule = (Vehicule) o;
        return puissance == vehicule.getPuissance() &&
                Double.compare(vehicule.getConso(), conso) == 0 &&
                Objects.equals(immat, vehicule.getImmat());
    }

    @Override
    public int hashCode() {
        return Objects.hash(immat, puissance, conso);
    }

    public double calculerCout() {
        return this.getPuissance()*2;
    }

    public Client getProprio() {
        return proprio;
    }

    public void setProprio(Client proprio) {
        this.proprio = proprio;
    }
}
