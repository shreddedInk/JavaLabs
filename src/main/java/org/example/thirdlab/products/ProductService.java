package org.example.thirdlab.products;

import org.example.thirdlab.interfaces.IFilter;
import org.example.thirdlab.interfaces.IProduct;

public class ProductService {
    public static int countByFilter(ProductBatch batch, IFilter IFilter) {
        if (batch == null || IFilter == null) {
            throw new NullPointerException("Партия или фильтр не существуют");
        }
        int count = 0;
        for (IProduct item : batch.getProducts()) {
            if (IFilter.apply(item.getName())) {
                count++;
            }
        }
        return count;
    }

    public static int countByFilterDeep(ProductBatch batch, IFilter IFilter) {
        if (batch == null || IFilter == null) {
            throw new NullPointerException("Партия или фильтр не существуют");
        }
        int count = 0;
        IProduct[] products = batch.getProducts();
        for (IProduct item : products) {
            if (item instanceof PackedIProductSet) {
//                for (int i = 0; i < ((PackedProductSet) item).getPackedItems().length; i++) {
//                    if (filter.apply(((PackedProductSet) item).getPackedItems()[i].getName())) {
//                        count++;
//                    }
//                }
                count += countByFilterDeepRecur(item, IFilter);
            }
        }
        return count;
    }

    private static int countByFilterDeepRecur(IProduct product, IFilter IFilter) {
        int count = 0;

        if (product instanceof PackedIProductSet packedProductSet) {
            for (IProduct packedItem : packedProductSet.getPackedItems()) {
                count += countByFilterDeepRecur(packedItem, IFilter);
            }
        }
        if (IFilter.apply(product.getName())) {
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
                if (item instanceof PackedIProductSet deepSet) {
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
