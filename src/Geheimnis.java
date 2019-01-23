import javax.swing.*;
import java.io.*;

public class Geheimnis {
    public static void main(String[] args) {
        int choose = Integer.parseInt(JOptionPane.showInputDialog("Press 1 to Sign in, Press 2 to Register, Press 3 to Cancel"));
        while (true) {
            if (choose == 1) {
                String user = JOptionPane.showInputDialog("Enter Username");
                String pw = JOptionPane.showInputDialog("Enter Password");
                try {
                    System.out.println(login(user, pw));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            } else if (choose == 2) {
                String user = JOptionPane.showInputDialog("Enter Name");
                String pw = JOptionPane.showInputDialog("Enter Pw");
                try {
                    createUser(user, pw);
                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    break;
                }
            } else break;

        }
    }
    public static void createUser(String user, String pw) throws IOException {
        File store = new File("C:\\Users\\Trollzor\\Desktop\\" + user + ".txt");
        if (store.exists()) {
            System.out.println("not valid");
        } else {
            store.createNewFile();
            FileWriter fw = new FileWriter(store);
            BufferedWriter bw = new BufferedWriter(fw);
            bw.write(pw);
            bw.close();
            System.out.println("Ready");
        }
    }


    public static String login(String user, String pw) throws IOException {
        File store = new File("C:\\Users\\Trollzor\\Desktop\\" + user + ".txt");
        if (!store.exists()) return "useless user";
        FileReader fr = new FileReader(store);
        BufferedReader br = new BufferedReader(fr);
        String pwc = br.readLine();
        br.close();
        if ((pwc.equals(pw))) return "Geheimnis.";
        else return "Sucks to be you pw";

    }
}




