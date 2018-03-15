package entity;
import java.io.Serializable;

public class EzbShopLine implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = -7933203061576911953L;
	private EzbProduct product;
	@SuppressWarnings("unused")
	private double subtotal;
	private int amount;
	public EzbShopLine() {
		super();
		// TODO Auto-generated constructor stub
	}
	public EzbShopLine(EzbProduct product, double subtotal, int amount) {
		super();
		this.product = product;
		this.subtotal = subtotal;
		this.amount = amount;
	}
	public EzbProduct getProduct() {
		return product;
	}
	public void setProduct(EzbProduct product) {
		this.product = product;
	}
	public double getSubtotal() {
		return product.getEpPrice()*amount;
	}
	public void setSubtotal(double subtotal) {
		this.subtotal = subtotal;
	}
	public int getAmount() {
		return amount;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
}
