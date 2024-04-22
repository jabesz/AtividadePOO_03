import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

public class App {
    public static void main(String[] args) {

        var input = new Scanner(System.in);
        List<Product> products = new ArrayList<>();
        int n;
        char typeProduct;
        String name, date;
        double price, customsFee;
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

        System.out.print("Enter the number of products: ");
        n = input.nextInt();

        for (int i = 0; i < n; i++) {
            System.out.println("Product #" +(i + 1)+ " data");

            System.out.print("Common, used or imported (c/u/i)?: ");
            typeProduct = input.next().toUpperCase().charAt(0);
            input.nextLine();
            System.out.print("Enter the name of the product: ");
            name = input.nextLine();
            System.out.print("Enter the price of the product: ");
            price = input.nextInt();

            if (typeProduct == 'i') {
                System.out.print("Customs fee: ");
                customsFee = input.nextDouble();
                products.add(new ImportedProduct(name, price, customsFee));

            } else if (typeProduct == 'u') {
                System.out.print("Manufacture date (DD/MM/YYYY): ");
                String dateStr = input.next();
                Date manufactureDate = sdf.parse(dateStr, new ParsePosition(0));
                products.add(new UsedProduct(name, price, manufactureDate));

            } else {
                products.add(new Product(name, price) {
                    @Override
                    public String priceTag() {
                        return getName() + " $ " + String.format("%.2f", getPrice());
                    }

                });
            }
        }

        System.out.println("Price tags: ");
        for(Product product: products) {
            System.out.println(product.priceTag());
        }

        input.close();

    }
}