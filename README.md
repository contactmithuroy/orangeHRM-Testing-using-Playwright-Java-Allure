# OrangeHRM Automation Project

## 📄 Project Description

This project automates the OrangeHRM “Login” and “Apply Leave” features using Playwright, Java, Maven, TestNG, and Allure reporting.  
The automation is implemented following the Page Object Model (POM) design pattern for better maintainability and readability. Step-wise screenshots are captured during test execution for Allure reporting.

### Tools & Technologies Used:
- Programming Language: Java 11+
- Automation Tool: Playwright for Java
- Build Tool: Maven
- Test Framework: TestNG
- Reporting: Allure Report
- Design Pattern: Page Object Model (POM)
- Browser Support: Chrome, Firefox, Edge (configurable)
---

### 🗂 Project Structure
```bash
OrangeHRM-Automation/
│
├── pom.xml                     
├── README.md                     
├── config.properties      
├── testng.xml
├── README.md
├── src/
│   ├── main/
│   │   └── java/
│   │       └── com/orangehrm/
│   │           ├── pages/            
│   │           │   ├── LoginPage.java
│   │           │   ├── ApplyLeavePage.java
│   │           │   └── BasePage.java
│   │           │
│   │           └── utils/            
│   │               ├── ConfigReader.java
│   │
│   └── test/
│       └── java/
│           └── com/orangehrm/tests/
│               ├── BaseTest.java
│               ├── LoginTest.java
│               └── ApplyLeaveTest.java
│
├── Allure-result/
├── test-output/                      
```

---
### ⚙️ How to Clone and Setup

### Clone the repository
```bash
git clone "https://github.com/contactmithuroy/orangeHRM-Testing-using-Playwright-Java-Allure.git"
cd orangeHRM-Testing-using-Playwright-Java-Allure
```

Install Dependencies

- Ensure Java 11+ is installed.

- Ensure Maven is installed.

# All required dependencies are in pom.xml. Install via:

```bash
mvn clean install
```

### Update Configurations

#Update config.properties with your credentials and test data if required:

username=Admin
password=admin123
leave.from.date=2024-01-15
leave.to.date=2024-01-16
leave.comment=Personal leave for family event

▶️ How to Run Tests

Run all tests using Maven:
```bash
mvn clean test
```

Generate and serve Allure report:
```bash
allure serve allure-results
```
### Output: 
<img width="1348" height="361" alt="image" src="https://github.com/user-attachments/assets/07a060fe-7b6b-4c34-aeba-f1c6d9354f5c" />

<img width="1359" height="499" alt="image" src="https://github.com/user-attachments/assets/c55c625f-e639-463d-a5b8-fdbbe0de8ff2" />

### Video Execution Output
[Watch Video](https://drive.google.com/file/d/1sWXQjHrn8zSjiLVEy_4tMox_NpJQjuUB/view?usp=sharing)


### ✅ Notes

Tests are designed with Page Object Model for maintainability.

Screenshots are automatically captured during test execution for Allure reporting.

Browser type can be changed in BaseTest or via properties (Chrome, Firefox, Edge).

