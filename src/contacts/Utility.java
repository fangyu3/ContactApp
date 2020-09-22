package contacts;

import java.io.*;

public class Utility {

    public static void serialize(Object obj, String fileName) throws IOException {
        if (fileName != null) {
            FileOutputStream fos = new FileOutputStream(fileName,false);
            BufferedOutputStream bos = new BufferedOutputStream(fos);
            ObjectOutputStream oos = new ObjectOutputStream(bos);
            oos.writeObject(obj);
            oos.close();
        }
    }

    public static Object deserialize(String fileName) throws IOException, ClassNotFoundException {
        if (fileName != null) {

            File file = new File(fileName);

            if(file.exists() && file.length()!=0) {
                FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis = new BufferedInputStream(fis);
                ObjectInputStream ois = new ObjectInputStream(bis);
                Object obj = ois.readObject();
                ois.close();
                System.out.println("open " + fileName);
                return obj;
            }
            // Create new file if does not exist
            else
                file.createNewFile();
        }
        return null;
    }
}
