package silh.shopeasier.shoppinglist.converters;

import javax.annotation.Nullable;

public interface Converter<Entity, TO> {
    @Nullable
    TO fromEntity(@Nullable Entity entity);

    @Nullable
    Entity toEntity(@Nullable TO to);
}
