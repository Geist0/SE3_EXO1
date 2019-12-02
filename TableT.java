import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.file.FileSystems;
import java.nio.file.StandardOpenOption;
import java.util.ArrayList;
import static java.nio.charset.StandardCharsets.US_ASCII;

public class TableT {
    public static String name="Telephone";
    private ArrayList<Telephone> tabT;
    FileChannel f;
    ByteBuffer buf;

    public TableT(String nameFile) throws IOException {
        tabT=new ArrayList<Telephone>();
        f=FileChannel.open(
                FileSystems.getDefault().getPath(nameFile),
                StandardOpenOption.READ,
                StandardOpenOption.WRITE,
                StandardOpenOption.CREATE);
        buf=ByteBuffer.allocate(Integer.BYTES+10);
    }


    public void lire() throws IOException {
        f.position(0);
        Telephone t;
        while((t=lireTelephone())!=null)
            System.out.println(t.getId()+"  "+t.getNum());
    }


    Telephone lireTelephone() throws IOException {

        buf.clear();
        while(buf.hasRemaining())
            if(f.read(buf)==-1)
                return null;

        buf.flip();
        Telephone t=new Telephone();

        t.setId(buf.getInt());
        String x= new String(buf.array(),US_ASCII).substring((4));
        t.setNum(x);
        return t;
    }

    public void insert(Telephone t) throws IOException {
        buf.clear();
        buf.putInt(t.getId());
        buf.put(t.getNum().getBytes(US_ASCII));
        buf.flip();
        while(buf.hasRemaining())
            f.write(buf);
    }

    public ArrayList<Telephone> join() throws IOException {
        ArrayList<Telephone> at=new ArrayList<>();
        f.position(0);
        Telephone t;
        while((t=lireTelephone())!=null)
            at.add(t);
        return at;
    }
}
