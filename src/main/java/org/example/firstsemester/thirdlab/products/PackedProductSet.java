package org.example.firstsemester.thirdlab.products;

import org.example.firstsemester.thirdlab.Pack;
import org.example.firstsemester.thirdlab.interfaces.IProduct;

public class PackedProductSet implements IProduct {
    private final String name;
    private final Pack pack;
    private final IProduct[] packedItems;

    public PackedProductSet(String name, Pack pack, IProduct[] packedItems) {
        this.name = name;
        this.pack = pack;
        this.packedItems = packedItems;
    }

    @Override
    public String getName() {
        return name;
    }

    public Pack getPack() {
        return pack;
    }

    public IProduct[] getPackedItems() {
        return packedItems;
    }

    @Override
    public double getNettoMass() {
        double total = 0;
        for (IProduct item : packedItems) {
            if (item == null) continue;
            total += item.getBruttoMass();
        }
        return total;
    }

    @Override
    public double getBruttoMass() {
        return getNettoMass() + pack.getPackWeight();
    }
}
