public class Telephone {
    private int id;
    private String num;

    public Telephone(int id, String num) {
        System.out.println(num.length());
        if(num.length()==10){
            this.id = id;
            this.num = num;
        }
        else{
            System.out.println("erreur taille num");
        }
    }

    public Telephone(){
        this.id=0;
        this.num=null;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNum() {
        return num;
    }

    public void setNum(String num) {
        if(num.length()==10){
            this.num = num;
        }
        else{
            System.out.println("Erreur taille num");
        }
    }
}
