import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Observable } from 'rxjs';
import { DataService } from 'src/app/services/data.service';
import {  InfoFinancial } from '../../model/InfoFinancial';
import { IBank, ISourceFunds } from '../../model/interfaces/IBank';

@Component({
  selector: 'app-register-info-financial',
  templateUrl: './register-info-financial.component.html',
  styleUrls: ['./register-info-financial.component.css']
})
export class RegisterInfoFinancialComponent implements OnInit {

  constructor(private fb: FormBuilder, private data: DataService) { }
  @Input() infoFinancial: InfoFinancial = new InfoFinancial();
  @Output() previousPhase = new EventEmitter<void>();
  $banks: Observable<IBank[]> = new Observable();
  $sourceFunds: Observable<ISourceFunds[]> = new Observable();
  @Output() nextPhase = new EventEmitter<void>();

  ngOnInit(): void {
    this.$banks= this.data.getBanks();
    this.$sourceFunds = this.data.getSourcesFund();
  }
  

  infoFinanceGroup:FormGroup= this.fb.group({
    bank: new FormControl('', null),
    clabe: new FormControl('', Validators.compose([
      Validators.required,
      ])),
    savings: new FormControl('',null),
    accountBank: new FormControl('', Validators.compose([
        Validators.required
      ]))
  });

  evaluateForm():boolean{
    let result: boolean = false;
    if(this.infoFinanceGroup){
      result=true;
    }
    return result;
  }

  public validationMessages = {
 
    clabe: [
      { type: 'required', message: 'La CLABE no es válida.' }
    ],
    accountBank: [
      { type: 'required', message: 'La cuenta bancaria no es válida.' }
    ]
   
  }

  createInfoFinancial(){
    /*this.infoFinancial.bank = this.infoFinanceGroup.get("bank")?.value;
    this.infoFinancial.clabe = this.infoFinanceGroup.get("clabe")?.value;
    this.infoFinancial.accountBank = this.infoFinanceGroup.get("accountBank")?.value;
    this.infoFinancial.savings = this.infoFinanceGroup.get("savings")?.value;*/
    this.nextPhase.emit();

  }

  returnInfo(): void{
    this.previousPhase.emit();
  }
 
  
  
}
