//import com.sun.xml.internal.ws.util.StringUtils;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.lang.NullPointerException;
import java.util.Arrays;
import java.util.InputMismatchException;

/**
 *
 * @author shiza
 */
public class TahaBMS {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {

        Scanner kb = new Scanner(System.in);
        File dressfile = new File("d.txt");
        dressfile.createNewFile();

        File customerfile = new File("c.txt");
        customerfile.createNewFile();

        System.out.println("\n*********************************************");

        File recieptfile = new File("r.txt");
        customerfile.createNewFile();
        mainmenu(dressfile, customerfile, recieptfile);

    }
    static Scanner overallKB = new Scanner(System.in);

    public static void mainmenu(File dressfile, File customerfile, File recieptfile) throws IOException {
        int s = 1, s1 = 1;
        Scanner kb = new Scanner(System.in);
        String maincheck = "4";
        boolean b = true;

        while (b) {
            System.out.println("BOTIQUE MANAGEMENT SYSTEM!!\n Enter your option\n 1)DRESS record\n 2)CUSTOMERS record\n 3)RECIEPT\n 4)exit.");
            System.out.println("\n*********************************************");
            System.out.print("Enter Your Choice:");
            maincheck = kb.next();
            System.out.println("\n*********************************************");
            if (maincheck.charAt(0) == '4' && (maincheck.length() == 1)) {
                System.out.println("EXITING!!");
                return;
            }
            switch (maincheck) {
                case "1":
                    dressmain(dressfile, s);
                    break;

                case "2":
                    customerfile = customermain(customerfile, s1);
                    break;
                case "3":
                    recieptfile = recieptmain(recieptfile, s1, dressfile, customerfile);
                    break;
                default:
                    System.out.println("Enter correct option \n");
                    break;

            }
        }

    }

    public static File dressmain(File dressfile, int s) throws IOException, FileNotFoundException, InputMismatchException {
        Scanner kb = new Scanner(System.in);
        String check;
        boolean b = true;
        int ck = 0;
        if (dressfile.length() != 0) {
            ck++;           //This check assures that data exists in the File and is not empty.     
        }
        while (b) {

            System.out.println("\n*********************************************");
            System.out.println("DRESS RECORD SYSTEM!!\n Enter your option\n 1)Add records\n 2)View records\n 3)Search records\n 4)Update record\n 5)Delete record\n 6)Sort records.\n 7)exit.");
            System.out.println("\n*********************************************");
            System.out.print("Enter Your Choice:");
            check = kb.next();
            System.out.println("\n*********************************************");
            if (check.charAt(0) == '7' && (check.length() == 1)) {
                System.out.println("EXITING DRESS MENU SYSTEM");
                return dressfile;
            } else if ((check.equals("2") || check.equals("3") || check.equals("4") || check.equals("5") || check.equals("6")) && ck == 0) {
                System.out.println("'Enter Records First'\n");
                continue;
            }
            switch (check) {
                case "1":
                    dadd(dressfile, s);
                    ck++;
                    break;
                case "2":

                    BufferedReader a = new BufferedReader(new FileReader(dressfile.getAbsolutePath()));
                    Scanner input = new Scanner(dressfile);
                    System.out.println("=========================================================================================");
                    System.out.println("DRESS_ID\tSIZE\t\tPRICE\t\tDESIGNER\tCOLOUR\t\tQUANTITY");
                    System.out.println("=========================================================================================");
                    String string = a.readLine();
                    dview(dressfile, string, a);
                    input.close();
                    break;
                case "3":
                    System.out.print("enter ID of record you want to see:");
                    int regno = correctOption();
                    BufferedReader a1 = new BufferedReader(new FileReader(dressfile.getAbsolutePath()));
                    Scanner input1 = new Scanner(dressfile);
                    System.out.println("=========================================================================================");
                    System.out.println("DRESS_ID\tSIZE\t\tPRICE\t\tDESIGNER\tCOLOUR\t\tQUANTITY");
                    System.out.println("=========================================================================================");
                    String string1 = a1.readLine();
                    dsearch(dressfile, string1, regno, a1);
                    break;
                case "4":
                    System.out.print("enter ID of record you want to update:");
                    regno = correctOption();
                    dressfile = dupdate(dressfile, regno);
                    break;
                case "5":
                    System.out.print("enter ID of record you want to delete:");
                    regno = correctOption();
                    File del = new File("update.txt");
                    a = new BufferedReader(new FileReader(dressfile.getAbsolutePath()));
                    input = new Scanner(dressfile);
                    string1 = a.readLine();
                    FileWriter r = new FileWriter(del, true);
                    BufferedWriter ap = new BufferedWriter(r);
                    dressfile = ddelete(dressfile, del, regno, string1, a, ap);
                    break;

                case "6":
                    boolean sortflag = true;

                    BufferedReader freader = new BufferedReader(new FileReader(dressfile.getAbsolutePath()));
                    int length = 0;

                    while (sortflag) {
                        String sortstring = freader.readLine();
                        if (sortstring == null) {
                            sortflag = false;
                            continue;
                        }
                        length++;
                    }
                    dressfile = dsort(dressfile, length);
                    break;

                default:
                    System.out.println("enter correct option");
                    break;
            }
            continue;
            //continue;
        }

        return dressfile;
    }

