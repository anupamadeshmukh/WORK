package tradesale.processing.report.model;


/**
 * The Class ProductReportPojo.
 * For holding data for the report at record level. 
 */
public class ProductReportPojo {
	
	/** The name. */
	private String name;
	
	/** The price. */
	private double price;
	
	/** The currency. */
	private String currency;
	
	/** The unit. */
	private int unit;
	
	/**
	 * Instantiates a new product report pojo.
	 *
	 * @param name the name
	 * @param price the price
	 * @param currency the currency
	 * @param unit the unit
	 */
	public ProductReportPojo(String name, double price, String currency, int unit) {
		this.setName(name);
		this.setPrice(price);
		this.setCurrency(currency);
		this.setUnit(unit);
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Gets the price.
	 *
	 * @return the price
	 */
	public double getPrice() {
		return price;
	}

	/**
	 * Sets the price.
	 *
	 * @param price the new price
	 */
	public void setPrice(double price) {
		this.price = price;
	}

	/**
	 * Gets the currency.
	 *
	 * @return the currency
	 */
	public String getCurrency() {
		return currency;
	}

	/**
	 * Sets the currency.
	 *
	 * @param currency the new currency
	 */
	public void setCurrency(String currency) {
		this.currency = currency;
	}

	/**
	 * Gets the unit.
	 *
	 * @return the unit
	 */
	public int getUnit() {
		return unit;
	}

	/**
	 * Sets the unit.
	 *
	 * @param unit the new unit
	 */
	public void setUnit(int unit) {
		this.unit = unit;
	}
}
