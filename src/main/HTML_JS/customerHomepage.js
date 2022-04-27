const item_id = document.getElementById("item_id_field");
const item_name = document.getElementById("item_field");
const item_description = document.getElementById("item_description_field");
const transaction_id = window.localStorage.getItem("transaction_id");
const login_name = window.localStorage.getItem("login_name");
const itemsTableBody = document.getElementById("items_body");
const transactionTableBody = document.getElementById("producer_body");


function saleTable(returnedInfo){
    itemsTableBody.innerHTML = "";
    let requestId = 1
    for (let obj in returnedInfo) {
        //console.log(returnedInfo[obj])
        const newRow = document.createElement("tr");
        itemsTableBody.appendChild(newRow);
        const itemId = returnedInfo[obj].itemId;
        const Username = returnedInfo[obj].Username;
        const itemName = returnedInfo[obj].itemName;
        const itemDescription = returnedInfo[obj].itemDescription;
        const price = returnedInfo[obj].price;
        let returnedInfoList = [itemId, Username, itemName, itemDescription, price];
        for (let elements of returnedInfoList) {
            const tData = document.createElement("td");
            tData.textContent = elements
            newRow.appendChild(tData)
            tData.id = requestId
            requestId++
        }
    }
}

function transactionTable(values){
    transactionTableBody.innerHTML = "";
    let requestId = 1
    for (let obj of values) {
        console.log(obj)
        const newtRow = document.createElement("tr");
        transactionTableBody.appendChild(newtRow);
        const transactionId = obj.transactionId;
        const Username = obj.Username;
        const transactionAmount = obj.transactionAmount;
        const itemId = obj.itemId;
        let returnedTInfoList = [transactionId, Username, transactionAmount, itemId ];
        for (let elements of returnedTInfoList) {
            const tData = document.createElement("td");
            tData.textContent = elements
            newtRow.appendChild(tData)
            tData.id = requestId
            requestId++
        }
    }
}




async function requestItems() {

    let getURL = "http://localhost:8080/items/"
    let response = await fetch(getURL, { method: "GET" })
    if (response.status === 200) {
        let returnedInfo = await response.json();
        //console.log(returnedInfo);
        saleTable(returnedInfo);
    }else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);
    }
}

async function totalItemsSale() {
    let bresponse = await fetch(`http://localhost:8080/transactions/${localStorage.getItem("login_name")}`)
    if (bresponse.status === 200) {
        
        let values = await bresponse.json()
        console.log(values);
       // totalItemsTable.textContent = value 
        transactionTable(values);    
  } else if (bresponse.status === 400) {
        let values = await bresponse.json()
        alert(values.message);
    }
}



async function buyItem(){
    let newTransactionRequest = {
        "transactionId": 2,
        "Username": login_name,
        "transactionAmount": 10,
        "itemId": 1
    }
    console.log(newTransactionRequest)
    let newRequest = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(newTransactionRequest)
    }
    let response = await fetch("http://localhost:8080/transactions", newRequest)
    if (response.status === 200) {
        alert("Thank you for your purchase, your items are ready for pickup!")
        //totalItemsSale();
        //requestItems();
    }else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);   
    }
}



function clearStore_return_to_login() {
    window.localStorage.clear();
    window.location.href = "landingPage.html";
}
totalItemsSale();
requestItems();