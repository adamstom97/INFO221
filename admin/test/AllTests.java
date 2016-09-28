/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.runner.RunWith;
import org.junit.runners.Suite;

/**
 * A class to call all the project's test classes at once.
 * 
 * @author adamstom97
 * @version 3.0
 */
@RunWith(Suite.class)
@Suite.SuiteClasses({dao.TestProductDAO.class, dao.TestCustomerDAO.class, 
    dao.TestOrderDAO.class, gui.TestEntry.class, gui.TestDisplay.class})
public class AllTests {}
