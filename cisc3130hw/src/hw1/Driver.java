package abccompany;

import java.io.*;
import java.util.ArrayList;

public class Driver {

    public static void main(String[] args) {
        ArrayList<abccompany.Customer> customers = new ArrayList<>();

        try {

            File mfile = new File("MasterFile.txt");
            FileReader fileReader = new FileReader(mfile);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line;

            String regex = "(\\s)+"; // space regex

            while ((line = bufferedReader.readLine()) != null) {

                String[] columns = line.trim().split(regex);
                String cname = columns[1].trim();
                int cnum = Integer.parseInt(columns[0].trim());
                double balancedue = Double.parseDouble(columns[2].trim());
                abccompany.Customer customer = new abccompany.Customer(cname, cnum, balancedue);
                customers.add(customer);

                File tfile = new File("Transactions.txt");
                FileReader tfileReader = new FileReader(tfile);
                BufferedReader tbufferedReader = new BufferedReader(tfileReader);
                String tline;

                // loop to end of transactions
                while ((tline = tbufferedReader.readLine()) != null) {
                    String[] splited = tline.trim().split(regex);
                    char code = splited[0].trim().toUpperCase().charAt(0);
                    int customerid = Integer.parseInt(splited[1].trim());

                    if (customerid != customer.getCnum())
                        continue;

                    // determine whether if "O" or "P"
                    switch (code) {
                        case 'P': {
                            int transnum = Integer.parseInt(splited[2].trim());
                            double amount = Double.parseDouble(splited[3].trim());
                            abccompany.Transaction trans = new abccompany.Payment(transnum, amount);
                            customer.addTranscation(trans);

                            break;
                        }

                        case 'O': {

                            int transnum = Integer.parseInt(splited[2].trim());
                            String item = splited[3].trim();
                            int quantity = Integer.parseInt(splited[4].trim());
                            double cost = Double.parseDouble(splited[5].trim());

                            abccompany.Transaction trans = new abccompany.Order(transnum, item, quantity, cost);
                            customer.addTranscation(trans);

                            break;
                        }

                    }
                }
                //closing transaction file
                tbufferedReader.close();


            }
            fileReader.close();

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {

            FileWriter fstream = new FileWriter("output.txt");
            BufferedWriter out = new BufferedWriter(fstream);

            for (abccompany.Customer cust : customers) {
                out.write(cust.Print());
            }

            out.close();

        }
        catch (Exception e) {
            System.err.println("Error: " + e.getMessage());
        }


    }

}
