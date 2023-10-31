package entities;

public class ImportedProduct extends Product{
	
	private Double customsFee;
	
	public ImportedProduct() {
		
	}

	public ImportedProduct(String name, Double price, Double customsFee) {
		super(name, price);
		this.customsFee = customsFee;
	}

	public Double getCustomsFee() {
		return customsFee;
	}

	public void setCustomsFee(Double customsFee) {
		this.customsFee = customsFee;
	}

	@Override
	public String priceTag() {
		return super.getName() + ", U$ " +  String.format("%.2f", totalPrice()) 
		+ "(Customs fee: U$ " + String.format("%.2f", getCustomsFee())+ ")";
	}
	
	public Double totalPrice() {
		return super.price + customsFee;
	}
	
}
