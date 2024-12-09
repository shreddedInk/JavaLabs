package org.example.thirdlab.products;

import org.example.thirdlab.interfaces.IFilter;
import org.example.thirdlab.interfaces.IProduct;

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
        IProduct[] products = batch.getProducts();
        for (IProduct item : products) {
            if (item instanceof PackedProductSet) {
            }
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
        if (filter.apply(product.getName())) {
            count++;
        }
        return count;
    }


    public static boolean checkAllWeighted(ProductBatch batch) {
        IProduct[] products = batch.getProducts();
        return checkAllWeightedRecur(products);
    }

    private static boolean checkAllWeightedRecur(IProduct[] products) {
        for (IProduct item : products) {
            if (!(item instanceof WeightProduct)) {
                if (item instanceof PackedProductSet deepSet) {
                    IProduct[] deepSetItem = deepSet.getPackedItems();
                    if (!checkAllWeightedRecur(deepSetItem)) {
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
