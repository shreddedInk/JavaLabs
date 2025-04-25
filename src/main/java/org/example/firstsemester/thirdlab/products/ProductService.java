package org.example.firstsemester.thirdlab.products;

import org.example.firstsemester.thirdlab.interfaces.IFilter;
import org.example.firstsemester.thirdlab.interfaces.IProduct;

public class ProductService {

    public static int countByFilter(ProductBatch batch, IFilter filter) {
        if (batch == null || filter == null) {
            throw new NullPointerException("Партия или фильтр не существуют");
        }
        int count = 0;
        for (IProduct item : batch.getProducts()) {
            if (filter.apply(item.getName())) {
                count++;
            }
        }
        return count;
    }

    public static int countByFilterDeep(ProductBatch batch, IFilter filter) {
        if (batch == null || filter == null) {
            throw new NullPointerException("Партия или фильтр не существуют");
        }
        int count = 0;
        for (IProduct item : batch.getProducts()) {
            count += countByFilterDeepRecur(item, filter);
        }
        return count;
    }

    private static int countByFilterDeepRecur(IProduct product, IFilter filter) {
        int count = 0;

        if (product instanceof PackedProductSet packedProductSet) {
            for (IProduct packedItem : packedProductSet.getPackedItems()) {
                count += countByFilterDeepRecur(packedItem, filter);
            }
        }
        if (filter.apply((product.getName()))) {
            count++;
        }
        return count;
    }

    public static boolean checkAllWeighted(ProductBatch batch) {
        if (batch == null) {
            throw new NullPointerException("Партия не существует");
        }
        return checkAllWeightedRecur(batch.getProducts());
    }

    private static boolean checkAllWeightedRecur(IProduct[] products) {
        for (IProduct item : products) {
            if (!(item instanceof WeightProduct)) {
                if (item instanceof PackedProductSet deepSet) {
                    if (!checkAllWeightedRecur(deepSet.getPackedItems())) {
                        return false;
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
