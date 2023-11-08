package ee.eek.products.mapper;

import ee.eek.products.dto.ProductDTO;
import ee.eek.products.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper {
    public ProductDTO toDTO(Product product) {
        return new ProductDTO()
                .setId(product.getId())
                .setCreatedAt(product.getCreatedAt())
                .setCreatedBy(product.getCreatedBy())
                .setUpdatedAt(product.getUpdatedAt())
                .setUpdatedBy(product.getUpdatedBy())
                .setName(product.getName())
                .setDescription(product.getDescription())
                .setPrice(product.getPrice());
    }

    public Product toModel(ProductDTO productDTO) {
        return new Product()
                .setId(productDTO.getId())
                .setCreatedAt(productDTO.getCreatedAt())
                .setCreatedBy(productDTO.getCreatedBy())
                .setUpdatedAt(productDTO.getUpdatedAt())
                .setUpdatedBy(productDTO.getUpdatedBy())
                .setName(productDTO.getName())
                .setDescription(productDTO.getDescription())
                .setPrice(productDTO.getPrice());
    }
}
