import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ThemeService } from 'ng2-charts';
import { Observable } from 'rxjs';
import { DataService } from 'src/app/services/data.service';
import { IDirectionInversor } from '../../model/interfaces/IDirection';
import { ICpData } from '../../model/interfaces/IPostalCode';

@Component({
  selector: 'app-register-direction',
  templateUrl: './register-direction.component.html',
  styleUrls: ['./register-direction.component.css']
})
export class RegisterDirectionComponent implements OnInit {

  constructor(private fb: FormBuilder, private data: DataService) { }

  //$questions: Observable<Question[]> = new Observable();
  $sepoMex: Observable<ICpData[]> =new Observable();
  ngOnInit( ): void {
  }

  showSecondSection: boolean = false;

  @Input() showDirection:boolean=false;
  @Input() direction!:IDirectionInversor;
  @Output() previousPhase = new EventEmitter<void>();
  @Output() nextPhase = new EventEmitter<void>();

  directionGroup:FormGroup= this.fb.group({
   
    postalCode: new FormControl('', Validators.compose([
        Validators.required
      ])),
    colony: new FormControl('', Validators.compose([
        Validators.required
      ])),
  street: new FormControl('', Validators.compose([
        Validators.required
      ])),
  intStreet: new FormControl('', Validators.compose([
        Validators.required
    ]))
  });

  searchCodePostal(){

    let postalCode = this.directionGroup.get('postalCode')?.value.toString();
    this.$sepoMex=this.data.getDataByPostalCode(postalCode);
    this.showSecondSection=true;

  }
  public validationMessages = {
    postalCode: [
      { type: 'required', message: 'No se ha escrito un código postal .' }
    ],
    colony: [
      { type: 'required', message: 'La colonia no esta seleccionada.' }
    ],
    street: [
      { type: 'required', message: 'La calle no es válida' }
    ],
    intStreet: [
      { type: 'required', message: 'El número de calle no esta seleccionado.' }
    ]
  }

  evaluateForm():boolean{
    let result: boolean = false;
    if(this.directionGroup.valid){
      result=true;
    }
    return result;
  }

  createDirection(){
    this.direction.city = this.directionGroup.get('city')?.value.toString;
    this.direction.colony = this.directionGroup.get('colony')?.value.toString;
    this.direction.state = this.directionGroup.get('state')?.value.toString;
    this.direction.street = this.directionGroup.get('street')?.value.toString;
    this.direction.postalCode = this.directionGroup.get('postalCode')?.value.toString;
    this.direction.intStreet = Number.parseInt(this.directionGroup.get('intStreet')?.value.toString);
    this.nextPhase.emit();
  }

  returnInfo(): void{
    this.previousPhase.emit();
  }
}
