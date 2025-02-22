package org.ecommerce.analyticsservice.mapper;

import org.apache.spark.api.java.function.MapFunction;
import org.apache.spark.sql.Row;
import org.ecommerce.analyticsservice.models.Category;

public final class CategoryMapper implements MapFunction<Row, Category> {

    @Override
    public Category call(Row value) throws Exception {
        return Category.builder()
                .id(value.getAs("category_id"))
                .parentId(value.getAs("category_parent_id"))
                .name(value.getAs("category_name"))
                .build();
    }
}
