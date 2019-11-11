package mooc;

public class Sekuntikello {

    private Viisari sekunnit;
    private Viisari sadasosasekunnit;

    public Sekuntikello() {
        this.sekunnit = new Viisari(60);
        this.sadasosasekunnit = new Viisari(100);
    }

    public void etene() {
        this.sadasosasekunnit.etene();

        if (this.sadasosasekunnit.arvo() == 0) {
            this.sekunnit.etene();

        }
    }

    public String toString() {
        return sekunnit + ":" + sadasosasekunnit;
    }
}

