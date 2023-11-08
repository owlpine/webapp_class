package ee.eek.products.service;

import ee.eek.products.dto.ProductDTO;
import ee.eek.products.mapper.ProductMapper;
import ee.eek.products.model.Product;
import ee.eek.products.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductsService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;
    private final String defaultRole = "Tim";

    public List<ProductDTO> getProducts() {
        List<ProductDTO> productDTOs = new ArrayList<>();
        productRepository.findAll().forEach(
                product -> productDTOs.add(productMapper.toDTO(product))
        );
        return productDTOs;
    }

    public ProductDTO getProduct(Long id) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        return productMapper.toDTO(product);
    }

    public ProductDTO createProduct(ProductDTO productDTO) {
        productDTO.setCreatedAt(LocalDateTime.now());
        if (productDTO.getCreatedBy() == null || productDTO.getCreatedBy().isBlank()) {
            productDTO.setCreatedBy(defaultRole);
        }
        if (productDTO.getUpdatedAt() != null) {
            productDTO.setUpdatedAt(null);
        }
        if (productDTO.getUpdatedBy() != null) {
            productDTO.setUpdatedBy(null);
        }

        Product product = productMapper.toModel(productDTO);
        product = productRepository.save(product);
        return productMapper.toDTO(product);
    }

    public ProductDTO updateProduct(Long id, ProductDTO productDTO) {
        Product product = productRepository.findById(id).orElseThrow(RuntimeException::new);
        productDTO.setId(product.getId());
        productDTO.setCreatedAt(product.getCreatedAt());
        productDTO.setCreatedBy(product.getCreatedBy());
        productDTO.setUpdatedAt(LocalDateTime.now());
        if (productDTO.getUpdatedBy() == null || productDTO.getUpdatedBy().isBlank()) {
            productDTO.setUpdatedBy(defaultRole);
        }
        // blank, set null; null, keep original; else set value
        if (productDTO.getName() == null) {
            productDTO.setName(product.getName());
        } else if (productDTO.getName().isBlank()) {
            productDTO.setName(null);
        }
        if (productDTO.getDescription() == null) {
            productDTO.setDescription(product.getDescription());
        } else if (productDTO.getDescription().isBlank()) {
            productDTO.setDescription(null);
        }
        if (productDTO.getPrice() == null) {
            productDTO.setPrice(product.getPrice());
        }
        product = productMapper.toModel(productDTO);
        product = productRepository.save(product);
        return productMapper.toDTO(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}
