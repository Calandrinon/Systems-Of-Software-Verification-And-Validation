package ssvv.pages;

import net.serenitybdd.core.annotations.findby.FindBy;
import net.serenitybdd.core.pages.WebElementFacade;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.pages.PageObject;
import org.openqa.selenium.By;

import java.util.List;
import java.util.stream.Collectors;

@DefaultUrl("https://www.emag.ro/")
public class EmagDictionaryPage extends PageObject {
    @FindBy(name="query")
    private WebElementFacade searchTerms;

    @FindBy(css="i.em.em-search")
    private WebElementFacade lookupButton;

    @FindBy(css="button.btn.btn-sm.btn-alt.sort-control-btn.gtm_ejaugtrtnc")
    private WebElementFacade dropDownButton;

    @FindBy(css="a.js-sort-option")
    private WebElementFacade priceDescOption;

    public void enter_keywords(String keyword) {
        searchTerms.type(keyword);
    }

    public void lookup_terms() {
        lookupButton.click();
    }

    public void choose_sort_option() {
        dropDownButton.selectByVisibleText("Pret descrescator");
    }

    public List<String> getProductsDescription() {
        WebElementFacade cards = find(By.cssSelector("div.card-item.card-standard.js-product-data"));
        return cards.findElements(By.cssSelector("div.pad-hrz-xs")).stream()
                .map( element -> element.findElement(By.tagName("a")).getText() )
                .collect(Collectors.toList());
    }

    public String getAmbiguousMessage() {
        return find(By.cssSelector("span.title-phrasing.title-phrasing-sm.text-danger")).getText();
    }
}