    public static boolean unique(int id, File f) throws IOException, NullPointerException {
        try {
            boolean unique = false;
            BufferedReader a = new BufferedReader(new FileReader(f.getAbsolutePath()));
            Scanner input = new Scanner(f);

            String s = a.readLine();

            while (input.hasNextLine()) {
                String st[] = s.split("\t");
                if ((Integer.parseInt(st[0])) == id) {
                    return unique = true;
                }
                s = a.readLine();
            }
            input.close();
            a.close();
            return unique;

        } catch (java.lang.NullPointerException ex) {
            System.out.print("");
        }
        return false;
    }

    public static File dadd(File dressfile, int s) throws IOException {
        try {
            Scanner kb = new Scanner(System.in);
            System.out.print("\nADDING RECORDS!!");
            FileWriter r = new FileWriter(dressfile, true);
            BufferedWriter ap = new BufferedWriter(r);

            String input = "y";

            while ((input.charAt(0) == 'y' || input.charAt(0) == 'Y') && input.length() == 1) {
//r.writenewLine();
                r = new FileWriter(dressfile, true);
                ap = new BufferedWriter(r);
                System.out.println("RECORD NO:" + s);
                System.out.print("enter dress id:");
                int id = correctOption();
                if (s == 0) {
                    ap.write(id + "\t");
                } else {
                    if (unique(id, dressfile) == true) {
                        System.out.print("enter unique id no");
                        continue;
                    } else {
                        ap.write(id + "\t");
                    }
                }
                System.out.print("enter dress size:");
                char c = kb.next().charAt(0);
                while (c != 's' && c != 'm' && c != 'l') {
                    System.out.print("enter sizes only s,m,l: ");
                    c = kb.next().charAt(0);
                }
                ap.write(c + "\t");
                System.out.print("enter dress price:");
                int b = correctOption();
                ap.write(b + "\t");
                System.out.print("enter dress designer:");
                ap.write(kb.next() + "\t");
                System.out.print("enter dress colour:");
                ap.write(kb.next() + "\t");
                System.out.print("enter dress quantity:");
                int a = correctOption();
                ap.write(a + "\t");
                ap.newLine();
                s++;
                System.out.println("do you want to continue? if yes enter y: ");
                input = kb.next();
                ap.close();
            }
        } catch (Exception e) {
            System.out.println("incorrect data");
        }
        return dressfile;
    }

    public static void dview(File f, String s, BufferedReader a) throws IOException, NullPointerException {
        if (s == null) {
            return;
        }
        String[] st = s.split("\t");
        for (int i = 0; i < st.length; i++) {
            System.out.print(st[i] + "\t\t");
        }
        System.out.println();
        s = a.readLine();

        dview(f, s, a);
        return;
    }

    public static void dsearch(File f, String s, int regno, BufferedReader a) throws IOException, NullPointerException {
        if (s == null) {
            return;
        }
        String[] st = s.split("\t");
        if ((Integer.parseInt(st[0])) == regno) {
            for (int i = 0; i < st.length; i++) {
                System.out.print(st[i] + "\t\t");

            }
            System.out.println();
            dsearch(f, null, regno, a);
        }

        s = a.readLine();

        dsearch(f, s, regno, a);
        return;

    }

