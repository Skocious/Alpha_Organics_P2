package testsSL;

import DataAccessLayer.ItemsImp;
import ServiceAccessLayer.ItemsSImp;
import customExceptions.InvalidId;
import entities.Items;
import org.checkerframework.checker.units.qual.A;
import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;



public class testItemsSL {
    public static ItemsImp itemsDAO = new ItemsImp();
    public static ItemsSImp itemsSO = new ItemsSImp(itemsDAO);
    public static Items testMock = new Items(0, 1, "goat", "browngoat", 99);

    @BeforeClass
    public void setup() {
        itemsDAO = Mockito.mock(ItemsImp.class);
        itemsSO = new ItemsSImp(itemsDAO);
    }


    @Test
    public void createItemSuccess() {

        Mockito.doReturn(new Items(1, 1, "goat", "browngoat", 99)).when(itemsDAO).createItems(testMock);
        Items result = itemsSO.serviceCreateItems(testMock);
        Assert.assertEquals(result.getItem_id(), 1);
    }

    @Test
    public void checkItemsCalledOnce() {
        Mockito.doReturn(1).when(itemsDAO).createItems(testMock);
        itemsSO.serviceCreateItems(testMock);
        Mockito.verify(itemsDAO, VerificationModeFactory.times(1)).createItems(testMock);
    }

    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Invalid item name")
    public void invalidItemName() {
        Items items = new Items(4, 1, "goatsgoatsgoatsgoatsgoats", "browngoat", 99.00F);
        Items result = itemsSO.serviceCreateItems(items);
       // Assert.assertNotSame(result.getItem_name(), "goat");
    }

    @Test //(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Invalid item description")
    public void invalidItemDescription() {
        Items items = new Items(4, 1, "goats", "1234", 99);
        itemsSO.serviceCreateItems(items);
    }

    @Test //(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Invalid price")
    public void invalidPrice() {
        Items items = new Items(4, 1, "goat", "browngoat", -10);
        itemsSO.serviceCreateItems(items);
    }
}