package src.Samantha.Dal;

interface DalInterface {

    int LogIn();
    String CreateItem();
    int FindItemById();
    int FindItemByProducerId();
    int UpdateItemByItemId();
    int DeleteItemByItemId();
    int LogOut();


}
public class dalInterface {

    public static void main(String[] args) {

    }

    @Override
    public int LogIn() {
        return 0;
    }

    @Override
    public String CreateItem() {
        return null;
    }

    @Override
    public int FindItemById() {
        return 0;
    }

    @Override
    public int FindItemByProducerId() {
        return 0;
    }

    @Override
    public int UpdateItemByItemId() {
        return 0;
    }

    @Override
    public int DeleteItemByItemId() {
        return 0;
    }

    @Override
    public int LogOut() {
        return 0;
    }


    //CreateItem
    //CreateItemSuccess
    //
    //FindItemByItemId
    //FindItemByItemIdSuccess
    //
    //FindItemsbyProducerId
    //FindItemByProducerIdSuccess
    //
    //UpdateItemByItemId
    //UpdateItemSuccess
    //
    //DeleteItembyItemId
    //DeleteItemSuccess
    //
    //UserLogin
    //UserLoginSuccess
    //UserLogout
    //UserLogoutSuccess
}
