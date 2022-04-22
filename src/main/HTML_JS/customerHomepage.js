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

    let getURL = "http://127.0.0.1:5000/get_all_items_by_login_name/"

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
