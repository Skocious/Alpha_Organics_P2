const itemId = document.getElementById("item_id_field");
const itemName = document.getElementById("item_field");
const itemDescription = document.getElementById("item_description_field");
const itemPrice = document.getElementById("item_price_field");
const userName = window.localStorage.getItem("login_name");
const tId = window.localStorage.getItem("transaction_id")


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

    let getURL = "http://localhost:8080/items/"

    // let response = await fetch(getURL + login_name, { method: "GET" })
    let response = await fetch(getURL, { method: "GET" })

    if (response.status === 200) {
        let returnedInfo = await response.json();
       // console.log(returnedInfo);
        saleTable(returnedInfo);
    }else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);
    }

async function buyItem(){

    let newTransactionRequest = {
        "transaction_id": tId.value,
        "login_name": userName.value,
        "transaction_amount": tItemAmount.value,
        "item_id": i
    }
    console.log(newPurchaseRequest)
    let newRequest = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(newCreateRequest)
    }
    let response = await fetch("http://localhost:8080/transactions", newRequest)
    if (response.status === 200) {
        alert("Thank you for your purchase, your items are ready for pickup!")
        totalItemsSale();
        requestItems();
    }else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);   
    }
}
async function totalItemsSale() {
    let totalItemsTable = document.getElementById("all_items")
    let bresponse = await fetch("http://localhost:8080//transactions/" + login_name)
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


}

requestItems();