# Test Strategy

## Best Practices
Use CRUD
Start off with interface
Use proper naming conventions (avoid abbreviations)
Push to Git (ALOT!)
In your commit, leave proper comments
Create individual branches/ avoid pushing to main as much as possible

## Bug Report
When an error occurs,post or update bug report prior to fixing
When fixing a bug, update bug report with new status
Raise as an issue on github

## API Endpoints
JSON formatting
User restful Practices
Test with Postman to ensure all routes can handle errors
Use nesting for postman ( http://localhost:5000/seller, http://localhost:5000/seller/remove)

## Roles and Responsibilities
Daniel: API, Documentation, Postman
Julio: DAL Tests, DB
Samantha: Interfaces, Entities, DB, HTML
Vathsala: SER Tests, SER Layer
William (Project Lead): Documentation, E2ETests



# Test Plan


## Languages used
Java
PostgreSQL
HTML
CSS
JS



## IDE/Other
IntelliJ
DBeaver
Postman
GitHub
AWS Database
EC2 system
VSCode
Javalin
Selenium
chromerdriver.exe

## Scope
### Entities:
Login( int LoginId; String Username; String Password);
Producer( int ProducerId; String ProducerName; int LoginId);
Customer( int CustomerId; String CustomerName; int LoginId);
Item(int ProducerId; int ItemId; int ItemAmount; float ItemPrice; String ItemDescription);

### DataAccessLayer:
CreateItem
CreateItemSuccess

FindItemByItemId
FindItemByItemIdSuccess

FindItemsbyProducerId
FindItemByProducerIdSuccess

UpdateItemByItemId
UpdateItemSuccess

DeleteItembyItemId
DeleteItemSuccess

UserLogin
UserLoginSuccess
UserLogout
UserLogoutSuccess

### ServiceAccessLayer
Login
UsernameInvalidDatatype
UsernameLength
PasswordInvalidDatatype
PasswordLength

ItemCreation
ItemAmountInvalidDatatype
ItemAmount0
ItemPriceInvalidDatatype
ItemPriceLength <9999
ItemPrice0
ItemDescriptionInvalidLength
FindItem
ItemIdWrong
ItemId0
ItemIdInvalidDatatype
ItemPriceInvalidDatatype
ItemPrice0
UpdateItem
ItemAmountInvalidDatatype
ItemPriceInvalidDatatype
ItemDescriptionLength
DeleteItem
ItemIdInvalidDatatype

API Layer
connection_successful
no_connection
create_item
create_item_success
create_item_amount_invalid_datatype
create_item_price_invalid_datatype
create_item_description_length
find_item
find_item_bad_id
find_item_id_invalid_datatype
find_item_price_invalid_datatype
Update_item
update_item_amout_invalid_datatype
update_item_price_invalid_datatype
update_item_price_length
update_item_description_length
delete_item
delete_item_invalid_id
user_login
login_success
login_bad_username
login_username_invalid_datatype
login_bad_password
login_password_invalid_datatype
user_logout
logout_success
- HTML/JavaScript
  ???? <- work in progress




### DeadLine
Documentation:
Test Strategy & Plan : April 12, 2022
Bug Report: April 12, 2022
User Stories April 12, 2022
RTM -> Reported Weekly
Standup : Daily -> Reported Weekly
Postman Results -> Reported Weekly
Cucumber Results -> Reported Weekly
Entities: April 12, 2022
Login
Producer
Customer
Item
Interface April 13, 2022
ServiceAccess
DataAccess
Unit Tests Start April 13,2022
See Above for Tests
Implementation
ServiceAccess
DataAccess
API
connection
main
HTML / JS

Final Product Due: April 29, 2022
Daniel, Julio, Samantha, Vathsala, William
 
 


 

