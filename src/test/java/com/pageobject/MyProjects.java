package com.pageobject;

import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

import com.utils.Baseclass;

public class MyProjects extends Baseclass {

	Baseclass bs = new Baseclass();

	@SuppressWarnings("static-access")
	public MyProjects(WebDriver driver) {
		this.driver = driver;
		PageFactory.initElements(driver, this);

	}

	@FindBy(xpath = "//*[text()='My Projects']")
	private WebElement myprojects;

	@FindBy(xpath = "(//div[contains(@class,'ProjectList_projectListTableRow__xNvo1 MuiBox-root')]//div)[1]")
	private WebElement projectlistvalidation;

	@FindBy(xpath = "//button[text()='Add Project']")
	private WebElement addProject;

	@FindBy(id = "projectName")
	private WebElement projectName;

	@FindBy(id = "slrObjective")
	private WebElement slrObjective;

	@FindBy(name = "populationInclusionCriteria")
	private WebElement populationInclusionCriteria;

	@FindBy(id = "interventionInclusionCriteria")
	private WebElement interventionInclusionCriteria;

	@FindBy(id = "comparatorInclusionCriteria")
	private WebElement comparatorInclusionCriteria;

	@FindBy(id = "projectName-label")
	private WebElement projectName_LabelValidation;

	@FindBy(xpath = "//p[text()='Create Project']")
	private WebElement createProjectValidation;

	@FindBy(xpath = "//button[text()='Create']")
	private WebElement createButton;

	@FindBy(xpath = "//p[text()='Project added successfully']")
	private WebElement createProjectToaster;

	@FindBy(xpath = "//p[text()='My Projects']")
	private WebElement myProjectsBreadCrump;

	@FindBy(xpath = "(//button[@type='button'])[3]")
	private WebElement actionsButton;

	@FindBy(xpath = "//li[@data-id='edit collab']")
	private WebElement addCollaborator;

	@FindBy(xpath = "(//input[@type='text'])[2]")
	private WebElement addcollaboratorUserAdd;

	@FindBy(id = "select-user-to-extract-data-option-0")
	private WebElement addcollaboratorClick;

	@FindBy(xpath = "//p[text()='Assign']")
	private WebElement assignButton;

	@FindBy(xpath = "//p[text()='User access updated successfully.']")
	private WebElement userassignedToasterMessage;           

	@FindBy(xpath = "//li[@data-id='edit']")
	private WebElement editProject;

	@FindBy(xpath = "//button[text()='Save']")
	private WebElement editSave;

	@FindBy(xpath = "//p[text()='Project updated successfully']")
	private WebElement updateToaster;

	@FindBy(xpath = "//div[contains(@class,'flex MuiBox-root')]//p[1]")
	private WebElement projectTitleVerification;

	@FindBy(xpath = "//input[@placeholder='Search by title']")
	private WebElement search;

	@FindBy(xpath = "(//img[@alt='Logo'])[2]")
	private WebElement logo;

	@FindBy(xpath = "(//button[@title='Open'])[1]")
	private WebElement addcollabOpenArrow;

	@FindBy(xpath = "//li[@data-id='duplicate']")
	private WebElement cloneProject;

	@FindBy(xpath = "//h2[@id='alert-dialog-title']")
	private WebElement duplicateProjectPopupValidation;

	@FindBy(xpath = "(//input[@name='quiz'])[2]")
	private WebElement copy_only_the_articles_into_a_new_project;

	@FindBy(xpath = "(//div[contains(@class,'MuiFormControl-root MuiFormControl-fullWidth')]//div)[3]")
	private WebElement duplicateProjectName;

	@FindBy(xpath = "//button[contains(@class,'MuiButtonBase-root MuiButton-root')]/following-sibling::button[1]")
	private WebElement duplicateProjectCreation;

	@FindBy(xpath = "//p[text()='Duplicate project saved successfully']")
	private WebElement duplicateProjectSavedToaster;

	@FindBy(xpath = "//div[contains(@class,'MuiInputBase')]/input[contains(@id,'outlined')]")
	private WebElement searchFilter;

	@FindBy(xpath = "//div[contains(@class,'ProjectList_projectListTableOddCell')]/p[contains(@class,'MuiTypography-root')]")
	private WebElement listTable;

	public void validationMyProjects() {
		explicitwait();
		wait.until(ExpectedConditions.elementToBeClickable(myprojects));
		Assert.assertNotNull("Image element is not present", myprojects);
	}

	String currentProjectListValue;

	public void projectListValidation() {
		wait.until(ExpectedConditions.visibilityOf(projectlistvalidation));
		currentProjectListValue = projectlistvalidation.getText();
		Assert.assertNotNull(currentProjectListValue);
		Assert.assertTrue(currentProjectListValue.length() > 0);

	}

