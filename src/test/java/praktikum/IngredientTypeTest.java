package praktikum;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.*;

public class IngredientTypeTest {
    @Test
    @DisplayName("Проверка количества значений IngredientType")
    public void checkIngredientTypesHaveTwoValues() {
        IngredientType[] values = IngredientType.values();
        assertEquals(2, values.length, "В ENUM IngredientType должно быть 2 значения");
    }

    @ParameterizedTest(name = "Значение {1} = {0}")
    @MethodSource("enumParams")
    @DisplayName("Проверка значений enum")
    public void checkIngredientTypesEachEnum(IngredientType type, int i) {
        IngredientType[] values = IngredientType.values();
        assertEquals(type, values[i], String.format("Значение %d должно быть %s", i, type));
    }

    static Stream<Arguments> enumParams() {
        return Stream.of(
                Arguments.of(IngredientType.SAUCE, 0),
                Arguments.of(IngredientType.FILLING, 1)
        );
    }
}
