package model;

public class ProdottoCarrello {
	private ProdottoBean product;
	private int quantit�;
	public ProdottoCarrello(ProdottoBean product, int quantit�) {
		super();
		this.product = product;
		this.quantit� = quantit�;
	}
	public ProdottoBean getProduct() {
		return product;
	}
	public void setProduct(ProdottoBean product) {
		this.product = product;
	}
	public int getQuantit�() {
		return quantit�;
	}
	public void setQuantit�(int quantit�) {
		this.quantit� = quantit�;
	}
	
	@Override
	public String toString() {
		return "ProdottoCarrello [product=" + product + ", quantit�=" + quantit� + "]";
	};
	

}
