package org.example.thirdlab.products;

import org.example.thirdlab.interfaces.IFilter;
import org.example.thirdlab.interfaces.IProduct;

public class ProductService {

    public static int countByFilter(ProductBatch batch, IFilter filter) {
        if (batch == null || filter == null) {
            throw new NullPointerException("Batch or filter cannot be null");
        }

        int count = 0;
        for (IProduct product : batch.getProducts()) {
            if (filter.apply(product.getName())) {
                count++;
            }
        }
        return count;
    }

    public static int countByFilterDeep(ProductBatch batch, IFilter filter) {
        if (batch == null || filter == null) {
            throw new NullPointerException("Batch or filter cannot be null");
        }

        int count = 0;
        for (IProduct product : batch.getProducts()) {
            if (product instanceof PackedProductSet packedSet) {
                for (IProduct packedProduct : packedSet.getPackedItems()) {
                    if (filter.apply(packedProduct.getName())) {
                        count++;
                    }
                }
            } else if (filter.apply(product.getName())) {
                count++;
            }
        }
        return count;
    }

    public static boolean checkAllWeighted(ProductBatch batch) {
        if (batch == null) {
            throw new NullPointerException("Batch cannot be null");
        }

        for (IProduct product : batch.getProducts()) {
            if (!(product instanceof WeightProduct)) {
                if (product instanceof PackedProductSet packedSet) {
                    for (IProduct packedProduct : packedSet.getPackedItems()) {
                        if (!(packedProduct instanceof WeightProduct)) {
                            return false;
                        }
                    }
                } else {
                    return false;
                }
            }
        }
        return true;
    }
}
