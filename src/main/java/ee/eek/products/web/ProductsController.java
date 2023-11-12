package ee.eek.products.web;

import ee.eek.products.dto.ProductDTO;
import ee.eek.products.service.ProductsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("products")
@RequiredArgsConstructor
public class ProductsController {
    private final ProductsService productsService;
    @GetMapping
    public List<ProductDTO> getProducts() {
        return productsService.getProducts();
    }

    @GetMapping("{id}")
    public ProductDTO getProduct(@PathVariable Long id) {
        return productsService.getProduct(id);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {
        return productsService.createProduct(productDTO);
    }

    @PutMapping("{id}")
    public ProductDTO updateProduct(@PathVariable Long id, @RequestBody ProductDTO product) {
        return productsService.updateProduct(id, product);
    }

    @DeleteMapping("{id}")
    // TODO client always gets 200 even if id does not exist
    public void deleteProduct(@PathVariable Long id) {
        productsService.deleteProduct(id);
    }
}
