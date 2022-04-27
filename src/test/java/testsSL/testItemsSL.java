package testsSL;

import DataAccessLayer.ItemsImp;
import ServiceAccessLayer.ItemsSImp;

import customExceptions.InvalidId;
import entities.Items;

import org.mockito.Mockito;
import org.mockito.internal.verification.VerificationModeFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;


public class testItemsSL {
    public static ItemsImp itemsDAO = new ItemsImp();
    public static ItemsSImp itemsSO = new ItemsSImp(itemsDAO);
    public static List<Items> listMock = new ArrayList<Items>();
    public static Items testMock = new Items(0, "customer1", "eggs", "free-range", 1.99f);

    @BeforeClass
    public void setup() {
        itemsDAO = Mockito.mock(ItemsImp.class);
        itemsSO = new ItemsSImp(itemsDAO);
    }


    @Test
    public void serviceCreateItemSuccess() {

        Mockito.doReturn(new Items(1, "customer1", "eggs", "free-range", 1.99f)).when(itemsDAO).createItems(testMock);
        Items result = itemsSO.serviceCreateItems(testMock);
        Assert.assertEquals(result.getItemId(), 1);
    }

    @Test
    public void serviceCheckItemsCalledOnce() {
        Mockito.doReturn(new Items(0, "customer1", "eggs", "free-range", 1.99f)).when(itemsDAO).createItems(testMock);
        itemsSO.serviceCreateItems(testMock);
        Mockito.verify(itemsDAO, VerificationModeFactory.times(1)).createItems(testMock);
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceInvalidItemName() {
        Items items = new Items(4, "customer1", "goatsgoatsgoatsgoatsgoats", "browngoat", 99.00F);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotSame(result.getItemName(), "goat");
    }

    @Test//(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceInvalidItemDescription() {
        Items items = new Items(1, "customer1", "goats", "goatsgoatsgoatsgoatsgoatsgoatsgogoatsgoatsgoatsgoatsgoatsatsgoatsgoatsgoats", 99);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotEquals(result, items);
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceInvalidPriceTooHigh() {
        Items items = new Items(4, "customer1", "goat", "browngoat", 10000);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotSame(result.getPrice(), "99");
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Information entered is not correct, please try again.")
    public void serviceInvalidPriceLow() {
        Items items = new Items(4, "customer1", "goat", "browngoat", 0);
        Items result = itemsSO.serviceCreateItems(items);
        Assert.assertNotSame(result.getPrice(), "99");
    }

    @Test
    public void serviceSelectItemByItemIdSuccess(){
        Mockito.doReturn(testMock).when(itemsDAO).selectItemsById(2);
        Items test = itemsSO.serviceSelectItemsById(2);
        Assert.assertEquals(test, testMock);
    }

    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Please enter a valid itemId")
    public void serviceSelectItemByItemIdFailure(){
        itemsSO.serviceSelectItemsById(-100);
        Assert.fail();
    }

//    @Test
//    public void serviceSelectAllItemsSuccess(){
//        Mockito.doReturn(listMock).when(itemsDAO).selectAllItems();
//        List<Items> resultList = itemsSO.serviceSelectAllItems();
//        Assert.assertTrue(resultList.size() >= 1); //was assertTrue this needs to be changed again
//    }
//    @Test
//    public void serviceSelectAllItemsFailure(){
//        Mockito.doReturn(listMock).when(itemsDAO).selectAllItems();
//        List<Items> resultList = itemsSO.serviceSelectAllItems();
//        Assert.assertFalse(resultList.size() >= 1);
//    }
    @Test
    public void serviceUpdateItemsByItemIdSuccess(){
        Mockito.doReturn(new Items(0, "customer2", "Grapes", "red seedless grapes", 2)).when(itemsDAO).updateItemsById(testMock);
        itemsSO.serviceUpdateItemsById(testMock);
        Mockito.verify(itemsDAO, VerificationModeFactory.times(1)).updateItemsById(testMock);
    }
    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Item Name too long")
    public void serviceUpdateInvalidItemName() {
        Items items = new Items(4, "customer1", "goatsgoatsgoatsgoatsgoats", "browngoat", 99.00F);
        Items result = itemsSO.serviceUpdateItemsById(items);
        Assert.assertNotSame(result.getItemName(), "goat");
    }

    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Item description too long")
    public void serviceUpdateInvalidItemDescription() {
        Items items = new Items(1, "customer1", "goats", "goatsgoatsgoatsgoatsgoatsgoatsgogoatsgoatsgoatsgoatsgoatsatsgoatsgoatsgoatsgoatsatsgoatsgoatsgoatsgoatsgoatsgoats", 99);
        Items result = itemsSO.serviceUpdateItemsById(items);
        Assert.assertNotEquals(result, items);
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "Item price is too high")
    public void serviceUpdateInvalidPriceHigh() {
        Items items = new Items(4, "customer1", "goat", "browngoat", 10000);
        Items result = itemsSO.serviceUpdateItemsById(items);
        Assert.assertNotSame(result.getPrice(), "99");
    }

    @Test (expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "we dont offer free")
    public void serviceUpdateInvalidPriceLow() {
        Items items = new Items(4, "customer1", "goat", "browngoat", 0);
        Items result = itemsSO.serviceUpdateItemsById(items);
        Assert.assertNotSame(result.getPrice(), "99");
    }

//Assert.assertTrue(result.getPrice() == items.getPrice());







    @Test
    public void serviceDeleteItemSuccess() {

        Mockito.doReturn(1).when(itemsDAO).deleteItemsById(1);
        int result = itemsSO.serviceDeleteItemsById(1);
        Assert.assertTrue(result != 0);
    }


//    @Test void serviceDeleteItemsSuccessCalledOnce() {
//        Mockito.doReturn(1).when(itemsDAO).deleteItemsById(1);
//        itemsSO.serviceDeleteItemsById(1);
//        Mockito.verify(itemsDAO, VerificationModeFactory.times(1)).deleteItemsById(1);
//
//    }
    @Test(expectedExceptions = InvalidId.class, expectedExceptionsMessageRegExp = "No item for the itemid")
    public void serviceDeleteItemsFailure(){
        itemsSO.serviceDeleteItemsById(-100);
    }

}