import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { InvestmentService } from 'src/app/services/InvestmentService';
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

  constructor(private fb: FormBuilder, private investmentService:InvestmentService) { }
  inversor: Inversor = new Inversor()  ;
  direction!: DirectionInversor;
  infoFinancial!: InfoFinancial ;
  showProfile: boolean = true;
  showDirection: boolean = false;
  showInfoFinance: boolean = false;
  contSections =0;
  sections: Array<boolean> = [this.showProfile, this.showDirection, this.showInfoFinance];


  previousSection(){
  
    
      this.contSections= this.contSections- 1;
    
      
    
  }

  nextSection(object: any){
   
    switch(this.contSections){
      case 0:
        this.inversor =  object; 
      break;
      case 1: 
      this.direction = object;
      break;
      case 2:
        this.infoFinancial = object;
        break;
    }
    this.contSections= this.contSections + 1;
  

      
    
  }

  saveData():void{
   this.investmentService.createInversor(this.inversor);
  }

  ngOnInit(): void {
  }

}
