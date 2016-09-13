/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gui;

import domain.Product;
import java.util.Collection;
import java.util.TreeSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;
import static org.mockito.Mockito.when;
import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import dao.ProductDAO;

/**
 * A class for testing the project's ProductEntry gui.
 * 
 * @author adamstom97
 * @version 2.0
 */
public class TestEntry {
    private ProductDAO list;
    private DialogFixture fixture;
    private Robot robot;

    @Before
    public void setUp() {
        robot = BasicRobot.robotWithNewAwtHierarchy();
        robot.settings().delayBetweenEvents(75);

        Collection<String> categories = new TreeSet<>();
        categories.add("a");
        categories.add("b");

        list = mock(ProductDAO.class);
        when(list.getCategoryList()).thenReturn(categories);
    }

    @Test
    public void testSave() {
        ProductEntry dialog = new ProductEntry(null, true, list);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.textBox("txtID").enterText("1");
        fixture.textBox("txtName").enterText("Aa");
        fixture.textBox("txtDescription").enterText("Aa");
        fixture.comboBox("boxCategory").selectItem("a");
        fixture.textBox("txtPrice").enterText("1.00");
        fixture.textBox("txtQuantity").enterText("1");
        fixture.button("btnSave").click();

        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(
                Product.class);
        verify(list).addProduct(argument.capture());
        Product saved = argument.getValue();

        assertEquals("Ensure the ID was saved", new Integer(1), 
                saved.getProductID());
        assertEquals("Ensure the name was saved", "Aa", saved.getName());
        assertEquals("Ensure the Description was saved", "Aa", 
                saved.getDescription());
        assertEquals("Ensure the Category was saved", "a", saved.getCategory());
        assertEquals("Ensure the Price was saved", new Double(1.00), 
                saved.getPrice());
        assertEquals("Ensure the Quantity was saved", new Integer(1), 
                saved.getQuantity());
    }

    @Test
    public void testEdit() {
        Product p = new Product(2, "Bb", "Bb", "b", 1.00, 1);
        ProductEntry dialog = new ProductEntry(null, true, list, p);
        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.textBox("txtID").requireText("2");
        fixture.textBox("txtName").requireText("Bb");
        fixture.textBox("txtDescription").requireText("Bb");
        fixture.comboBox("boxCategory").requireSelection("b");
        fixture.textBox("txtPrice").requireText("1.00");
        fixture.textBox("txtQuantity").requireText("1");
        
        fixture.textBox("txtName").selectAll().deleteText().enterText("Cc");
        fixture.comboBox("boxCategory").selectItem("a");
        fixture.button("btnSave").click();

        ArgumentCaptor<Product> argument = ArgumentCaptor.forClass(
                Product.class);
        verify(list).addProduct(argument.capture());
        Product edited = argument.getValue();

        assertEquals("Ensure the name was changed", "Cc", edited.getName());
        assertEquals("Ensure the category was changed", "a", 
                edited.getCategory());
    }
    
    @After
    public void tearDown() {
        fixture.cleanUp();
    }
}
