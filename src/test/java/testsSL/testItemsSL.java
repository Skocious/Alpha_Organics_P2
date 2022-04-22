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
    public static Items testMock = new Items(0, "customer1", "eggs", "free-range", 1.99f);

    @BeforeClass
    public void setup() {
        itemsDAO = Mockito.mock(ItemsImp.class);
        itemsSO = new ItemsSImp(itemsDAO);
    }


    @Test
    public void createItemSuccess() {

        Mockito.doReturn(new Items(1, "customer1", "eggs", "free-range", 1.99f)).when(itemsDAO).createItems(testMock);
        Items result = itemsSO.serviceCreateItems(testMock);
        Assert.assertEquals(result.getItemId(), 1);
    }

    @Test
    public void checkItemsCalledOnce() {
        Mockito.doReturn(new Items(0, "customer1", "eggs", "free-range", 1.99f)).when(itemsDAO).createItems(testMock);
        itemsSO.serviceCreateItems(testMock);
        Mockito.verify(itemsDAO, VerificationModeFactory.times(1)).createItems(testMock);
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void invalidItemName() {
        Items items = new Items(4, "customer1", "goatsgoatsgoatsgoatsgoats", "browngoat", 99.00F);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotSame(result.getItemName(), "goat");
    }

    @Test//(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void invalidItemDescription() {
        Items items = new Items(1, "customer1", "goats", "goatsgoatsgoatsgoatsgoatsgoatsgogoatsgoatsgoatsgoatsgoatsatsgoatsgoatsgoats", 99);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotEquals(result, items);
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void invalidPrice() {
        Items items = new Items(4, "customer1", "goat", "browngoat", 10000);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotSame(result.getPrice(), "99");
    }
}