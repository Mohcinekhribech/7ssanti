import { Component, EventEmitter, Output } from '@angular/core';

@Component({
  selector: 'app-modal',
  templateUrl: './modal.component.html',
  styleUrls: ['./modal.component.css']
})
export class ModalComponent {
  
  @Output() closeEvent = new EventEmitter<boolean>();
  closeModal()
  {
      this.closeEvent.emit(false) ;
  }
}
