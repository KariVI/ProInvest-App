import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';

@Component({
  selector: 'app-register-inversor',
  templateUrl: './register-inversor.component.html',
  styleUrls: ['./register-inversor.component.css']
})
export class RegisterInversorComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
  showProfile: boolean = true;
  showDirection: boolean = false;
  showInfoFinance: boolean = false;
  contSections =0;
  sections: Array<boolean> = [this.showProfile, this.showDirection, this.showInfoFinance];


  previousSection(){
    if(this.contSections=0){
      console.log("pendiente");
    }else{
      let aux= ! this.sections[this.contSections];
      this.sections[this.contSections]= aux;
      this.contSections= this.contSections- 1;
      aux = ! this.sections[this.contSections];
      this.sections[this.contSections]= aux;
      
    }
  }
  ngOnInit(): void {
  }

}
