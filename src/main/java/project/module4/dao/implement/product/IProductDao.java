package project.module4.dao.implement.product;

import project.module4.dao.IGenericDao;
import project.module4.model.Product;

public interface IProductDao extends IGenericDao<Product,Long> {
    int deleteAll(Long categoryId);
}
