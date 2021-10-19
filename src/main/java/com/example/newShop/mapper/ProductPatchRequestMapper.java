package com.example.newShop.mapper;

import com.example.newShop.api.changePrice.request.ProductChangePrice;
import com.example.newShop.api.patchProduct.request.PatchPromotionRequest;
import com.example.newShop.dao.entity.Product;
import com.example.newShop.dao.entity.Promotion;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Component
public class ProductPatchRequestMapper {

    public Product mapToProduct(PatchPromotionRequest source) {
        if (Objects.isNull(source)
//                || Objects.isNull(source.getPromotionName())
//        || Objects.isNull(source.getPromotionPrice()) || Objects.isNull(source.getStartDate())
//        || Objects.isNull(source.getEndDate())
        ) {
            return null;
        }
        Promotion promotion = new Promotion()
                .setName(source.getPromotionName())
                .setPrice(source.getPromotionPrice())
                .setStartDate(source.getStartDate())
                .setEndDate(source.getEndDate());
        return new Product()
                .setPromotion(promotion);
    }
//    public Product mapToUpdatedProduct(Product source1, Product source2){
//        if (Objects.isNull(source1) || Objects.isNull(source2)
//                || Objects.isNull(source1.getName())
//                || Objects.isNull(source1.getPrice()) || Objects.isNull(source1.getGlobalCodeItemNumber())
//                || Objects.isNull(source1.getType()) || Objects.isNull(source2.getPromotionName())
//                || Objects.isNull(source2.getPromotionPrice()) || Objects.isNull(source2.getStartDate())
//                || Objects.isNull(source2.getEndDate())
//        ) {
//            return null;
//        }
//        return new Product()
//                .setId(source1.getId())
//                .setGlobalCodeItemNumber(source1.getGlobalCodeItemNumber())
//                .setName(source1.getName())
//                .setPrice(source1.getPrice())
//                .setType(source1.getType())
//                .setPromotionName(source2.getPromotionName())
//                .setPromotionPrice(source2.getPromotionPrice())
//                .setStartDate(source2.getStartDate())
//                .setEndDate(source2.getEndDate());
//    }

    public Product mapToProductPrice(ProductChangePrice source){
        if(Objects.isNull(source)){
            return null;
        }
        return new Product()
                .setName(source.getName())
                .setPrice(source.getPrice());
    }
}
