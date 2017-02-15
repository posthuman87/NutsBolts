package com.test;

import java.io.*;

public class MainClass {

    private static final String RESOURCE_PATH = "d:/projects/Nuts&Bolts/resources/";

    public static void main(String[] args) throws FileNotFoundException {

        File file = new File(RESOURCE_PATH + "input.txt");

        try {
            int k1; //the initial number of bolts
            int l1; //the percentage of lost bolts
            int m1; //the cost of one bolt

            int k2; //the initial number of nuts
            int l2; //the percentage of lost nuts
            int m2; //the cost of one nut

            long x; //extent of damage

            BufferedReader reader = new BufferedReader(new FileReader(file));
            String[] s1 = reader.readLine().split(" ");
            String[] s2 = reader.readLine().split(" ");

            k1 = Integer.parseInt(s1[0]);
            l1 = Integer.parseInt(s1[1]);
            m1 = Integer.parseInt(s1[2]);

            k2 = Integer.parseInt(s2[0]);
            l2 = Integer.parseInt(s2[1]);
            m2 = Integer.parseInt(s2[2]);

            reader.close();

            long a = (k1 / 100) * l1; //the number of lost bolts
            long b = (k2 / 100) * l2; //the number of lost nuts
            x = a * m1 + b * m2;

            if ((k1-=a) > (k2-=b)) {
                x += (k1 - k2) * m1;
            } else {
                x += (k2 - k1) * m2;
            }

            PrintWriter writer = new PrintWriter(RESOURCE_PATH + "output.txt");
            writer.print(x);

            writer.flush();
            writer.close();

        } catch (FileNotFoundException e) {
            throw new FileNotFoundException("Wrong file path!" + e.getMessage());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
