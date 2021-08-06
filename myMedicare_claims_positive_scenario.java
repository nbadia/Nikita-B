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
	
	@Then("Select My Medicare")
	public void select_my_medicare() throws Exception {
	    try {
	    	page_wait(2000);
	    	click("circle_my_medicare_icon");
	    	page_wait(2000);
	    	value = driver.findElement(By.xpath(OR_reader( "circle_my_medicare_icon"))).isDisplayed();
			Assert.assertEquals(true,value);
	    } catch (Exception e) {
	    	e.printStackTrace();
	    	takeScreenShot("select_my_medicare");
	    }
	}
	@Then("Click on Claims from the My Medicare dashbord")
	public void click_on_claims_from_the_my_medicare_dashbord() throws Exception {
		try {
			page_wait(2000);
			click("my_medicare_claims_icon");
			value = driver.findElement(By.xpath(OR_reader( "my_medicare_claims_icon"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("click_claims");
		}
	}

	@When("Claims title and back arrow displayed")
	public void claims_title_and_back_arrow_displayed() throws Exception{
		try {
			element_visible_wait(360,"claims_select_claim_type_text");
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("claims_title_and_back_arrow_displayed");
		}
		}

	@Then("Claims title and back arrow are displayed on page")
	public void title_arrow_visible() throws Exception{
		try {
		value = driver.findElement(By.xpath(OR_reader("claims_title"))).isDisplayed();
		Assert.assertEquals(true, value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("claims_title");
		}
	}

	@When("Select Claim type from the dropdown field")
	public void select_claim_type_from_the_dropdown_field() throws Exception{
		try {
			click("claims_type_icon");
			value = driver.findElement(By.xpath(OR_reader( "claims_list"))).isDisplayed();
		Assert.assertEquals(true,value);
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("claims_list");
}
	}

@Then("Filtered Claims summary and Claims are displayed")
public void filtered_claims_summary_and_claims_are_displayed() throws Exception{
    	try {
    		value = driver.findElement(By.xpath(OR_reader("claims_summary_list"))).isDisplayed();
    		Assert.assertEquals(true, value);
    		} catch (Exception e) {
    			e.printStackTrace();
    			takeScreenShot("claims_summary_list");
    	}
}

@When("Select Time period from the dropdown field")
public void select_time_period_from_the_dropdown_field() throws Exception {
	try {
		click("time_period_icon");
		value = driver.findElement(By.xpath(OR_reader( "time_period"))).isDisplayed();
		Assert.assertEquals(true,value);
			} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("time_period");
		}
}

@Then("Filtered Claims summary and Claims page are displayed")
public void filtered_claims_summary_and_claims_page_are_displayed() throws Exception {
    	try {
    		value = driver.findElement(By.xpath(OR_reader("claims_summary_page_text"))).isDisplayed();
    		Assert.assertEquals(true, value);
    		value = driver.findElement(By.xpath(OR_reader("claims_page"))).isDisplayed();
			Assert.assertEquals(true,value);
    		} catch (Exception e) {
    			e.printStackTrace();
    			takeScreenShot("claims_summary_page_text");
    		}
}

@Given("Patient portion and Insurer portion displayed on the page")
public void patient_portion_and_insurer_portion_displayed_on_the_page() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("patient_insurer_portion_text"))).isDisplayed();
		Assert.assertEquals(true, value);
		value = driver.findElement(By.xpath(OR_reader("claims_insurer_portion_text"))).isDisplayed();
		Assert.assertEquals(true,value);
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("patient_and_insurer_portion");
	}
}

@Given("{Here is a helpful breakdown} text is displayed on the page")
public void text_is_displayed_on_the_page() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("claims_helpful_breakdown_text"))).isDisplayed();
		Assert.assertEquals(true, value);
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot ("claims_helpful_breakdown_text");
	}
}

@Given("All the breakdown and total amount are displayed")
public void all_the_breakdown_and_total_amount_are_displayed() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("claims_helpful_breakdown_text"))).isDisplayed();
		Assert.assertEquals(true, value);
		str= driver.findElement(By.xpath(OR_reader("claims_institutional"))).getText();
		Assert.assertEquals(str,td_reader("claims_institutional"));
		str= driver.findElement(By.xpath(OR_reader("claims_pharmacy"))).getText();
		Assert.assertEquals(str,td_reader("claims_pharmacy"));
		str= driver.findElement(By.xpath(OR_reader("claims_professional"))).getText();
		Assert.assertEquals(str,td_reader("claims_professional"));
		str= driver.findElement(By.xpath(OR_reader("claims_HHA"))).getText();
		Assert.assertEquals(str,td_reader("claims_HHA"));
		str= driver.findElement(By.xpath(OR_reader("claims_DME"))).getText();
		Assert.assertEquals(str,td_reader("claims_DME"));
		str= driver.findElement(By.xpath(OR_reader("claims_vision"))).getText();
		Assert.assertEquals(str,td_reader("claims_vision"));
		str= driver.findElement(By.xpath(OR_reader("claims_dental"))).getText();
		Assert.assertEquals(str,td_reader("claims_dental"));
		str= driver.findElement(By.xpath(OR_reader("claims_total"))).getText();
		Assert.assertEquals(str,td_reader("claims_total"));
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("claims_helpful_breakdown_text");
	}
}

