package ssvv.steps.serenity;

import net.thucydides.core.annotations.Step;
import ssvv.pages.EmagDictionaryPage;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.hasItem;

public class EmagSteps {

    EmagDictionaryPage dictionaryPage;

    @Step
    public void enters(String keyword) {
        dictionaryPage.enter_keywords(keyword);
    }

    @Step
    public void starts_search() {
        dictionaryPage.lookup_terms();
    }

    @Step
    public void should_see_definition(String definition) {
        assertThat(dictionaryPage.getProductsDescription(), hasItem(containsString(definition)));
    }

    @Step
    public void should_see_ambiguous_message(String definition) {
        assertThat(dictionaryPage.getAmbiguousMessage(), containsString(definition));
    }

    @Step
    public void should_see_sorted_definition(String definition) {
        assertThat(dictionaryPage.getProductsDescription().get(0), containsString(definition));
    }

    @Step
    public void is_the_home_page() {
        dictionaryPage.open();
    }

    @Step
    public void looks_for(String term) {
        enters(term);
        starts_search();
    }

    @Step
    public void sort_by_price_desc() throws InterruptedException {
        choose_sort_option();
    }

    private void sort() {
        dictionaryPage.choose_sort_option();
    }

    private void choose_sort_option() {
        dictionaryPage.choose_sort_option();
    }
}