    public static File dupdate(File dressfile, int regno) throws IOException, NullPointerException {
        File del = new File("updated.txt");
        BufferedReader a = new BufferedReader(new FileReader(dressfile.getAbsolutePath()));
        Scanner k = new Scanner(System.in);
        Scanner input = new Scanner(dressfile);
        //String s = a.readLine();
        //String[] st = s.split("\t");
        System.out.print("enter the record you want to update:\n 1)update size.\n 2)update price.\n 3)update designer.\n 4)update colour.\n 5)update quantity.");
        int choice = correctOption();
        FileWriter r = new FileWriter(del, true);
        BufferedWriter ap = new BufferedWriter(r);
        try {
            String regs = Integer.toString(regno);
            boolean b = true;
            while (b) {
                String s = a.readLine();
                if (s == null) {
                    b = false;
                    continue;
                }
                String[] st = s.split("\t");
                if (st[0].equals(regs)) {

                    switch (choice) {
                        case 1:
                            System.out.print("enter dress size:");
                            char c = k.next().charAt(0);
                            while (c != 's' && c != 'm' && c != 'l') {
                                System.out.print("enter sizes only s,m,l");
                                c = k.next().charAt(0);

                            }
                            st[1] = Character.toString(c);
                            break;

                        case 2:
                            System.out.print("enter dress price:");
                            st[2] = Integer.toString(correctOption());
                            break;
                        case 3:
                            System.out.print("enter dress designer:");
                            st[3] = k.next();
                            break;

                        case 4:
                            System.out.print("enter dress colour:");
                            st[4] = k.next();
                            break;
                        case 5:
                            System.out.print("enter dress quantity:");
                            st[5] = Integer.toString(correctOption());
                            break;
                        default:
                            System.out.print("enter correct option");
                            break;
                    }
                    s = String.join("\t", st);
                }
                ap.write(s);
                ap.newLine();
            }
            input.close();
            a.close();
            ap.close();
            PrintWriter pw = new PrintWriter(dressfile);
            BufferedWriter bw = new BufferedWriter(pw);
            BufferedReader c = new BufferedReader(new FileReader(del.getAbsolutePath()));
            b = true;
            String string = null;
            pw.write("");
            while (b) {
                string = c.readLine();
                if (string == null) {
                    b = false;
                    continue;
                }
                bw.write(string);
                bw.newLine();
            }
            PrintWriter pwdel = new PrintWriter(del);
            pwdel.write("");
            pwdel.close();
            c.close();
            bw.close();
            pw.close();
            return dressfile;
        } catch (NullPointerException ex) {
            System.out.print("");
        }
        return del;
    }

    public static File ddelete(File f, File del, int regno, String s, BufferedReader a, BufferedWriter bwriter) throws IOException, NullPointerException {
        try {
           
            if (s == null) {
                a.close();
                bwriter.close();
                PrintWriter pw = new PrintWriter(f);
                BufferedWriter bw = new BufferedWriter(pw);
                BufferedReader c = new BufferedReader(new FileReader(del.getAbsolutePath()));
                boolean b = true;
                String string = null;
                pw.write("");
                while (b) {
                    string = c.readLine();
                    if (string == null) {
                        b = false;
                        continue;
                    }
                    bw.write(string);
                    bw.newLine();
                }
                PrintWriter pwdel = new PrintWriter(del);
                pwdel.write("");
                pwdel.close();
                c.close();
                bw.close();
                pw.close();
                return f;
            }
            String[] st = s.split("\t");
            if ((Integer.parseInt(st[0])) == regno) {
                s = a.readLine();
                
            }
            bwriter.write(s);
            bwriter.newLine();
            s = a.readLine();
            ddelete(f, del, regno, s, a, bwriter);
        } catch (NullPointerException ex) {
            System.out.print("");
        }
        return f;
    }

