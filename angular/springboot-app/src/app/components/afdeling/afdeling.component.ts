import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-afdeling',
  templateUrl: './afdeling.component.html',
  styleUrls: ['./afdeling.component.css']
})
export class AfdelingComponent implements OnInit {
  afdelingen = [];

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.loadAfdelingen();
  }
  loadAfdelingen() {
    this.dataService.loadAfdelingen().subscribe(
      data => {
        console.log('afdeling data:', data)
        this.afdelingen = data
      },
      error => {
        console.log('Failed to load afdelingen')
      }
    )
  }

}
