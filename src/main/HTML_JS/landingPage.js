const id_name = document.getElementById("username-field");
const password = document.getElementById("password-field");
const pid_name = document.getElementById("pusername-field");
const ppassword = document.getElementById("ppassword-field");



    async function customerLoginFunction(){

        console.log(id_name.value)
        console.log(password.value)
        
        let loginInfoJSON = {
            "Username": id_name.value,
            "Password": password.value
        }

        let loginCredentials = {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(loginInfoJSON)
        }
        const httpResponse = await fetch("http://localhost:8080/username", loginCredentials)
        if (httpResponse.status == 201){
            //const httpResponseBody = await httpResponse.json()
            //window.localStorage.setItem('Username', httpResponseBody['login_name'])
            window.location.href = "customerHomepage.html"    
        } else {
            alert("Incorrect Login Info, Please Try Again")
        }
    }

    async function producerLoginFunction(){

        console.log(pid_name.value)
        console.log(ppassword.value)
        
        let loginInfoJSON = {
            "Username": pid_name.value,
            "Password": ppassword.value
        }

        let loginCredentials = {
            method: "POST",
            headers: {"Content-Type": "application/json" },
            body: JSON.stringify(loginInfoJSON)
        }
        const httpResponse = await fetch("http://localhost:8080/username", loginCredentials)
        if (httpResponse.status == 201){
            //const httpResponseBody = await httpResponse.json()
            //window.localStorage.setItem('Username', httpResponseBody['login_name'])
            window.location.href = "producerHomepage.html"    
        } else {
            alert("Incorrect Login Info, Please Try Again")
        }
    }
