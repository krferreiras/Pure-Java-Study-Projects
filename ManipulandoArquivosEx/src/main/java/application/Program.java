package application;

import entities.Products;

import java.io.*;
import java.sql.SQLOutput;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class Program {

    public static void main(String[] args) throws ParseException {
        List<Products> products = new ArrayList<>();

        String sourceFileStr = "D:..//ManipulandoArquivosEx/SourceFile.csv";

        File sourceFile = new File(sourceFileStr);
        String sourceFolderStr = sourceFile.getParent();

        boolean success = new File(sourceFolderStr + "/out").mkdir();

        System.out.println(success);

        String targetFileStr = sourceFolderStr + "/out/summary.csv";

        try (BufferedReader br = new BufferedReader(new FileReader(sourceFileStr))){

            System.out.println();

            String itemCsv = br.readLine();
            while (itemCsv != null){
                String[] fields = itemCsv.split(",");
                String name = fields[0];
                Double price = Double.parseDouble(fields[1]);
                Integer quantity = Integer.parseInt(fields[2]);

                products.add(new Products(name, price, quantity));

                itemCsv = br.readLine();

                try (BufferedWriter bw = new BufferedWriter(new FileWriter(targetFileStr))){

                    for(Products item : products){
                        bw.write(item.getName() + ", R$ " + String.format("%.2f", item.totalPrice()));
                        bw.newLine();

                    }
                    System.out.println(targetFileStr + "CREATED.");
                }catch (IOException e) {
                    System.out.println("Error writing file: " + e.getMessage());
                }
            }
        }catch (IOException e){
            System.out.println("Error writing file: " + e.getMessage());
        }

    }
}
