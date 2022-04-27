const item_id = document.getElementById("item_id_field");
const item_name = document.getElementById("item_field");
const item_description = document.getElementById("item_description_field");
const item_price = document.getElementById("item_price_field");
//const userName = window.localStorage.getItem("login_name");
const itemsTableBody = document.getElementById("items_body");
const deleteid = document.getElementById("delete-Item-Request-Field");
const login_name = window.localStorage.getItem("login_name");

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

async function requestItems() {

    let getURL = "http://localhost:8080/items/"
    let response = await fetch(getURL, { method: "GET" })
    if (response.status === 200) {
        let returnedInfo = await response.json();
        //console.log(returnedInfo);
        saleTable(returnedInfo);
 }  else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);
    }
}


async function createItem(){

    let newCreateRequest = {
        "itemId": 0,
        "Username": userName.value,
        "itemName": item_name.value,
        "itemDescription":item_description.value,
        "price": item_price.value
    }
    //console.log(newPurchaseRequest)
    let newRequest = {
        method: "POST",
        headers: {"Content-Type": "application/json"},
        body: JSON.stringify(newCreateRequest)
    }
    let response = await fetch("http://localhost:8080/items" + newRequest)
    if (response.status === 200) {
        //alert("You have successfully created an" + {itemName} + "for sale!")
        totalItemsSale();
        requestItems();
  } else if (response.status === 400) {
        let responseBody = await response.json()
        alert(responseBody.message);   
    }
}

async function deleteItem(){
    // let deleteRequest = {
    //     "item_id": deleteid.value
    // }
    let newDelete = {
        method: "DELETE",
        headers: {"Content-Type": "application/json"}
        //body: JSON.stringify(deleteRequest)
    }
    //let requestCancelID = document.getElementById("delete-Item-Request-Field")
    let cresponse = await fetch(`http://localhost:8080/items/${deleteid.value}`, newDelete)
    //console.log(requestCancelID);
    if (cresponse.status === 200) {
        alert("You have successfully deleted item")
        //totalItemsSale();
        requestItems();
  } else if (cresponse.status === 400) {
        let responseBody = await cresponse.json()
        alert(responseBody.message);  
    }
}

// async function totalItemsSale() {
//     let totalItemsTable = document.getElementById("all_items")
//     let bresponse = await fetch("http://localhost:8080/get_all_items_by_login_name/" + login_name)
//     if (bresponse.status === 200) {
//        // console.log(bresponse)
//        const value = await bresponse.json()
//        // console.log(value)
//        totalItemsTable.textContent = value
//   } else if (bresponse.status === 400) {
//         let responseBody = await bresponse.json()
//         alert(responseBody.message);
//     }
// }

function clearStore_return_to_login() {
    window.localStorage.clear();
    window.location.href = "landingPage.html";
}

requestItems();

