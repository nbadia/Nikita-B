package Stepdefinitions;

import java.io.IOException;

import org.junit.Assert;
import org.openqa.selenium.By;

import Reusable_Functions.Generic_functions;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class myMedicare_claims_positive_scenario extends Generic_functions{
	static boolean value;
	@Given("Launch the URL and click on Login button")
	public void launch_the_url_and_click_on_login_button() {
		try {
			app_launch();
			page_wait(4000);
			value = driver.findElement(By.xpath(OR_reader( "welcome_page_title"))).isDisplayed();
			Assert.assertEquals(true,value);
			page_wait(4000);
			click("welcome_login");
			//page_explicit_wait("continue");
			click("continue");
			page_wait(9000);
			app_login(0,0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	@When("Clicks on the Circles from home dashboard")
	public void clicks_on_the_circles_from_home_dashboard() throws IOException {
	    try {
	    	page_wait(4000);
	    click("circles");
	    page_wait(3000);
	    value = driver.findElement(By.xpath(OR_reader( "circles_assert"))).isDisplayed();
		Assert.assertEquals(true,value);
	}
	    catch (Exception e) {
		e.printStackTrace();
	}}
	START
	@Then("Select My Medicare")
	public void select_my_medicare() throws IOException {
	    try {
	    	page_wait(20);
	    	click("circle_my_medicare_icon");
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	takeScreenShot(select_my_medicare);
	    }
	}
	@Then("Click on Claims from the My Medicare dashbord")
	public void click_on_claims_from_the_my_medicare_dashbord() throws IOException{
		try {
			click("my_medicare_claims_icon");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_claims");
		}
	}

	@When("Claims title and back arrow displayed")
	public void claims_title_and_back_arrow_displayed() throws IOException{
		try {
			element_visible_wait(360,"claims_select_claim_type_text");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("My_medicare_claims_positive_positive_tc_002");
		}
		}

	@Then("Claims title and back arrow displayed on the page")
	public void claims_title_and_back_arrow_displayed_on_the_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

	@When("Select Claim type from the dropdown field")
	public void select_claim_type_from_the_dropdown_field() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Filtered Claims summary and Claims are displayed")
public void filtered_claims_summary_and_claims_are_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Select Time period from the dropdown field")
public void select_time_period_from_the_dropdown_field() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Filtered Claims summary and Claims page are displayed")
public void filtered_claims_summary_and_claims_page_are_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Patient portion and Insurer portion displayed on the page")
public void patient_portion_and_insurer_portion_displayed_on_the_page() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("{string}  text is displayed on the page")
public void text_is_displayed_on_the_page(String string) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("All the breakdown and total amount are displayed")
public void all_the_breakdown_and_total_amount_are_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Click on funnel icon then select Date created and Date created")
public void click_on_funnel_icon_then_select_date_created_and_date_created() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Oldest and Newest claims claims are diplayed")
public void oldest_and_newest_claims_claims_are_diplayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Total number records found text displayed.Also, user should able to see the list of records with Date")
public void total_number_records_found_text_displayed_also_user_should_able_to_see_the_list_of_records_with_date() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Select one claim under list of claims")
public void select_one_claim_under_list_of_claims() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Selected claim details displayed")
public void selected_claim_details_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@When("Expand and view Services of selected claim")
public void expand_and_view_services_of_selected_claim() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Then("Services details should be displayed")
public void services_details_should_be_displayed() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Click on all the icons under related records")
public void click_on_all_the_icons_under_related_records() {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}

@Given("Click on {string} icon and select each icon under {string} popup")
public void click_on_icon_and_select_each_icon_under_popup(String string, String string2) {
    // Write code here that turns the phrase above into concrete actions
    throw new io.cucumber.java.PendingException();
}}

