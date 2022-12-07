

 export  class Validation {

    
     static isEmpty(value){
        if(value.isEmpty() || value.trim()==""){
            return true;
        }
        return false;
    }

     static validateEmail(email){
        var mailformat = /^w+([.-]?w+)*@w+([.-]?w+)*(.w{2,3})+$/;
        if(email.match(mailformat)){
            return true;
        }
        return false;
    }



}