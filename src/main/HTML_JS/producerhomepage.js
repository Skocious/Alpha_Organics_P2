const itemId = document.getElementById("item_id_field");
const itemName = document.getElementById("item_field");
const itemDescription = document.getElementById("item_description_field");
const itemPrice = document.getElementById("item_price_field");
const userName = window.localStorage.getItem("Username");



function saleTable(returnedInfo){
    itemsTableBody.innerHTML = "";
    let requestId = 1
    for (let obj in returnedInfo) {
        //console.log(returnedInfo[obj])
        const newRow = document.createElement("tr");
        itemsTableBody.appendChild(newRow);
        const item_id = returnedInfo[obj].item_id;
        const login_name = returnedInfo[obj].login_name;
        const item_name = returnedInfo[obj].item_name;
        const item_description = returnedInfo[obj].item_description;
        const price = returnedInfo[obj].price;
        returnedInfoList = [item_id, login_name, item_name, item_description, price];
        for (let elements of returnedInfoList) {
            const tData = document.createElement("td");
            tData.textContent = elements
            newRow.appendChild(tData)
            tData.id = requestId
            requestId++
        }
    }
}

async function requestItems() {

    let getURL = "http://8080/get_all_items_by_login_name/"

    let response = await fetch(getURL + login_name, { method: "GET" })

    if (response.status === 200) {
        let returnedInfo = await response.json();
       // console.log(returnedInfo);
        saleTable(returnedInfo);
 }  else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);
    }
}


async function createItem(){

    let newCreateRequest = {
        "item_id": itemId.value,
        "login_name": userName.value,
        "item_name": itemName.value,
        "item_description":itemDescription.value,
        "price": price.value
    }
    console.log(newPurchaseRequest)
    let newRequest = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(newCreateRequest)
    }
    let response = await fetch("http://8080/create_item_request", newRequest)
    if (response.status === 200) {
        alert("You have successfully created an" + {itemName} + "for sale!")
        totalItemsSale();
        requestItems();
  } else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);   
    }
}

async function deleteItem(){
    let requestCancelID = document.getElementById("delete-Item-Request-Field")
    let cresponse = await fetch("8080/delete_item_request/" + requestCancelID.value)
    if (cresponse.status === 200) {
        alert("You have successfully deleted" + {itemName})
        totalItemsSale();
        requestItems();
  } else if (cresponse.status === 400) {
        let responseBody = await cresponse.json()
        alert(responseBody.message);  
    }
}

async function totalItemsSale() {
    let totalItemsTable = document.getElementById("all_items")
    let bresponse = await fetch("http://8080/get_all_items_by_login_name/" + login_name)
    if (bresponse.status === 200) {
       // console.log(bresponse)
       const value = await bresponse.json()
       // console.log(value)
       totalItemsTable.textContent = value
  } else if (bresponse.status === 400) {
        let responseBody = await bresponse.json()
        alert(responseBody.message);
    }
}

function clearStore_return_to_login() {
    window.localStorage.clear();
    window.location.href = "landingPage.html";
}

requestItems();

