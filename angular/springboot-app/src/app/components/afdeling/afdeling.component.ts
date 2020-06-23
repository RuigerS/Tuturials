import { Component, OnInit } from '@angular/core';
import { DataService } from 'src/app/service/data.service';

@Component({
  selector: 'app-afdeling',
  templateUrl: './afdeling.component.html',
  styleUrls: ['./afdeling.component.css']
})
export class AfdelingComponent implements OnInit {
  afdelingen = [];
  model: any = {}
  showModelAfdeling = false;

  constructor(private dataService: DataService) { }

  ngOnInit(): void {
    this.loadAfdelingen();
  }
  loadAfdelingen() {
    this.dataService.loadAfdelingen().subscribe(
      data => {
        console.log('afdeling data:', data)
        this.afdelingen = data;
      },
      error => {
        console.log('Failed to load afdelingen')
      }
    )
  }
  onSubmit() {

    this.dataService.saveAfdeling(this.model).subscribe(
      data => {
        console.log('Submitting form' + data);
        this.loadAfdelingen();
      },
      error => {
        console.log('Error submitting form');
      }
    );
    this.showModelAfdeling = false;
  }
  addAfdeling() {
    this.model = { id: 0, naam: '' };
    this.showModelAfdeling = true;
  }
  deleteAfdeling(id) {
    console.log('Delete click '+id);
    this.dataService.deleteAfdeling(id).subscribe(
      data => {
        console.log('afdeling deleted:', id)
        this.loadAfdelingen();
      },
      error => {
        console.log('Failed to delete afdeling'+id)
      } 
    )
  }
}
