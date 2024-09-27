package com.razah.dev.bookstore.transaction.constant;

public enum PositionEmployee {
    INTERN("Intern"),
    JUNIOR_DEVELOPER("Junior Developer"),
    SENIOR_DEVELOPER("Senior Developer"),
    PROJECT_MANAGER("Project Manager"),
    QA_ENGINEER("QA Engineer"),
    BUSINESS_ANALYST("Business Analyst"),
    HUMAN_RESOURCES("Human Resources"),
    MARKETING_SPECIALIST("Marketing Specialist"),
    SALES_REPRESENTATIVE("Sales Representative"),
    CEO("Chief Executive Officer"),
    CTO("Chief Technology Officer"),
    CFO("Chief Financial Officer");

    private final String title;

    PositionEmployee(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }
}
