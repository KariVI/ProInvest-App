import { Component, OnInit } from '@angular/core';
import { FormBuilder, FormControl, FormGroup, Validators } from '@angular/forms';
import { Chart } from 'chart.js'

@Component({
  selector: 'app-simulate-investment',
  templateUrl: './simulate-investment.component.html',
  styleUrls: ['./simulate-investment.component.css']
})
export class SimulateInvestmentComponent implements OnInit {

  

  constructor(private fb: FormBuilder) { }

  invesmentGroup:FormGroup= this.fb.group({
    money: new FormControl('', Validators.compose([
      Validators.required,
      Validators.min(1)])),
    years: new FormControl('', Validators.compose([
      Validators.required,
      Validators.min(1),
      Validators.max(5)]))
  });

  public validationMessages = {
    money: [
      { type: 'required', message: 'Ingresa un monto' },
      {type: 'min', message: 'Ingresa un monto mayor a 0'}
    ],
    years: [
      { type: 'required', message: 'Ingresa un año mayor a 0' },
      { type: 'min', message: 'Ingresa 1 año por lo menos' },
     { type: 'max', message: 'Ingresa un año menor a 6'}]
  }

  simulate(): void{
    let money =  Number.parseFloat(this.invesmentGroup.get('money')?.value);
    let years = Number.parseInt(this.invesmentGroup.get('years')?.value);
    let annualRate = 0.05;

    let performance= (money * annualRate) / 360 * (years * 360);


  }

  public chart: Chart | undefined;
  ngOnInit() {
    this.chart = new Chart("canvas", {
      type: "bar",
      data: {
        labels: ["2022 ", "2023", "2024", "2025", "2026"],
        datasets: [
          {
            label: "Rendimiento",
            data: [12, 19, 3, 5, 2],
            backgroundColor: [
              "rgba(255, 99, 132, 0.2)",
              "rgba(54, 162, 235, 0.2)",
              "rgba(255, 206, 86, 0.2)",
              "rgba(75, 192, 192, 0.2)",
              "rgba(153, 102, 255, 0.2)"
            ],
            borderColor: [
              "rgba(255, 99, 132, 1)",
              "rgba(54, 162, 235, 1)",
              "rgba(255, 206, 86, 1)",
              "rgba(75, 192, 192, 1)",
              "rgba(153, 102, 255, 1)"
            ],
            borderWidth: 1
          }
        ]
      },
      options: {
        scales: {
          yAxes: [
            {
              ticks: {
                beginAtZero: true
              }
            }
          ]
        }
      }
    });
  }



  
}
