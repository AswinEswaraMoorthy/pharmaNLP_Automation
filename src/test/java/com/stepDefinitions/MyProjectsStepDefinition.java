package com.stepDefinitions;

import com.pageobject.LoginPage;
import com.pageobject.MyProjects;
import com.utils.Baseclass;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class MyProjectsStepDefinition extends Baseclass {

	MyProjects mp;

	// Existing project
	@Given("the user is on the My Projects page")
	public void the_user_is_on_the_my_projects_page() {
		mp = new MyProjects(driver);
		mp.validationMyProjects();
	}

	@Then("the user should see a list of existing projects")
	public void the_user_should_see_a_list_of_existing_projects() {
		mp.projectListValidation();
	}

	// create

	@Given("click on Add Project button")
	public void click_on_add_project_button() throws InterruptedException {
		mp.addProject();

	}

	@Given("the user is on the Create Project screen")
	public void the_user_is_on_the_create_project_screen() {

		mp.placeHolderValidation();
	}

	@When("the user fills in all required fields with valid data")
	public void the_user_fills_in_all_required_fields_with_valid_data() {
		mp.createProjectRequiredDeatils();
	}

	@When("clicks on the create button")
	public void clicks_on_the_create_button() {
		mp.createButtonClick();

	}

	@Then("the project should be successfully saved")
	public void the_project_should_be_successfully_saved() throws InterruptedException {
		mp.projectSuccessfullyAddedToaster();
		Thread.sleep(explicit_timeduration);
		mp.titleVerification();
	}

	@Then("the user should be redirected to the My Projects page")
	public void the_user_should_be_redirected_to_the_my_projects_page() {
		mp.myprojectBreadCrumpClick();
	}

	@Then("the new project should be visible in the projects list")
	public void the_new_project_should_be_visible_in_the_projects_list() {
		mp.projectListValidation();
	}

	// edit
	@Given("clicks on the edit button for the selected project")
	public void clicks_on_the_edit_button_for_the_selected_project() {
		System.out.println("clicked");
		mp.myprojectEditProjectClick();
	}

	@When("the user navigates to the Edit Project screen and modifies the project details with valid data")
	public void the_user_navigates_to_the_edit_project_screen_and_modifies_the_project_details_with_valid_data() {
		mp.editProjectRequiredDeatils();
	}

	@When("clicks on the save changes button")
	public void clicks_on_the_save_changes_button() {
		mp.editSaveBtnClick();
	}

	@Then("the project should be successfully updated")
	public void the_project_should_be_successfully_updated() throws InterruptedException {
		mp.projectUpdateToaster();

	}

	// Add collab
	@Given("the user is on the My Projects screen")
	public void the_user_is_on_the_my_projects_screen() throws InterruptedException {
		mp.logovalidation();
	}

	@When("the user selects a project to Add collaborators")
	public void the_user_selects_a_project_to_add_collaborators() {
		mp.myprojectEditCollabClick();
	}

	@When("makes changes to the collaborators list")
	public void makes_changes_to_the_collaborators_list() throws InterruptedException {
		mp.addcollaboratorUserAdd();
	}

	@When("clicks on the Save button")
	public void clicks_on_the_save_button() {
		mp.assignButtonClick();
	}

	@Then("the collaborators for the project should be successfully updated")
	public void the_collaborators_for_the_project_should_be_successfully_updated() throws InterruptedException {
		mp.toasterValidtaion();
	}

	// clone

	@When("the user selects a project to Clone and clicks the clone project")
	public void the_user_selects_a_project_to_clone_and_clicks_the_clone_project() {
		mp.myprojectCloneClick();
		mp.duplicatePopupValidation();
		mp.duplicatePopupClick();
		mp.duplicateProjectName();
		
	}

	@Then("a copy of the project should be created")
	public void a_copy_of_the_project_should_be_created() {
		mp.duplicateProjectCreation();
		mp.duplicateProjectToasterValidation();
	}

	@Then("the copy should appear in the projects list")
	public void the_copy_should_appear_in_the_projects_list() throws InterruptedException {
		mp.projectListValidation();
		mp.logovalidation();
		mp.searchFilter();
	}
}
