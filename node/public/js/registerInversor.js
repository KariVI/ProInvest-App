




function previousPage(){
    let url = "http://localhost:5000/principal";
    window.open(url);
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


export class Validation {
    
    constructor() {}
    
     isNotEmpty(nomForm){
        return nomForm == null || nomForm == "" || nomForm.length == 0  || /^\s+$/.test(nomForm) || !isNaN(nomForm);
    }
    
     isAlphabeticInput(value){
        let textFormat= /^[A-Z]+$/i;
        return textFormat.test(password.value);
    }
    
     isAlphanumericInput(value){
        let textFormat= /^[a-z0-9]+$/i;
        return textFormat.test(password.value);
    }
    
    
     existsDate(date){
        let datef = date.split("/");
        let day = datef[0];
        let month = datef[1];
        let year = datef[2];
        let dateFinal= new Date(year,month,'0');
        return day-0 <= dateFinal.getDate()-0;
    }
    
    
     validaDate(date){
        let x=new Date();
        let fecha = date.split("/");
        x.setFullYear(fecha[2],fecha[1]-1,fecha[0]);
        let today = new Date();
        return x < today;
    }
    
     isSelected(select){
        return !(select == null || select == 0);
    }



}