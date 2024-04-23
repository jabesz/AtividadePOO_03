public class ImportedProduct extends Product{
    private Double customsFee;

    public ImportedProduct(Double customsFee) {
        this.customsFee = customsFee;
    }

    public ImportedProduct(String name, double price, double customsFee) {
        super(name, price);
        this.customsFee = customsFee;
    }

    public double getCustomsFee() {
        return customsFee;
    }

    public double customFeeAdd() {
        return customsFee + getPrice();
    }

    @Override
    public String priceTag() {
        return super.priceTag() + " Price: $" + customFeeAdd() +" (Customs fee: $ " + String.format("%.2f", getCustomsFee()) + ")";
    }
}