@When("Click on funnel icon then select Date created and Date created")
public void click_on_funnel_icon_then_select_date_created_and_date_created() throws Exception {
	try {
		click("funnel_icon");
		value = driver.findElement(By.xpath(OR_reader( "funnel_icon"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("select_date_created_text");
		value = driver.findElement(By.xpath(OR_reader( "select_date_created_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		} catch (Exception e) {
				e.printStackTrace();
				takeScreenShot("click_on_funnel_icon_then_select_date_created_and_date_created");
		}
}

@Then("Oldest and Newest claims claims are diplayed")
public void oldest_newest_claims() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("claims_oldest_newest_box"))).isDisplayed();
		Assert.assertEquals(true, value);		
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("oldest_newest_claim");
	}
}

@Then("Total number records found text displayed.Also, user should able to see the list of records with Date")
public void total_records_found_text_displayed() throws Exception {
		try {
			value = driver.findElement(By.xpath(OR_reader("claims_record_found_text"))).isDisplayed();
			Assert.assertEquals(true,value);
		} catch (Exception e) {
			e.printStackTrace();
			takeScreenShot("total_records_found_text_displayed");
		}
}

@When("Select one claim under list of claims")
public void select_one_claim_under_list_of_claims() throws Exception {
    try {
    	element_visible_wait(360, "claims_prescription_drugs_claim");
    	click("claims_prescription_drugs_claim");
    	value = driver.findElement(By.xpath(OR_reader("claim_claims_number"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("select_claim");
		value = driver.findElement(By.xpath(OR_reader("select_claim"))).isDisplayed();
		Assert.assertEquals(true,value);
    } catch (Exception e) {
    	e.printStackTrace();
    	takeScreenShot("select_claim");
    }
}

@Then("Selected claim details displayed")
public void selected_claim_details_displayed() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("claims_claim_details"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_claim_number"))).getText();
		Assert.assertEquals(str,td_reader("claims_claim_number"));
		value = driver.findElement(By.xpath(OR_reader("claims_claim_type_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_claim_type_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_claim_type_value"));
		value = driver.findElement(By.xpath(OR_reader("claims_claim_provider_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_claim_provider_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_claim_provider_value"));
		value = driver.findElement(By.xpath(OR_reader("claims_claim_insurer_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_claim_insurer_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_claim_insurer_value"));
		value = driver.findElement(By.xpath(OR_reader("claims_claim_patient_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_claim_patient_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_claim_patient_value"));
		value = driver.findElement(By.xpath(OR_reader("claims_claim_service_date_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_claim_service_date_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_claim_service_date_value"));
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("Selected claim details displayed");
	}
}

@When("Expand and view Services of selected claim")
public void expand_and_view_services_of_selected_claim() throws Exception {
    try {
    	click("claims_services_down_arrow");
    	value = driver.findElement(By.xpath(OR_reader("claims_services_down_arrow"))).isDisplayed();
		Assert.assertEquals(true,value);
    } catch (Exception e) {
    	e.printStackTrace();
    	takeScreenShot("expand_and_view_services_of_selected_claim");
    }
}

@Then("Services details should be displayed")
public void services_details_displayed() throws Exception {
	try {
		value = driver.findElement(By.xpath(OR_reader("claims_service_name"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_service_name"))).getText();
		Assert.assertEquals(str,td_reader("claims_service_name"));
		value = driver.findElement(By.xpath(OR_reader("claims_service_quantity_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_service_quantity_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_service_quantity_value"));
		value = driver.findElement(By.xpath(OR_reader("claims_service_insurer_portion_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_service_insurer_portion_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_service_insurer_portion_value"));
		value = driver.findElement(By.xpath(OR_reader("claims_service_patient_portion_text"))).isDisplayed();
		Assert.assertEquals(true,value);
		str= driver.findElement(By.xpath(OR_reader("claims_service_patient_portion_value"))).getText();
		Assert.assertEquals(str,td_reader("claims_service_patient_portion_value"));
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("services_details");
	}
}
@Given("Click on all the icons under related records")
public void click_on_all_the_icons_under_related_records() throws Exception {
	try {
	click("claims_related_record_claims");
	value = driver.findElement(By.xpath(OR_reader("claims_title"))).isDisplayed();
	Assert.assertEquals(true,value);
	value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
	Assert.assertEquals(true,value);
	click("claims_back_arrow");
	click("claims_related_record_conditions");
	value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
	Assert.assertEquals(true,value);
	click("claims_back_arrow");
	click("claims_related_record_medications");
	value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
	Assert.assertEquals(true,value);
	click("claims_back_arrow");
	} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("click_on_all_the_icons_under_related_records");
	}
}

@Given("Click on {string} icon and select each icon under {string} popup")
public void click_on_icon_and_select_each_icon_under_popup(String string, String string2) throws Exception {
	try {
		click("claims_related_record_more");
		click("claims_related_record_allergies");
		value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("claims_back_arrow");
		click("claims_related_record_more");
		click("claims_related_record_procedures");
		value = driver.findElement(By.xpath(OR_reader("claims_back_arrow"))).isDisplayed();
		Assert.assertEquals(true,value);
		click("claims_back_arrow");
		click("claims_related_record_more");
		driver.closeApp();
		} catch (Exception e) {
		e.printStackTrace();
		takeScreenShot("My_medicare_claims_positive_positive_tc_013");
	}
	}
}

