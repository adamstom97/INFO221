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
import java.util.Set;
import java.util.SortedMap;
import java.util.TreeMap;
import java.util.TreeSet;
import org.assertj.swing.core.BasicRobot;
import org.assertj.swing.core.Robot;
import static org.assertj.swing.core.matcher.DialogMatcher.withTitle;
import static org.assertj.swing.core.matcher.JButtonMatcher.withText;
import org.assertj.swing.fixture.DialogFixture;
import org.junit.After;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

/**
 *
 * @author Adams
 */
public class displayTest {

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

        SortedMap<String, Product> productsByID = new TreeMap<>();
        productsByID.put("1", product1);

        SortedMap<String, Set<Product>> productsByCategory = new TreeMap<>();
        Set<Product> productsByCategoryInner = new TreeSet<>();
        productsByCategoryInner.add(product2);
        productsByCategory.put("b", productsByCategoryInner);

        list = mock(Dao.class);

        when(list.getProductList()).thenReturn(products);
        when(list.getCategoryList()).thenReturn(categories);
        when(list.getProductByID("1")).thenReturn(productsByID.get("1"));
        when(list.getProductsByCategory("b")).thenReturn(productsByCategory.get("b"));

        Mockito.doAnswer(new Answer<Void>() {
            @Override
            public Void answer(InvocationOnMock invocation) throws Throwable {
                products.remove(product1);
                return null;
            }
        }).when(list).deleteProduct(product1);
    }

    @After
    public void tearDown() {
        fixture.cleanUp();
    }

    @Test
    public void testDisplay() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").target().getModel();

        assertTrue("Ensure list contains the correct product", model.contains(product1));
        assertTrue("Ensure list contains the correct product", model.contains(product2));
        assertEquals("Ensure list only contains the correct products", 2, model.getSize());
    }

    @Test
    public void testDeleteButton() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.list("lstDisplay").selectItem("A");
        fixture.button("btnDelete").click();

        DialogFixture confirmDialog = fixture.dialog(withTitle("Select an Option").andShowing()).requireVisible();
        confirmDialog.button(withText("Yes")).click();

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").target().getModel();

        assertEquals("Ensure list only contains the correct products", 1, model.getSize());
        assertTrue("Ensure list contains the correct product", model.contains(product2));
    }

    @Test
    public void testEditButton() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.list("lstDisplay").selectItem("A");
        fixture.button("btnEdit").click();

        DialogFixture editDialog = fixture.dialog("entryDialog");

        assertEquals("Ensure dialog contains the correct product", "1", editDialog.textBox("txtID").text());
    }

    @Test
    public void testSearchIDButton() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.textBox("txtSearchID").enterText("1");
        fixture.button("btnSearchID").click();

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").target().getModel();

        assertTrue("Ensure list contains the correct product", model.contains(product1));
        assertEquals("Ensure list only contains the correct products", 1, model.getSize());
    }

    @Test
    public void testCategoryFilter() {
        ProductDisplay dialog = new ProductDisplay(null, true, list);

        fixture = new DialogFixture(robot, dialog);
        fixture.show().requireVisible();

        fixture.comboBox("boxCategoryFilter").selectItem("b");

        SimpleListModel model = (SimpleListModel) fixture.list("lstDisplay").target().getModel();

        assertTrue("Ensure list contains the correct product", model.contains(product2));
        assertEquals("Ensure list only contains the correct products", 1, model.getSize());
    }
}
