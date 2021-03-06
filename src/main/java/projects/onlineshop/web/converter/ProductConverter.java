package projects.onlineshop.web.converter;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import projects.onlineshop.data.ProductSummary;
import projects.onlineshop.domain.model.Product;
import projects.onlineshop.domain.repository.ProductCategoryRepository;
import projects.onlineshop.web.command.CreateProductCommand;

@Component @RequiredArgsConstructor
public class ProductConverter {

    private final ProductCategoryRepository productCategoryRepository;
    private final ProductCategoryConverter productCategoryConverter;

    public Product from (CreateProductCommand command) {
        return Product.builder()
                .name(command.getName())
                .description(command.getDescription())
                .category(productCategoryRepository.getOne(command.getCategoryId()))
                .price(command.getPrice())
                .build();
    }

    public ProductSummary fromProductToProductSummary(Product product) {
        return ProductSummary.builder()
                .id(product.getId())
                .name(product.getName())
                .category(productCategoryConverter.toProductCategorySummary(product.getCategory()))
                .price(product.getPrice())
                .build();
    }
}
