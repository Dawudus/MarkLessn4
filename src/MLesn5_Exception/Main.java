package MLesn5_Exception;


import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.Socket;

/**
 * Created by dustu on 24.05.2016.
 */
public class Main {
    private static int state;

    public boolean openFile(String Path){
        if (Path.isEmpty()){
            state=23;
            return false;
        } else {
            return true;
        }
    }

    public void StOverflow(int i){
        StOverflow(1);
    }

    public static void main(String[] args) {
        Main m= new Main();
//        if (m.openFile("xfgh")) {
//            System.out.println("All is good.");
//        } else {
//            System.out.println("All is bad.");
//        }
//        m.StOverflow(1);
//        Object object=new Object();
//        System.out.println(object);
//        object=null;
//        System.out.println(object.equals(object));
        FileInputStream fileInputStream=null;
        try {
            fileInputStream = new FileInputStream(new File("D://test.txt"));
            m.doSmth(-2);
            //m.chainException();
        } catch (FileNotFoundException | MyException e) {
            System.err.println(e.getMessage());
        } finally {
            if (fileInputStream != null) {
                try {
                    fileInputStream.close();
                    System.err.println("Fis close");
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
        try( Resources resources = new Resources("string");)
        {
            System.err.println(resources);
            resources.setResource("some value");
            System.err.println(resources);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    public void doSmth(int i) throws MyException {
        if (i<0) {
            throw new MyException("Value["+i+"] less than zero.");
        }
    }
    public void chainException() throws MyException {
        Socket socket = new Socket();
        try {
            socket.getOutputStream();
        } catch (IOException e) {
            throw new MyException("Fail", e);
        }
    }
}
