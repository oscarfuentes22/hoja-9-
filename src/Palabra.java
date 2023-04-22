public class Palabra implements Comparable<Palabra>{
    private String palabraEsp;
    private String palabraIng;
    private String tipo;

    public Palabra(String palabraEsp, String palabraIng, String tipo) {
        this.palabraEsp = palabraEsp;
        this.palabraIng = palabraIng;
        this.tipo = tipo;
    }
    public Palabra(String palabraIng){
        this.palabraIng = palabraIng;
    }


    public String getPalabraIng() {
        return palabraIng;
    }

    public void setPalabraIng(String palabraIng) {
        this.palabraIng = palabraIng;
    }
    public String getPalabraEsp() {
        return palabraEsp;
    }

    public void setPalabraEsp(String palabraEsp) {
        this.palabraEsp = palabraEsp;
    }
    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    @Override
    public int compareTo(Palabra o) {
        return this.palabraIng.compareTo(o.palabraIng);
    }
}
