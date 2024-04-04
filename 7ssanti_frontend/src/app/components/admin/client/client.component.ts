import { Component } from '@angular/core';
import { ClientReq } from 'src/app/core/models/request/ClientReq.model';
import { ClientService } from 'src/app/core/services/client.service';

@Component({
  selector: 'app-client',
  templateUrl: './client.component.html',
  styleUrls: ['./client.component.css']
})
export class ClientComponent {
  constructor(private clientService: ClientService) {}
  clients:ClientReq[] =[];
  isShowAddForm : boolean = false;
  isShowUpdateForm : boolean = false;
  id:number = 0;

  ngOnInit() {
    this.getData();
  }

  getData() {
    this.clientService.getClients().subscribe(
      data => {
        this.clients = data
      }
    );
  }

}
