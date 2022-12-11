
function validateForm(){
    return validateEmail();
}

function enviarFormulario(){    
    let mpasswordConfirm = document.getElementById("passwordconfirm");
    if(validateEmail() && validatePassword()){
        if(!validatePasswords()){
            mpasswordConfirm.textContent= "Las contraseñas no son iguales";

        }else{
            mpasswordConfirm.textContent="";
            alert("Formulario enviado con éxito");
        }
    }

}




function validateEmail(){
    let memail = document.getElementById("memail");

    let email = document.getElementById("txEmail");
    if (/^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(email.value))
    {
        memail.textContent="";
      return (true)
    }
    memail="La estructura de un email es ejemplo@dominio.com "
    return (false)
}


function validatePassword(){
    let mpassword = document.getElementById("password");
    let password = document.getElementById("txPassword");
    let passwordFormat = /(?=.*\d)(?=.*[a-z])(?=.*[A-Z]).{8,}/;
    if (passwordFormat.test(password.value))
    {
        mpassword.textContent="";
      return (true)
    }
    mpassword.textContent="La contraseña debe poseer una letra mayuscula, minúsculan número y un mínimo de 8 letras";
    return (false)
}

function validatePasswords(){
    let password = document.getElementById("txPassword");
    let passwordConfirm = document.getElementById("txPasswordConfirm");
    return password.value == passwordConfirm.value;
}