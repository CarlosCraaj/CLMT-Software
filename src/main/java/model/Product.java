package model;


public class Product {
	private int idProduct;
	private int quantidadeComprada;
	private String nomeProduto;
	
	public Product() {
		idProduct = -1;
		quantidadeComprada = 0;
        nomeProduto = "";
    }

	public Product(int id, int qntdComprada, String nomeProduto) {
		setId(id);
        setQuantidadeComprada(qntdComprada);
        setNomeProduto(nomeProduto);
	}		
	
	public int getIDProduct() {
		return idProduct;
	}

	public void setId(int id) {
		this.idProduct = id;
	}


    public int getQuantidadeComprada() {
        return quantidadeComprada;
    }

    public void setQuantidadeComprada(int qntdComprada) {
        this.quantidadeComprada = qntdComprada;
    }
	

	public String getNomeProduto() {
		return nomeProduto;
	}

	public void setNomeProduto(String nomeProduto) {
		this.nomeProduto = nomeProduto;
	}


	@Override
	public String toString() {
		return "Produto: " + nomeProduto + "   Quantidade Comprada: " + quantidadeComprada;
	}
	
	@Override
	public boolean equals(Object obj) {
		return (this.getIDProduct() == ((Product) obj).getIDProduct());
	}	
}