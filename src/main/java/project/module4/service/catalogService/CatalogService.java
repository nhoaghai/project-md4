package project.module4.service.catalogService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import project.module4.dao.implement.catalog.CatalogDao;
import project.module4.dao.implement.product.ProductDao;
import project.module4.model.Catalog;

import java.util.List;
@Service
public class CatalogService implements ICatalogService {
    @Autowired
    private CatalogDao catalogDao;
    @Autowired
    private ProductDao productDao;
    @Override
    public List<Catalog> findAll(int page, int size) {
        return catalogDao.findAll(size,page*size);
    }

    @Override
    public List<Catalog> findAll() {
        return catalogDao.findAll();
    }

    @Override
    public Catalog findById(Long id) {
        return catalogDao.findById(id);
    }

    @Override
    public int save(Catalog catalog) {
        return catalogDao.save(catalog);
    }

    @Override
    public int delete(Long id) {
        productDao.deleteAll(id);
        return catalogDao.delete(id);
    }
}
