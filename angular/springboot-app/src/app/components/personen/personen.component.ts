import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-personen',
  templateUrl: './personen.component.html',
  styleUrls: ['./personen.component.css']
})
export class PersonenComponent implements OnInit {
  personen = [];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.loadPersonen();
  }
  loadPersonen() {
    this.dataService.loadPersonen().subscribe(
      data => {
        console.log('personen data:', data);
        this.personen = data;
      },
      error => {
        console.log('Failed to load personen');
      }
    );
  }
}
