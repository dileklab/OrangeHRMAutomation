package com.orangehrm.utilities;

import java.util.ArrayList;
import java.util.Arrays;

public class Constants {

    public static final long PAGE_LOAD_TIMEOUT = 30;
    public static final long IMPLICIT_WAIT = 15;
    public static final long EXPLICIT_WAIT = 15;

    public static final int SHORT_WAIT = 3000;
    public static final int MEDIUM_WAIT = 6000;
    public static final int LONG_WAIT = 10000;

    public static final String LOGIN_PAGE_TITLE = "OrangeHRM";
    public static final String LOGIN_PAGE_ERROR_MESSAGE = "Invalid credentials";

    public static final String HOME_PAGE_TITLE = "OrangeHRM";
    public static final ArrayList<String> HOME_PAGE_ITEMS = new ArrayList<>(Arrays.asList(
            "Assign Leave",
            "Leave List",
            "Timesheets",
            "Apply Leave",
            "My Leave",
            "My Timesheet"));
    public static final String HOME_PAGE_URL = "https://opensource-demo.orangehrmlive.com/index.php/dashboard";

    public static final String ADD_EMPLOYEE_PAGE_HEADER = "Add Employee";

    public static final String TEST_DATA_SHEET_PATH = "./src/main/java/com/orangehrm/testData/OrangeHRMData.xlsx";
}
