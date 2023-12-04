package project.module4.service.catalogService;

import project.module4.model.Catalog;
import project.module4.service.IGenericService;

public interface ICatalogService extends IGenericService<Catalog,Long> {
    int save(Catalog catalog);
}
