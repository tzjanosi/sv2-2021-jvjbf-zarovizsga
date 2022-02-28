package webshop;

public class ProductService {
    private ProductRepository productRepository;

    public ProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void saleProduct(long id, int amount){
        Product actualProduct=productRepository.findProductById(id);
        if(actualProduct.getStock()<amount){
            throw new IllegalArgumentException("Not enough item in the stock!");
        }
        productRepository.updateProductStock(id,amount);

    }
}
