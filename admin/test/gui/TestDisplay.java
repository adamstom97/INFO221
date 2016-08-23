/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import dao.Dao;
import domain.Product;
import gui.helpers.SimpleListModel;
import java.util.Collection;
import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;
import static org.assertj.swing.core.matcher.DialogMatcher.withTitle;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.mockito.Mockito.mock;

/**
 * A class for testing the project's ProductDisplay gui.
 * 
 * @author adamstom97
 * @version 2.0
 */
public class TestDisplay {
    private Dao list;
    private DialogFixture fixture;
    private Robot robot;
    private Product product1;
    private Product product2;

    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(75);

        this.product1 = new Product(1, "A", "aa", "a", 1.00, 1);
        this.product2 = new Product(2, "B", "bb", "b", 1.00, 1);

        Collection<Product> products = new TreeSet<>();
        products.add(product1);
        products.add(product2);

        Collection<String> categories = new TreeSet<>();
        categories.add("a");
        categories.add("b");
        
        Set<Product> categoryFilter = new HashSet<>();
        categoryFilter.add(product2);

        list = mock(Dao.class);
        when(list.getProductList()).thenReturn(products);
        when(list.getCategoryList()).thenReturn(categories);
        when(list.getProductByID("1")).thenReturn(product1);
        when(list.getProductsByCategory("b")).thenReturn(categoryFilter);

        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                products.remove(product1);
                return null;
            }
        }).when(list).deleteProduct(product1);
    }

    @Test
    public void testDisplay() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").
                target().getModel();

        assertEquals("Ensure categories is set to All", "All", 
                fixture.comboBox("boxCategoryFilter").selectedItem());
        assertTrue("Ensure list contains the correct product", 
                model.contains(product1));
        assertTrue("Ensure list contains the correct product", 
                model.contains(product2));
        assertEquals("Ensure list only contains the correct products", 2, 
                model.getSize());
    }

    @Test
    public void testDeleteButton() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.list("lstDisplay").selectItem("A");
        fixture.button("btnDelete").click();
        DialogFixture confirmDialog = fixture.dialog(
                withTitle("Select an Option").andShowing()).requireVisible();
        confirmDialog.button(withText("No")).click();

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").
                target().getModel();

        assertEquals("Ensure list contains the correct products", 2, 
                model.getSize());
        assertTrue("Ensure list contains the correct product", 
                model.contains(product1));
        assertTrue("Ensure list contains the correct product", 
                model.contains(product2));
        
        fixture.list("lstDisplay").selectItem("A");
        fixture.button("btnDelete").click();
        confirmDialog = fixture.dialog(
                withTitle("Select an Option").andShowing()).requireVisible();
        confirmDialog.button(withText("Yes")).click();

        model = (SimpleListModel) fixture.list("lstDisplay").
                target().getModel();

        assertEquals("Ensure list only contains the correct products", 1, 
                model.getSize());
        assertTrue("Ensure list contains the correct product", 
                model.contains(product2));
    }

    @Test
    public void testEditButton() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.list("lstDisplay").selectItem("A");
        fixture.button("btnEdit").click();
        DialogFixture editDialog = fixture.dialog("entryDialog");

        editDialog.textBox("txtID").requireText("1");
    }

    @Test
    public void testSearchIDButton() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.textBox("txtSearchID").enterText("1");
        fixture.button("btnSearchID").click();

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").
                target().getModel();

        assertTrue("Ensure list contains the correct product", 
                model.contains(product1));
        assertEquals("Ensure list only contains the correct products", 1, 
                model.getSize());
        
        fixture.textBox("txtSearchID").enterText("3");
        fixture.button("btnSearchID").click();
        
        model = (SimpleListModel) fixture.list("lstDisplay").
                target().getModel();
        
        assertEquals("Ensure list contains the correct product", "There is no "
                + "product with that ID.", model.getElementAt(0).toString());
        assertEquals("Ensure list only contains the correct products", 1, 
                model.getSize());
    }

    @Test
    public void testCategoryFilter() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.comboBox("boxCategoryFilter").selectItem("b");

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").
                target().getModel();

        assertTrue("Ensure list contains the correct product", 
                model.contains(product2));
        assertEquals("Ensure list only contains the correct products", 1, 
                model.getSize());
    }
    
    @After
    public void tearDown() {
        fixture.cleanUp();
    }
}
