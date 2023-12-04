package project.module4.service.productService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.module4.dao.implement.product.ProductDao;
import project.module4.model.Product;

import java.util.List;

@Service
public class ProductService implements IProductService{
    @Autowired
    private ProductDao productDao;

    @Override
    public List<Product> findAll(int page, int size) {
        return productDao.findAll(size, page*size);
    }

    @Override
    public List<Product> findAll() {
        return productDao.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productDao.findById(id);
    }

    @Override
    public int save(Product product) {
        return productDao.save(product);
    }

    @Override
    public int delete(Long id) {
        return productDao.delete(id);
    }
}
