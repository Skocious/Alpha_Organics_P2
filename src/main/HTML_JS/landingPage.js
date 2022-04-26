const id_name = document.getElementById("username-field");
const password = document.getElementById("password-field");



    async function customerLoginFunction(){

        console.log(id_name.value)
        console.log(password.value)
        
        let loginInfoJSON = {
            "Username": id_name.value,
            "pw": password.value
        }

        let loginCredentials = {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(loginInfoJSON)
        }
        const httpResponse = await fetch("http://localhost:8080/login", loginCredentials)
        if (httpResponse.status == 200){
            const httpResponseBody = await httpResponse.json()
            window.localStorage.setItem('login_name', httpResponseBody['login_name'])
            window.location.href = "customerHomepage.html"    
        } else {
            alert("Incorrect Login Info, Please Try Again")
        }
    }

    async function producerLoginFunction(){

        console.log(id_name.value)
        console.log(password.value)

        let loginInfoJSON = {
            "Username": id_name.value,
            "pw": password.value
        }

        let loginCredentials = {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(loginInfoJSON)
        }
        const httpResponse = await fetch("http://localhost:8080/login", loginCredentials)
        if (httpResponse.status == 200){
            const httpResponseBody = await httpResponse.json()
            window.localStorage.setItem('login_name', httpResponseBody['login_name'])
            window.location.href = "producerHomepage.html"    
        } else {
            alert("Incorrect Login Info, Please Try Again")
        }
    }