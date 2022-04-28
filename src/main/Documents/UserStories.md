#User Stories
## Customer
1. As a customer I want to add products to my cart so that I can purchase products.
   (JS)(selectItemsByItemId)(Items)
2. As a customer I want to remove products from my cart so that I don't buy products I do not need.
   (JS)
3. As a customer I want to view products so that I can add products to my cart.
   (JS)(selectAllItemsById)(Items)
4. As a customer i want to buy the items in my cart
   (createTransaction)(Transaction)
5. As a customer I want to see the total amount of my past purchases
   (getAllTransactionsByCustomerId)(Transaction)

##Producer
1. As a producer I want to add products so that customers can purchase them.
   (createItemsByItemsId)(Items)
2. As a producer I want to remove products so that customers do not attempt to purchase items that are out of stock.
   (deleteItemsByItemsId)(Items)
3. As a producer I want to change prices of products so that customers pay the market value for products.
   (updateItemsByItemsId)(Items)
4. As a producer I want to see all of my products listed.
   (getAllItemsByProducerId)(Items)
    5. As a producer I want to change the description of products so that customers    pay the market value for products.
       (updateItemsByItemsId)(Items)
