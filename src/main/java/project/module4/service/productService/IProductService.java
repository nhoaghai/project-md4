package project.module4.service.productService;

import project.module4.model.Product;
import project.module4.service.IGenericService;

public interface IProductService extends IGenericService<Product, Long> {
    int save(Product product);
}
