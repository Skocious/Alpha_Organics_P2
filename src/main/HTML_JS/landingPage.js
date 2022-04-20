const id_name = document.getElementById("username-field");
const password = document.getElementById("password-field");



    async function customerLoginFucntion(){

        console.log(id_name.value)
        console.log(password.value)
        let loginCredentials = {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(loginInfoJSON)
        }
        const httpResponse = await fetch("http://127.0.0.1:5000/login", loginCredentials)
        if (httpResponse.status == 200){
            const httpResponseBpdy = await httpResponse.json()
            window.localStorage.setItem('login_id', httpResponseBpdy['login_id'])
            window.location.href = "customerHomepage.html"    
        } else {
            alert("Incorrect Login Info, Please Try Again")
        }
    }

    async function producerLoginFucntion(){

        console.log(id_name.value)
        console.log(password.value)
        let loginCredentials = {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(loginInfoJSON)
        }
        const httpResponse = await fetch("http://127.0.0.1:5000/login", loginCredentials)
        if (httpResponse.status == 200){
            const httpResponseBpdy = await httpResponse.json()
            window.localStorage.setItem('login_id', httpResponseBpdy['login_id'])
            window.location.href = "producerHomepage.html"    
        } else {
            alert("Incorrect Login Info, Please Try Again")
        }
    }