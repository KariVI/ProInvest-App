
import Validation from "./objects/Validation"; // Ruta correcta al archivo Js

const validation= new Validation();


function openWindow() {
    let configuration_window = "menubar=yes,location=yes,resizable=yes,scrollbars=yes,status=yes";
     window.open("../html/registerDirection.html", "Pagina_CNN", configuration_window);
  }


function validateDataAlphabetic(){
    let txName = document.getElementById("txName").value;
    let txLastMotherName = document.getElementById(" txLastMotherName").value;
    let txLastFatherName = document.getElementById("txLastFatherName").value;
    let txProfession = document.getElementById("txWork").value;
    let inputs=[txName,txLastMotherName,txLastFatherName,txProfession];
    let name = document.getElementById("name");
    let lastFatherName = document.getElementById("lastFatherName");
    let lastMotherName=document.getElementById("lastMotherName");
    let work = document.getElementById("work");
    let messages= [name,lastMotherName,lastFatherName,work];
    let value = true;
    for (let i=0; i<4; i++){
        if(this.validation.isAlphabeticInput(inputs[i]) && validation.isNotEmpty(inputs[i])){
            messages[i].style.visibility="hidden";
        }else{
            messages[i].style.visibility="visible"; 
            value=false;
        }
    }

    return value;

}

function validateAlphanumeric(){
    let txRFC = document.getElementById("txRFC").value;
    let rfc = document.getElementById("rfc");
    if(this.validation.isAlphanumericInput(txRFC) && this.validation.isNotEmpty(txRFC)){
        rfc.style.visibility="hidden";
        return true;
    }
    rfc.style.visibility="visible";
    return false;

}

function validateDate(){
    let txDate = document.getElementById("txDate").value;
    let date = document.getElementById("date");
    if(this.validation.existsDate(txDate)){
        if(this.validation.validaDate(txDate) ){
        date.style.visibility="hidden";
        return true;
        }
    }
    date.style.visibility="visible";
    return false;
}


function validateGradeAcademic(){
    let cbGrade= document.getElementById("cbGrade").selectedIndex;
    let grade = document.getElementById("grade");
    if(this.validation.isSelected(cbGrade)){
        grade.style.visibility="hidden";
        return true;
    }
    grade.style.visibility="visible";
    return false;
}
function nextSection(){}