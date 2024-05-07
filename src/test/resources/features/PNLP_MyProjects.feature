@Myprojects
Feature: Project Management in My Projects Page  


Background:
    Given User lauch the PharmaNLP application
    Then The logo should occur
    When User login with valid username and password
      
  Scenario: viewExisting,createProject,editProject,addCollaboratorOnProjects,cloneProject
    Given the user is on the My Projects page
    Then the user should see a list of existing projects
    
    And   click on Add Project button 
    Given the user is on the Create Project screen
    When  the user fills in all required fields with valid data
    And   clicks on the create button
    Then the project should be successfully saved
    And the user should be redirected to the My Projects page
    And the new project should be visible in the projects list
    

    Given the user is on the My Projects page
    And clicks on the edit button for the selected project
    When the user navigates to the Edit Project screen and modifies the project details with valid data
    And clicks on the save changes button
    Then the project should be successfully updated    

    Given the user is on the My Projects screen
    When the user selects a project to Add collaborators
    And makes changes to the collaborators list
    And clicks on the Save button
    Then the collaborators for the project should be successfully updated
    
    When the user selects a project to Clone and clicks the clone project
    Then a copy of the project should be created
    And the copy should appear in the projects list
  
  