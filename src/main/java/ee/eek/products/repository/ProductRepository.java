package ee.eek.products.repository;

import ee.eek.products.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional //does this belong here?
public interface ProductRepository extends CrudRepository<Product, Long> {}
