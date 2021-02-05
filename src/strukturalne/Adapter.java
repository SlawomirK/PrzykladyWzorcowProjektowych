package strukturalne;

public class Adapter {
    public static void main(String[] args) {
        Product product = new Product(12, 122);
        ProductAdapter prAdapter = new ProductAdapter(product);
        System.out.println(prAdapter.displayCena());
        System.out.println(prAdapter.displayWaga());
    }
}

class Product {//tej klasy nie chcemy zmieniac
    protected int waga;
    protected int cena;

    public Product(int waga, int cena) {
        this.waga = waga;
        this.cena = cena;
    }

    public int getWaga() {
        return waga;
    }

    public int getCena() {
        return cena;
    }
}

class ProductAdapter {
    protected Product product;

    public ProductAdapter(Product product) {
        this.product = product;
    }

    public int displayWaga() {
        return this.product.getWaga();
    }

    public int displayCena() {
        return this.product.getCena();
    }
}