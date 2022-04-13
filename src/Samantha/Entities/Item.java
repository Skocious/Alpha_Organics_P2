package src.Samantha.Entities;

public class Item {
        int ProducerId;
        int ItemId;
        int ItemAmount;
        float ItemPrice;
        String ItemDescription;

        public Item(int ProducerId, int ItemId, int ItemAmount, float ItemPrice, String ItemDescription) {
            this.ProducerId = ProducerId;
            this.ItemId = ItemId;
            this.ItemAmount = ItemAmount;
            this.ItemPrice = ItemPrice;
            this.ItemDescription = ItemDescription;
        }
}
