import javax.xml.soap.Node;

public class Arco<V,E> {

    private Vertice origin;
    private Vertice destination;
    private double distance;

    public Arco(Vertice origin, Vertice destination, double distance) {
        this.origin = origin;
        this.destination = destination;
        this.distance = distance;
    }

    public Vertice getOrigin() {
        return origin;
    }

    public void setOrigin(Vertice origin) {
        this.origin = origin;
    }

    public Vertice getDestination() {
        return destination;
    }

    public void setDestination(Vertice destination) {
        this.destination = destination;
    }

    public double getDistance() {
        return distance;
    }

    public void setDistance(double distance) {
        this.distance = distance;
    }

    @Override
    public String toString() {
        return "\n Edge [origin=" + origin.getCity() + ", destination=" + destination.getCity() + ", distance="
                + distance + "]";
    }


}