    public static File dsort(File f, int length) throws IOException {
        File sort = new File("sort.txt");
        sort.createNewFile();
        int[] list = new int[length];
        BufferedReader a = new BufferedReader(new FileReader(f.getAbsolutePath()));
        Scanner input = new Scanner(f);
        FileWriter r = new FileWriter(sort, true);
        BufferedWriter ap = new BufferedWriter(r);
        boolean b = true;
        String s = null;
        int i = 0, temp = 0;
        while (b) {

            s = a.readLine();
            if (s == null) {
                b = false;
                continue;
            }
            String st[] = s.split("\t");
            list[i] = Integer.parseInt(st[0]);
            i++;
        }
        b = true;
        for (int k = 0; k < list.length; k++) {
            for (int j = k + 1; j < list.length; j++) {
                if (list[k] > list[j]) {
                    temp = list[k];
                    list[k] = list[j];
                    list[j] = temp;
                }
            }
        }
        i = 0;
        a.close();
        a = new BufferedReader(new FileReader(f.getAbsolutePath()));
        while (b) {
            s = a.readLine();
            if (s == null) {
                b = false;
                continue;
            }
            String st[] = s.split("\t");
            if (i == list.length) {
                b = false;
                continue;
            }
            if (Integer.parseInt(st[0]) == list[i] && i != list.length) {
                ap.write(s);
                ap.newLine();
                i++;
                a.close();
                a = new BufferedReader(new FileReader(f.getAbsolutePath()));
            }
        }
        ap.close();
        input.close();
        a.close();
        PrintWriter pw = new PrintWriter(f);
        BufferedWriter bw = new BufferedWriter(pw);
        BufferedReader c = new BufferedReader(new FileReader(sort.getAbsolutePath()));
        b = true;
        String string = null;
        pw.write("");
        while (b) {
            string = c.readLine();
            if (string == null) {
                b = false;
                continue;
            }
            bw.write(string);
            bw.newLine();
        }
        PrintWriter pwsort = new PrintWriter(sort);
        pwsort.write("");
        pwsort.close();
        c.close();
        bw.close();
        pw.close();
        return f;
    }

