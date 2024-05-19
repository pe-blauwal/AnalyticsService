package org.ecommerce.analyticsservice.mapper;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;
import org.ecommerce.analyticsservice.dtos.ProductWithOrderStatusRevDto;

import java.math.BigDecimal;

public final class ProductWithOrderStatusRevDtoMapper implements MapFunction<Row, ProductWithOrderStatusRevDto> {
    @Override
    public ProductWithOrderStatusRevDto call(Row row) throws Exception {
        return ProductWithOrderStatusRevDto.builder()
                .productId(row.getAs("product_id"))
                .productName(row.getAs("product_name"))
                .processingTotalPrice(((BigDecimal)row.getAs("processing_total_price")).doubleValue())
                .cancelledTotalPrice(((BigDecimal)row.getAs("cancelled_total_price")).doubleValue())
                .deliveredTotalPrice(((BigDecimal)row.getAs("delivered_total_price")).doubleValue())
                .completedTotalPrice(((BigDecimal)row.getAs("completed_total_price")).doubleValue())
                .build();
    }
}
