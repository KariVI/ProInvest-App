import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { DirectionInversor } from '../model/Direction';
import { InfoFinancial } from '../model/InfoFinancial';
import { IDirectionInversor } from '../model/interfaces/IDirection';
import { IInfoFinancial } from '../model/interfaces/IInfoFinancial';
import { IInversor } from '../model/interfaces/IInversor';
import { Inversor } from '../model/Inversor';

@Component({
  selector: 'app-register-inversor',
  templateUrl: './register-inversor.component.html',
  styleUrls: ['./register-inversor.component.css']
})
export class RegisterInversorComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
  inversor: Inversor = new Inversor();
  direction: DirectionInversor = new DirectionInversor();
  infoFinancial: InfoFinancial = new InfoFinancial();
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

  nextSection(){
   
      let aux= ! this.sections[this.contSections];
      this.sections[this.contSections]= aux;
      this.contSections= this.contSections + 1;
      aux = ! this.sections[this.contSections];
      this.sections[this.contSections]= aux;
      
    
  }

  saveData():void{
    let directionI: IDirectionInversor={
      state: this.direction.state,
      city: this.direction.city,
      postalCode: this.direction.postalCode,
      colony: this.direction.colony,
      street: this.direction.street,
      intStreet: this.direction.intStreet
    }

    let inversorI: IInversor={
      names:this.inversor.names,
      lastFatherName: this.inversor.lastFatherName,
      lastMotherName: this.inversor.lastMotherName,
      rfc:this.inversor.rfc,
      bornDate: this.inversor.bornDate,
      gradeAcademic: this.inversor.gradeAcademic,
      work:this.inversor.work
    }

    let infoFinancialI: IInfoFinancial={
      bank:this.infoFinancial.bank,
      clabe:this.infoFinancial.clabe,
      savings:this.infoFinancial.savings,
      accountBank:this.infoFinancial.accountBank
  }
  }

  ngOnInit(): void {
  }

}
