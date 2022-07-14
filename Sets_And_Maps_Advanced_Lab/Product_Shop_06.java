package Sets_And_Maps_Advanced_Lab;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class Product_Shop_06 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        Map<String, LinkedHashMap<String, Double>> shopInformation = new TreeMap<>();

        while (!input.equals("Revision")) {
            String [] tokens = input.split(", ");
            String shopName = tokens[0];
            String product = tokens[1];
            double prize  = Double.parseDouble(tokens[2]);

            shopInformation.putIfAbsent(shopName, new LinkedHashMap<>());

            LinkedHashMap<String, Double> productsInfo = shopInformation.get(shopName);
            productsInfo.putIfAbsent(product, prize);

            input = scanner.nextLine();
        }

        for (var entry : shopInformation.entrySet()) {
            String key = entry.getKey();
            LinkedHashMap<String, Double> productInfo = entry.getValue();

            System.out.println(key + "->");
            for (var product : productInfo.entrySet()) {
                System.out.print("Product: " + product.getKey() + ", ");
                System.out.printf("Price: %.1f%n", product.getValue());
            }
        }
        
    }
}