	public void addProject() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(addProject));
		addProject.click();
	}

	public void placeHolderValidation() {
		explicitwait();
		wait.until(ExpectedConditions.elementToBeClickable(createProjectValidation));
		Assert.assertNotNull("Image element is not present", createProjectValidation);

		wait.until(ExpectedConditions.elementToBeClickable(projectName_LabelValidation));
		Assert.assertNotNull("Image element is not present", projectName_LabelValidation);
	}

	public void createProjectRequiredDeatils() {
		passText(projectName, randomNumberString + "Automation");
		passText(slrObjective, "Automation" + randomNumberString);
		passText(populationInclusionCriteria, "PICOS_Automation" + randomNumberString);
		passText(interventionInclusionCriteria, "PICOS_Automation" + randomNumberString);
		passText(comparatorInclusionCriteria, "PICOS_Automation" + randomNumberString);

	}

	public void createButtonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(createButton));
		clickButton(createButton);
	}

	public void titleVerification() {
		explicitwait();
		wait.until(ExpectedConditions.elementToBeClickable(projectTitleVerification));
		Assert.assertNotNull("projectTitleVerification is not present", projectTitleVerification);
	}

	public void projectSuccessfullyAddedToaster() {
		implictwait();
		validateToasterMessage(createProjectToaster, constantValues.projectaddedToaster);
	}

	public void myprojectBreadCrumpClick() {
		implictwait();
		jsClick(driver, myProjectsBreadCrump);

	}

	public void myprojectEditCollabClick() {
		jsClick(driver, actionsButton);
		wait.until(ExpectedConditions.elementToBeClickable(addCollaborator));
		clickButton(addCollaborator);
	}

	public void addcollaboratorUserAdd() throws InterruptedException {
		clickButton(addcollaboratorUserAdd);
		passText(addcollaboratorUserAdd, "Eisa Abdullah");
		clickUsingKeys(addcollaboratorUserAdd);
	}

	public void assignButtonClick() {
		wait.until(ExpectedConditions.elementToBeClickable(assignButton));
		clickButton(assignButton);

	}

	public void toasterValidtaion() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(userassignedToasterMessage));
		validateToasterMessage(userassignedToasterMessage, constantValues.userAssignedToaster);
		Thread.sleep(explicit_timeduration);

	}

	public void myprojectEditProjectClick() {
		jsClick(driver, actionsButton);
		wait.until(ExpectedConditions.elementToBeClickable(editProject));
		clickButton(editProject);
	}

	public void editProjectRequiredDeatils() {

		wait.until(ExpectedConditions.elementToBeClickable(projectName));
		clearTextUsingKeys(projectName);
		passText(projectName, randomNumberString + "EditAutomation");
		clearTextUsingKeys(slrObjective);
		passText(slrObjective, "EditAutomation" + randomNumberString);
		clearTextUsingKeys(populationInclusionCriteria);
		passText(populationInclusionCriteria, "PICOS_Automation_E" + randomNumberString);
		clearTextUsingKeys(interventionInclusionCriteria);
		passText(interventionInclusionCriteria, "PICOS_Automation_E" + randomNumberString);
		clearTextUsingKeys(comparatorInclusionCriteria);
		passText(comparatorInclusionCriteria, "PICOS_Automation_E" + randomNumberString);

	}

	public void editSaveBtnClick() {
		wait.until(ExpectedConditions.elementToBeClickable(editSave));
		clickButton(editSave);
	}

	public void projectUpdateToaster() {
		validateToasterMessage(updateToaster, constantValues.projecteditToaster);

	}

	public void searchProject() {
		wait.until(ExpectedConditions.elementToBeClickable(search));
		passText(search, "Automation");
	}

	public void logovalidation() throws InterruptedException {
		Thread.sleep(explicit_timeduration);
		wait.until(ExpectedConditions.elementToBeClickable(logo));
		Assert.assertNotNull("Image element is not present", logo);
	}

	public String listValidation(String expectvalue) {
		List<WebElement> list = driver.findElements(By.xpath("//*[@role='listbox']/li/ul/li"));
		ArrayList<WebElement> li = new ArrayList<WebElement>();
		li.addAll(list);

		for (WebElement each : li) {
			String currentValue = each.getText();
			System.out.println(currentValue);

			if (currentValue.equals(expectvalue)) {
				each.click();
			}
		}
		return expectvalue;
	}

	public void myprojectCloneClick() {
		jsClick(driver, actionsButton);
		jsClick(driver, actionsButton);
		wait.until(ExpectedConditions.elementToBeClickable(cloneProject));
		clickButton(cloneProject);
	}

	public void duplicatePopupValidation() {
		explicitwait();
		wait.until(ExpectedConditions.elementToBeClickable(duplicateProjectPopupValidation));
		Assert.assertNotNull("Text is not present", duplicateProjectPopupValidation);
	}

	public void duplicatePopupClick() {

		boolean selectState = copy_only_the_articles_into_a_new_project.isSelected();
		if (selectState == false) {
			copy_only_the_articles_into_a_new_project.click();
		} else {

			logger("Not clickable");
		}

	}

	public void duplicateProjectName() {
		wait.until(ExpectedConditions.elementToBeClickable(duplicateProjectName));
		jsSetTextAndClick(driver, duplicateProjectName, randomNumberString);
	}

	public void duplicateProjectCreation() {
		wait.until(ExpectedConditions.elementToBeClickable(duplicateProjectCreation));
		clickButton(duplicateProjectCreation);
	}

	public void duplicateProjectToasterValidation() {
		wait.until(ExpectedConditions.elementToBeClickable(duplicateProjectSavedToaster));
		validateToasterMessage(duplicateProjectSavedToaster, constantValues.duplicateProjectSavedToaster);
	}

	public void searchFilter() throws InterruptedException {
		wait.until(ExpectedConditions.elementToBeClickable(searchFilter));
		System.out.println(currentProjectListValue);
		jsClick(driver, searchFilter);

		wait.until(ExpectedConditions.elementToBeClickable(logo));
		jsClick(driver,logo);
	}
}
