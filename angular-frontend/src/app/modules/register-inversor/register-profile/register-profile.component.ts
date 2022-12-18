import { Component, EventEmitter, Input, OnInit, Output } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { environmentURL } from 'src/app/enviroments/enviroments';
import { IInversor } from '../../model/interfaces/IInversor';
import { Inversor } from '../../model/Inversor';

@Component({
  selector: 'app-register-profile',
  templateUrl: './register-profile.component.html',
  styleUrls: ['./register-profile.component.css']
})
export class RegisterProfileComponent implements OnInit {

  constructor(private fb: FormBuilder) { }
  @Input() inversor: Inversor = new Inversor();
  @Output() previousPhase = new EventEmitter<void>();
  @Output() nextPhase = new EventEmitter<any>();
   newInversor: Inversor = new Inversor();
    
  inversorGroup: FormGroup = this.fb.group({
    names: new FormControl('', Validators.compose(
      [Validators.required])),
    lastMotherName: new FormControl('', Validators.compose(
      [Validators.required])),
    lastFatherName: new FormControl('', Validators.compose(
        [Validators.required])),
    rfc: new FormControl('', Validators.compose(
          [Validators.required,
          Validators.pattern(/^[A-ZÑ&]{3,4}\d{6}(?:[A-Z\d]{3})?$/
          )])),
    date: new FormControl('', Validators.compose(
            [Validators.required])),
    work: new FormControl('', Validators.compose(
              [Validators.required])),
    grade: new FormControl('', Validators.compose(
      [Validators.required]))
    })

    
  showRegisterPage(){
    let result = environmentURL.baseClient + "principal";
    return result;
  }
  
    public validationMessages = {
      names: [
        { type: 'required', message: 'Ingresa el nombre por favor' }
      ],
      lastFatherName: [
       { type: 'required', message: 'Ingresa el apellido paterno por favor' }],
      lastMotherName: [
        { type: 'required', message: 'Ingresa el apellido materno por favor' }],
      rfc: [
        { type: 'required', message: 'Ingresa el  rfc por favor' },
          { type: 'pattern', message: 'El rfc es invalido'  }],
      date: [
        { type: 'required', message: 'Ingresa tu fecha de nacimiento por favor' }
        ,{ type: 'pattern', message: 'La fecha de nacimiento es invalida'  }],
      work: [
        { type: 'required', message: 'Ingresa tu profesión por favor' }],
      grade: [
            { type: 'required', message: 'Selecciona tu grado académico'  }]
      
      }

      

      evaluateForm():boolean{
        let result: boolean = true;
        if (  this.inversorGroup.valid ) {
          result = false;
        }
    
        return result;
      }

      
      createInversor(){
        
        this.newInversor.names = this.inversorGroup.get('names')?.value.toString();
        this.newInversor.lastFatherName = this.inversorGroup.get('lastFatherName')?.value.toString();
        this.newInversor.lastMotherName = this.inversorGroup.get('lastMotherName')?.value.toString();
        this.newInversor.rfc = this.inversorGroup.get('rfc')?.value.toString();
        this.newInversor.bornDate = this.inversorGroup.get('date')?.value.toString();
        this.newInversor.work = this.inversorGroup.get('work')?.value.toString();
        this.newInversor.gradeAcademic = this.inversorGroup.get('grade')?.value.toString();
        
       
      }
    
      nextSection(inversor: Inversor){
        this.createInversor();
        this.nextPhase.emit(inversor);
      }


      setGrade(){
        this.inversorGroup.get('gradeAcademic')?.setValue(this.inversor.gradeAcademic);

      }

  ngOnInit(): void {
    if(this.inversor){
      this.inversorGroup.get('names')?.setValue(this.inversor.names);
      this.inversorGroup.get('lastFatherName')?.setValue(this.inversor.lastFatherName);
      this.inversorGroup.get('lastMotherName')?.setValue(this.inversor.lastMotherName);
      this.inversorGroup.get('rfc')?.setValue(this.inversor.rfc);
      this.inversorGroup.get('date')?.setValue(this.inversor.bornDate);
      this.inversorGroup.get('work')?.setValue(this.inversor.work);
      this.setGrade();
      console.log(this.inversorGroup.get('gradeAcademic')?.value);

    }
  }

 
  return(){
    this.previousPhase.emit();
  }
}
