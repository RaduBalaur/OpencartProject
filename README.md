Hello! This project is an automation framework I have built as part of my QA Automation Engineer Portfolio.
________________________________________
🚀 Overview
This framework validates core OpenCart workflows, including:
•	User registration
•	Login (including Data-Driven Testing)
•	Product search
•	Add-to-cart functionality
•	Shopping cart behavior
________________________________________
🧰 Tech Stack
•	Java 21
•	Selenium WebDriver
•	TestNG
•	Maven
•	Page Object Model (POM)
•	Apache POI (Excel Data-Driven Testing)
•	Extent Reports (HTML reporting)
•	Docker + Selenium Grid (parallel/distributed execution)
•	Jenkins (CI/CD automation)
•	Log4j (logging)
________________________________________
⚙️ Setup & Installation
1.	Install Java 21
2.	Install Maven
3.	Install Docker Desktop (if running Selenium Grid)
4.	Clone this repository:
git clone <https://github.com/RaduBalaur/OpencartProject.git>
Note: If multiple JDKs are installed, make sure Maven uses JDK 21 for compilation and test execution.
________________________________________
▶️ Running the Tests
Local Execution:
mvn clean test

Run on Selenium Grid (Docker)
Start the grid:
docker-compose up 

Using run.bat Script:
Double-click run.bat to run tests locally.
The batch file automatically sets the project folder and executes Maven.
________________________________________
📊 Reporting
Test reports are automatically generated using Extent Reports.

Reports include:
•	Pass/Fail status
•	Screenshots for failed tests
•	Execution logs
•	Environment details
________________________________________
🧪 CI/CD with Jenkins
This project can also run using Jenkins.
Running Jenkins locally (if needed):
java -jar jenkins.war --enable-future-java
________________________________________
🎯 Purpose
This project demonstrates capabilities of a self-taught QA Automation Engineer:
•	Designing scalable test architecture
•	Building reusable components
•	Implementing CI/CD and containerized grid execution
•	Using industry-standard automation tools
________________________________________

________________________________________

