package catcafe;

import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CatCafeTest {

    private CatCafe catCafe;

    @BeforeEach
    public void setUp() {
        catCafe = new CatCafe();
    }

    @Test
    public void empty_cafe_is_empty() {
        // given
        // catCafe = new CatCafe(); -> done in setUp()

        // when
        long count = catCafe.getCatCount();

        // then
        assert (count == 0);
    }

    @Test
    public void not_empty_cafe_has_correct_count() {
        // given
        catCafe.addCat(new FelineOverLord("Doobert", 1));
        catCafe.addCat(new FelineOverLord("Goobert", 3));
        catCafe.addCat(new FelineOverLord("Scoobert", 2));

        // when
        long count = catCafe.getCatCount();

        // then
        assert (count == 3);
    }

    @Test
    public void get_cat_by_names_returns_correct_cat() {
        // given
        FelineOverLord doobert = new FelineOverLord("Doobert", 1);
        catCafe.addCat(doobert);

        // when
        FelineOverLord cat = catCafe.getCatByName("Doobert");

        // then
        assert (cat.equals(doobert));
    }

    @Test
    public void get_cat_by_name_returns_null_when_no_cat_found() {
        // given
        FelineOverLord doobert = new FelineOverLord("Doobert", 1);
        catCafe.addCat(doobert);

        // when
        FelineOverLord cat = catCafe.getCatByName("Scoobert");

        // then
        assert (cat == null);
    }

    @Test
    public void get_cat_by_weight_returns_correct_cat() {
        // given
        FelineOverLord doobert = new FelineOverLord("Doobert", 1);
        catCafe.addCat(doobert);

        // when
        FelineOverLord cat = catCafe.getCatByWeight(1, 2);

        // then
        assert (cat.equals(doobert));
    }

    @Test
    public void get_cat_by_weight_returns_null_when_no_cat_found() {
        // given
        FelineOverLord doobert = new FelineOverLord("Doobert", 1);
        catCafe.addCat(doobert);

        // when
        FelineOverLord cat = catCafe.getCatByWeight(2, 3);

        // then
        assert (cat == null);
    }

    @Test
    public void search_cat_with_negative_weight_returns_null() {
        // given
        FelineOverLord doobert = new FelineOverLord("Doobert", -1);
        catCafe.addCat(doobert);

        // when
        FelineOverLord cat = catCafe.getCatByWeight(-1, 3);

        // then
        assert (cat == null);
    }

    @Test
    public void search_with_minWeight_greater_than_maxWeight_returns_null() {
        // given
        FelineOverLord doobert = new FelineOverLord("Doobert", 1);
        catCafe.addCat(doobert);

        // when
        FelineOverLord cat = catCafe.getCatByWeight(3, 1);

        // then
        assert (cat == null);
    }

    @Test
    public void add_null_cat_returns_null() {
        // given
        // catCafe = new CatCafe(); -> done in setUp()

        // when and then
        assertThrows(NullPointerException.class, () -> catCafe.addCat(null));
    }

    @Test
    public void get_cat_by_name_null_returns_null() {
        // given
        // catCafe = new CatCafe(); -> done in setUp()

        // when
        var result = catCafe.getCatByName(null);

        // then
        assert (result == null);
    }
}
