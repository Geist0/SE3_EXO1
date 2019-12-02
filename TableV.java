import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import static java.nio.charset.StandardCharsets.US_ASCII;

public class TableV {
    public static String name="Voiture";
    private ArrayList<Voiture> tabV;
    FileChannel f;
    ByteBuffer buf;

    public TableV(String nameFile) throws IOException {
        tabV=new ArrayList<Voiture>();
        f=FileChannel.open(
                FileSystems.getDefault().getPath(nameFile),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        buf=ByteBuffer.allocate(Integer.BYTES+7);
    }


    public void lire() throws IOException {
        f.position(0);
        Voiture v;
        while((v=lireVoiture())!=null)
            System.out.println(v.getId()+"  "+v.getImmat());
    }


    Voiture lireVoiture() throws IOException {

        buf.clear();
        while(buf.hasRemaining())
            if(f.read(buf)==-1)
                return null;

        buf.flip();
        Voiture v=new Voiture();

        v.setId(buf.getInt());
        String x= new String(buf.array(),US_ASCII).substring((4));
        v.setImmat(x);
        return v;
    }

    public void insert(Voiture v) throws IOException {
        buf.clear();
        buf.putInt(v.getId());
        buf.put(v.getImmat().getBytes(US_ASCII));
        buf.flip();
        while(buf.hasRemaining())
            f.write(buf);
    }

    public ArrayList<Voiture> join() throws IOException {
        ArrayList<Voiture> av=new ArrayList<>();
        f.position(0);
        Voiture v;
        while((v=lireVoiture())!=null)
            av.add(v);
        return av;
    }
}
