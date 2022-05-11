package ssvv.features.search;

import net.serenitybdd.junit.runners.SerenityParameterizedRunner;

import net.thucydides.core.annotations.Issue;
import net.thucydides.core.annotations.Managed;
import net.thucydides.core.annotations.ManagedPages;
import net.thucydides.core.annotations.Steps;
import net.thucydides.core.pages.Pages;
import net.thucydides.junit.annotations.Qualifier;
import net.thucydides.junit.annotations.UseTestDataFrom;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.openqa.selenium.WebDriver;


import ssvv.steps.serenity.EmagSteps;
import ssvv.steps.serenity.EndUserSteps;

@RunWith(SerenityParameterizedRunner.class)
@UseTestDataFrom("src/test/resources/WikiTestData.csv")
public class EmagSearchByKeywordDdt {

    @Managed(uniqueSession = true)
    public WebDriver webdriver;

    @ManagedPages(defaultUrl = "http://en.wiktionary.org/wiki/Wiktionary")
    public Pages pages;

    public String name;
    public String definition;

    @Qualifier
    public String getQualifier() {
        return name;
    }

    @Steps
    public EmagSteps endUser;

//    @Issue("#WIKI-1")
//    @Test
//    public void searchWikiByKeywordTestDDT() {
//        endUser.is_the_home_page();
//        endUser.looks_for(getName());
//        endUser.should_see_definition(getDefinition());
//    }

    @Test
    public void searching_by_random_keyword_should_display_the_corresponding_article() {
        endUser.is_the_home_page();
        endUser.looks_for("abcdefghijklmnopqrstuvwxyzjuyfd");
        endUser.should_see_ambiguous_message("0 rezultate pentru:");
    }

    @Test
    public void searching_by_keyword_motocoasa_and_sort_should_display_the_corresponding_article() throws InterruptedException {
        endUser.is_the_home_page();
        endUser.looks_for("motocoasa");
        endUser.sort_by_price_desc();
        endUser.should_see_sorted_definition("Cositoare cu 5 discuri Fimaks FMDM 210");
    }

//    fuasbifuasvf
//    Casca Flip-up SCORPION EXO 3000 AIR SOLID 2XL Antracit

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDefinition() {
        return definition;
    }

    public void setDefinition(String definition) {
        this.definition = definition;
    }


}