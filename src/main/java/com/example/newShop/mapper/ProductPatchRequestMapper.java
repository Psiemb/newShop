package com.example.newShop.mapper;

import com.example.newShop.api.patchProduct.request.PatchProductRequest;
import com.example.newShop.dao.entity.Product;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductPatchRequestMapper {

    public Product mapToProduct(PatchProductRequest source) {
        if (Objects.isNull(source)
//                || Objects.isNull(source.getPromotionName())
//        || Objects.isNull(source.getPromotionPrice()) || Objects.isNull(source.getStartDate())
//        || Objects.isNull(source.getEndDate())
        ) {
            return null;
        }
        return new Product()
                .setPromotionName(source.getPromotionName())
                .setPromotionPrice(source.getPromotionPrice())
                .setStartDate(source.getStartDate())
                .setEndDate(source.getEndDate());
    }
    public Product mapToUpdatedProduct(Product source1, Product source2){
        if (Objects.isNull(source1) || Objects.isNull(source2)
//                || Objects.isNull(source1.getName())
//                || Objects.isNull(source1.getPrice()) || Objects.isNull(source1.getGlobalCodeItemNumber())
//                || Objects.isNull(source1.getType()) || Objects.isNull(source2.getPromotionName())
//                || Objects.isNull(source2.getPromotionPrice()) || Objects.isNull(source2.getStartDate())
//                || Objects.isNull(source2.getEndDate())
        ) {
            return null;
        }
        return new Product()
                .setId(source1.getId())
                .setGlobalCodeItemNumber(source1.getGlobalCodeItemNumber())
                .setName(source1.getName())
                .setPrice(source1.getPrice())
                .setType(source1.getType())
                .setPromotionName(source2.getPromotionName())
                .setPromotionPrice(source2.getPromotionPrice())
                .setStartDate(source2.getStartDate())
                .setEndDate(source2.getEndDate());
    }
}
