import { Component, Input, OnInit } from '@angular/core';
import { GraphModel } from '../model/GraphModel';

@Component({
  selector: 'app-bargraph',
  templateUrl: './bargraph.component.html',
  styleUrls: ['./bargraph.component.css']
})
export class BargraphComponent implements OnInit {

  @Input() List: Array<GraphModel> = [];

  public Total=0;
  public MaxHeight= 160;

  constructor() { }

  ngOnInit(): void {
    this.drawGraph();
  }

  drawGraph(){
    if(this.List){
      this.List.forEach(element => {
        if(element.Value)
          this.Total += element.Value ;
      });
    

    this.List.forEach(element => {
      if(element.Value)
       element.Size = Math.round((element.Value*this.MaxHeight)/this.Total) + '%';
    });
    }
  }
}
