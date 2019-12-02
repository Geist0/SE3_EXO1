public class Voiture {
    private int id;
    private String immat;

    public Voiture(int id, String immat) {
        if (immat.length()==7){
            this.id = id;
            this.immat = immat;
        }
        else{
            System.out.println("erreur taille immat");
        }
    }

    public Voiture (){
        this.id=0;
        this.immat=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImmat() {
        return immat;
    }

    public void setImmat(String immat) {
        if(immat.length()==7){
            this.immat = immat;
        }
        else{
            System.out.println("erreur taille immat");
        }
    }
}
