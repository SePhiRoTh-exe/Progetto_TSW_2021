package model;

public class ProdottoCarrello {
	private ProdottoBean product;
	private int quantità;
	public ProdottoCarrello(ProdottoBean product, int quantità) {
		super();
		this.product = product;
		this.quantità = quantità;
	}
	public ProdottoBean getProduct() {
		return product;
	}
	public void setProduct(ProdottoBean product) {
		this.product = product;
	}
	public int getQuantità() {
		return quantità;
	}
	public void setQuantità(int quantità) {
		this.quantità = quantità;
	}
	
	@Override
	public String toString() {
		return "ProdottoCarrello [product=" + product + ", quantità=" + quantità + "]";
	};
	

}
