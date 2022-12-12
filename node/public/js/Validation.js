

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