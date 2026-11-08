package com.viaversion.viaversion.api.type.types.version;

import com.viaversion.viaversion.api.minecraft.data.version.*;
import com.viaversion.viaversion.api.minecraft.entitydata.types.*;
import com.viaversion.viaversion.api.type.*;
import com.viaversion.viaversion.api.minecraft.item.*;
import java.util.function.*;
import com.viaversion.viaversion.api.type.types.item.*;

public class Types1_21 extends Types1_20_5<StructuredDataKeys1_20_5, EntityDataTypes1_21>
{
    public final Type<Item> optionalItem;
    
    public Types1_21(final Function<VersionedTypesHolder, StructuredDataKeys1_20_5> function, final Function<VersionedTypesHolder, EntityDataTypes1_21> function2) {
        super(function, function2);
        this.optionalItem = (ItemType1_20_5)this.item.new OptionalItemType();
    }
}
