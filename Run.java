import java.io.IOException;
import java.util.ArrayList;

public class Run {

    public static void join(ArrayList<Voiture> v,ArrayList<Telephone> t){
        for (Telephone tel: t){
            for (Voiture voit:v){
                if (tel.getId()==voit.getId()){
                    System.out.println(tel.getId()+" |Immatriculation :"+voit.getImmat()+ " [Numero de telephone :"+tel.getNum());
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {

        Telephone t1=new Telephone(1,"0101010101");
        Telephone t2=new Telephone(2,"01010101");
        TableT t=new TableT("telephone.db");
        t.insert(t1);
        t.lire();
        ArrayList<Telephone> at=t.join();


        Voiture v1=new Voiture(1,"AA123AA");
        Voiture v2=new Voiture(3,"AA123AA");
        Voiture v3=new Voiture(4,"AA123");
        TableV v=new TableV("voiture.db");
        v.insert(v1);
        v.insert(v2);
        v.lire();
        ArrayList<Voiture> av=v.join();

        join(av,at);
    }
}
