import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { ThemeService } from 'ng2-charts';
import { IDirectionInversor } from '../../model/interfaces/IDirection';

@Component({
  selector: 'app-register-direction',
  templateUrl: './register-direction.component.html',
  styleUrls: ['./register-direction.component.css']
})
export class RegisterDirectionComponent implements OnInit {

  constructor(private fb: FormBuilder) { }

  ngOnInit(): void {
  }

  @Input() showDirection:boolean=false;
  @Input() direction!:IDirectionInversor;
  @Output() previousPhase = new EventEmitter<void>();
  @Output() nextPhase = new EventEmitter<void>();

  directionGroup:FormGroup= this.fb.group({
    state: new FormControl('', Validators.compose([
      Validators.required])),
    city: new FormControl('', Validators.compose([
      Validators.required,
      ]))
  ,
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

  public validationMessages = {
    postalCode: [
      { type: 'required', message: 'El código postal no esta seleccionado.' }
    ],
    colony: [
      { type: 'required', message: 'La colonia no esta seleccionada.' }
    ],
    street: [
      { type: 'required', message: 'La calle no es válida' }
    ],
    state: [
      { type: 'required', message: 'El estado no esta seleccionado.' }
    ],
    city: [
      { type: 'required', message: 'La ciudad no esta seleccionada.' }
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