    public static File customermain(File customerfile, int s) throws IOException, FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        String check;
        boolean b = true;
        int ck = 0;
        if (customerfile.length() != 0) {
            ck++;           //This check assures that data exists in the File and is not empty.     
        }
        while (b) {
            System.out.println("\n*********************************************");
            System.out.println("CUSTOMERS RECORD SYSTEM!!\n Enter your option\n 1)Add records\n 2)View records\n 3)Search records\n 4)Update record\n 5)Delete record\n 6)Sort records.\n 7)exit.");
            System.out.println("\n*********************************************");
            System.out.print("Enter Your Choice:");
            check = kb.next();
            System.out.println("\n*********************************************");
            if (check.charAt(0) == '7' && (check.length() == 1)) {
                System.out.println("EXITING CUSTOMER MENU SYSTEM");
                return customerfile;
            } else if ((check.equals("2") || check.equals("3") || check.equals("4") || check.equals("5") || check.equals("6")) && ck == 0) {
                System.out.println("'Enter Records First'\n");
                continue;
            }
            switch (check) {
                case "1":
                    cadd(customerfile, s);
                    ck++;
                    break;
                case "2":
                    BufferedReader a = new BufferedReader(new FileReader(customerfile.getAbsolutePath()));
                    Scanner input = new Scanner(customerfile);
                    System.out.println("=========================================================================================");
                    System.out.println("CUSTOMER_ID\tNAME\t\tPHONE_NO\t\tEMAIL\t\t\t  GENDER");
                    System.out.println("=========================================================================================");
                    String string = a.readLine();
                    dview(customerfile, string, a);
                    input.close();
                    break;
                case "3":
                    System.out.print("enter ID of record you want to see:");
                    int regno = correctOption();
                    BufferedReader a1 = new BufferedReader(new FileReader(customerfile.getAbsolutePath()));
                    Scanner input1 = new Scanner(customerfile);
                    System.out.println("=========================================================================================");
                    System.out.println("CUSTOMER_ID\tNAME\t\tPHONE_NO\t\tEMAIL\tGENDER");
                    System.out.println("=========================================================================================");
                    String string1 = a1.readLine();
                    dsearch(customerfile, string1, regno, a1);
                    break;

                case "4":
                    System.out.print("enter ID of record you want to update:");
                    regno = correctOption();
                    customerfile = cupdate(customerfile, regno);
                    break;
                case "5":

                    System.out.print("enter ID of record you want to delete:");
                    regno = correctOption();
                    File del = new File("update.txt");
                    a = new BufferedReader(new FileReader(customerfile.getAbsolutePath()));
                    input = new Scanner(customerfile);
                    string1 = a.readLine();
                    FileWriter r = new FileWriter(del, true);
                    BufferedWriter ap = new BufferedWriter(r);
                    customerfile = ddelete(customerfile, del, regno, string1, a, ap);
                    break;

                case "6":
                    boolean sortflag = true;
                    BufferedReader freader = new BufferedReader(new FileReader(customerfile.getAbsolutePath()));
                    int length = 0;
                    while (sortflag) {
                        String sortstring = freader.readLine();
                        if (sortstring == null) {
                            sortflag = false;
                            continue;
                        }
                        length++;
                    }
                    customerfile = dsort(customerfile, length);
                    break;
                default:
                    System.out.println("enter correct option");
                    break;
            }
        }
        return customerfile;
    }

    public static File cadd(File customerfile, int s) throws IOException {
        try {
            Scanner kb = new Scanner(System.in);
            System.out.print("\nADDING RECORDS!!");
            FileWriter r = new FileWriter(customerfile, true);
            BufferedWriter ap = new BufferedWriter(r);

            String input = "y";
            while ((input.charAt(0) == 'y' || input.charAt(0) == 'Y') && input.length() == 1) {
                r = new FileWriter(customerfile, true);
                ap = new BufferedWriter(r);
                System.out.println("RECORD NO:" + s);
                System.out.print("enter customer id:");
                int id = correctOption();
                if (s == 0) {
                    ap.write(id + "\t");
                } else {
                    if (unique(id, customerfile) == true) {
                        System.out.print("enter unique id no");
                        continue;
                    } else {
                        ap.write(id + "\t");
                    }
                }
                System.out.print("enter customer name:");
                ap.write(kb.next() + "\t");
                System.out.print("enter customer phone:");
                ap.write(correctOption() + "\t");
                System.out.print("enter customer email:");
                ap.write(kb.next() + "\t");
                System.out.print("enter customer gender:");
                ap.write(kb.next());
                ap.newLine();
                s++;
                System.out.println("do you want to continue? if yes enter y: ");
                input = kb.next();
                ap.close();
            }
        } catch (Exception e) {
            System.out.println("incorrect data");
        }
        return customerfile;
    }

    public static File cupdate(File customerfile, int regno) throws IOException, NullPointerException {
        File del = new File("updated.txt");
        BufferedReader a = new BufferedReader(new FileReader(customerfile.getAbsolutePath()));
        Scanner k = new Scanner(System.in);
        Scanner input = new Scanner(customerfile);
        System.out.print("enter the record you want to update:\n 1)update name.\n 2)update phonenumber.\n 3)update email.\n 4)update gender.");
        int choice = correctOption();
        FileWriter r = new FileWriter(del, true);
        BufferedWriter ap = new BufferedWriter(r);
        try {
            String regs = Integer.toString(regno);
            boolean b = true;
            while (b) {
                String s = a.readLine();
                if (s == null) {

                    b = false;
                    continue;
                }
                String[] st = s.split("\t");
                if (st[0].equals(regs)) {

                    switch (choice) {
                        case 1:
                            System.out.print("enter customers name:");

                            st[1] = k.next();
                            break;

                        case 2:
                            System.out.print("enter customer phonenumber:");
                            st[2] = Integer.toString(correctOption());
                            break;
                        case 3:
                            System.out.print("enter customers email:");
                            st[3] = k.next();
                            break;

                        case 4:
                            System.out.print("enter customers gender:");
                            st[4] = k.next();
                            break;
                        default:
                            System.out.print("enter correct option");
                            break;
                    }
                    s = String.join("\t", st);
                }
                ap.write(s);
                ap.newLine();
            }
            input.close();
            a.close();
            ap.close();
            PrintWriter pw = new PrintWriter(customerfile);
            BufferedWriter bw = new BufferedWriter(pw);
            BufferedReader c = new BufferedReader(new FileReader(del.getAbsolutePath()));
            b = true;
            String string = null;
            pw.write("");
            while (b) {
                string = c.readLine();
                if (string == null) {
                    b = false;
                    continue;
                }
                bw.write(string);
                bw.newLine();
            }
            c.close();
            bw.close();
            pw.close();
            return customerfile;
        } catch (NullPointerException ex) {
            System.out.print("");
        }
        return customerfile;
    }

    public static File recieptmain(File recieptfile, int s, File dressfile, File customerfile) throws IOException, FileNotFoundException {
        Scanner kb = new Scanner(System.in);
        String check;
        boolean b = true;
        try {
            while (b) {
                System.out.println("\n*********************************************");
                System.out.println("RECIEPT RECORD SYSTEM!!\n Enter your option\n 1)Add records\n 2)View records\n 3)Search records\n 4)exit");
                System.out.println("\n*********************************************");
                System.out.print("Enter Your Choice:");
                check = kb.next();
                System.out.println("\n*********************************************");
                if (check.charAt(0) == '4' && (check.length() == 1)) {
                    System.out.println("EXITING RECIEPT MENU SYSTEM");
                    return recieptfile;
                }
                switch (check) {
                    case "1":
                        System.out.print("Enter your id:");
                        int customerid = correctOption();
                        System.out.print("Enter dress id:");
                        int dressid = correctOption();
                        recieptfile = recieptrecord(dressfile, customerfile, customerid, recieptfile, dressid);
                        break;
                    case "2":
                        BufferedReader a = new BufferedReader(new FileReader(recieptfile.getAbsolutePath()));
                        Scanner input = new Scanner(recieptfile);
                        System.out.println("=========================================================================================");
                        System.out.println("CUSTOMER_ID\tDRESS_ID\t\tQUANTITY\t\tPRICE");
                        System.out.println("=========================================================================================");
                        String string = a.readLine();
                        dview(recieptfile, string, a);
                        input.close();
                        break;
                    case "3":
                        System.out.print("enter ID of dress record you want to see:");
                        int regno = correctOption();
                        System.out.print("enter ID of customer record you want to see:");
                        int customerregno = correctOption();
                        BufferedReader a1 = new BufferedReader(new FileReader(recieptfile.getAbsolutePath()));

                        Scanner input1 = new Scanner(customerfile);
                        System.out.println("=========================================================================================");
                        System.out.println("CUSTOMER_ID\tDRESS_ID\tPRICE");
                        System.out.println("=========================================================================================");
                        String string1 = a1.readLine();

                        recieptsearch(recieptfile, string1, regno, customerregno, a1);
                        a1.close();
                        break;
                    default:
                        System.out.println("enter correct option");
                        break;
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Does not Exists.");
            System.out.println("*********************************************\n");
        }
        return recieptfile;
    }
    
    //recieptrecord(dressfile, customerfile, customerid, recieptfile, dressid);

    public static File recieptrecord(File f, File c, int cid, File r, int did) throws IOException {
        FileWriter fw = new FileWriter(r, true);
        BufferedWriter ap = new BufferedWriter(fw);
        Scanner kb = new Scanner(System.in);
        boolean bcid = idsearch(c, cid);
        boolean bdid = idsearch(f, did);
        boolean quan;
        int price;
        if (bcid && bdid) {
            System.out.print("enter quantity:");
            int quantity = correctOption();
            if (searchquantity(f, did) == true) {
                System.out.print("dress out of stock");
                return r;
            }
            while (searchquan(f, did, quantity) == false) {
                System.out.print("enter quantity:");
                quantity = correctOption();
            }

            ap.write(cid + "\t" + did + "\t");
            ap.write(Integer.toString(quantity) + "\t");
            price = searchprice(f, did, quantity);
            ap.write(Integer.toString(price));
            ap.newLine();
            updatequantity(f, did, quantity);

        }
        if (bcid == false && bdid == true) {
            System.out.print("Enter records first");
            return r;
        } if(bcid == false && bdid == false){
            System.out.print("dress not available");
        }
        ap.close();

        return r;
    }

    //
  //This method is used to copy Files from and to Files
    public static void copyFileAToFileB(File a,File b) throws FileNotFoundException {
    	Scanner scA=new Scanner(a);
    	PrintWriter pwB= new PrintWriter(b);
    	while(scA.hasNext()) {
    		String line=scA.nextLine();
    		pwB.println(line);
    	}
    	scA.close();pwB.close();
    }
    
    public static void updatequantity(File dressfile,int regno,int quantity) throws IOException {
    	File tempFile = new File("tempFile.txt");
        if(tempFile.createNewFile()){
        }else System.out.print("");
        PrintWriter pwTemp=new PrintWriter(tempFile);
        Scanner dressScanner= new Scanner(dressfile);
        String line;
        while(dressScanner.hasNext()) {
        	line=dressScanner.nextLine();
        	String[] splitLine=line.split("\t");
        	int toChange;
        	int regnoB= Integer.valueOf(splitLine[0]);
        	if(regno==regnoB) {
        		toChange=Integer.valueOf(splitLine[5])-quantity;
        		splitLine[5]=String.valueOf(toChange);
        	}
        	for(int i=0;i<splitLine.length;i++) pwTemp.print(splitLine[i]+"\t");
			pwTemp.println("");
        }
        pwTemp.close();
        dressScanner.close();
    	copyFileAToFileB(tempFile,dressfile);
    }
    
   /* public static void updatequantity(File dressfile, int regno, int quantity) throws IOException {
         File newFile = new File("tmp.txt");
        newFile.createNewFile();//create a new file in which selected data is to be copied
        //String[] a;
        try (PrintWriter out = new PrintWriter(new FileWriter(newFile, true))) {
            try {
                BufferedReader reader;
                reader = new BufferedReader(new FileReader(dressfile));

                String line;
                while (true) {
                    line = reader.readLine();
                    if (line == null) {
                        break;
                    }
                    String[] a = line.split("\t");
                    if (Integer.parseInt(a[0])==(regno)) {
                        a[5] =Integer.toString((Integer.parseInt(a[5]))-quantity) ;
                        System.out.print(a[5]);
                        String paste = "";
                        for (int i = 0; i < a.length; i++) {
                            paste = paste + a[i] + "\t";
                        }
                        out.println(paste);
                        

                    } else if (!(Integer.parseInt(a[0])==(regno))){
                        System.out.print("abcccc");
                        out.println(line);
                    }
                }
                reader.close();
dressfile.delete();
        File dump = new File("d.txt");
        newFile.renameTo(dump);
            } catch (IOException E) {
                System.out.println("Error Occured");
            }

        } catch (IOException E) {
            System.out.println("Error");
        }
        //[deleting the old file and then renaming the new file to old file name]
        
    
               */
   // }
   
    public static boolean idsearch(File file, int id) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(file.getAbsolutePath()));
        boolean b = true;

        while (b) {
            String s = br.readLine();
            if (s == null) {
                b = false;
                continue;
            }
            String[] st = s.split("\t");

            if ((Integer.parseInt(st[0])) == id) {
                return true;
            }
        }
        br.close();

        return false;
    }

    public static boolean searchquan(File f, int id, int q) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
        boolean b = true;
        while (b) {
            String s = br.readLine();
            if (s == null) {
                b = false;
                continue;
            }
            String[] st = s.split("\t");
            if ((Integer.parseInt(st[0])) == id) {
                if ((Integer.parseInt(st[5])) >= q) {
                    return true;
                }

            }

        }

        br.close();
        return false;
    }

    public static int searchprice(File f, int id, int quantity) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(f.getAbsolutePath()));
        boolean b = true;
        int price = 0;
        while (b) {
            String s = br.readLine();
            if (s == null) {
                b = false;
                continue;
            }
            String[] st = s.split("\t");
            if ((Integer.parseInt(st[0])) == id) {
                price = Integer.parseInt(st[2]) * quantity;
                System.out.print(Integer.parseInt(st[2]) + " " + quantity);
                return price;
            }

        }
        br.close();
        return price;
    }

    public static void recieptsearch(File recieptfile, String string, int regno, int customerregno, BufferedReader a) throws IOException {
       if (string == null) {
           
            
            return;
        }
        String[] st = string.split("\t");

        if (((Integer.parseInt(st[0])) == customerregno) && ((Integer.parseInt(st[1])) == regno)) {
            for (int i = 0; i < st.length; i++) {
                System.out.print(st[i] + "\t\t");
            }
            recieptsearch(recieptfile, null, regno, customerregno, a);
            
        }
        System.out.println();
        string = a.readLine();

        recieptsearch(recieptfile, string, regno,customerregno, a);
        

    }

    public static boolean searchquantity(File dressfile, int did) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader(dressfile.getAbsolutePath()));
        boolean b = true;
        while (b) {
            String s = br.readLine();
            if (s == null) {
                b = false;
                continue;
            }
            String[] st = s.split("\t");
            if ((Integer.parseInt(st[0])) == did) {
                if ((Integer.parseInt(st[5])) == 0) {
                    return true;
                }

            }

        }

        br.close();
        return false;

    }

    public static boolean isNumber(String s) {
        for (int i = 0; i < s.length(); i++) {
            if (!(s.charAt(i) >= '0' && s.charAt(i) <= '9')) {
                return false;
            }
        }
        return true;
    }

    public static int correctOption() {
        String opt;
        int i;
        while (true) {
            opt = overallKB.nextLine();
            try {
                if (!isNumber(opt)) {
                    throw new Exception("Not Integer: ");
                }
                break;
            } catch (Exception ex) {
                System.out.print("Enter Correct Integer: ");
            }
        }
        return Integer.valueOf(opt);
    }
}
