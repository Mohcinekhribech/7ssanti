import { Time } from '@angular/common';
import { Component } from '@angular/core';
import { Store } from '@ngrx/store';
import { addStartTimeInReservation } from 'src/app/store/actions/reservation.action';

@Component({
  selector: 'app-choose-time',
  templateUrl: './choose-time.component.html',
  styleUrls: ['./choose-time.component.css'],
})
export class ChooseTimeComponent {
  constructor(private store:Store){}
  startTime:Time | undefined ;
  morningTime:String[] = this.generateTimeSlots("9:00","12:00",5)
  afternoonTime:String[] = this.generateTimeSlots("14:00","20:00",5)
  showMorningTime:boolean = false
  showAfternoonTime:boolean = false
  ngOnInit(){

  }
  

  generateTimeSlots(startTime: string, endTime: string, intervalMinutes: number): string[] {
    const result: string[] = [];
    const [startHour, startMinute] = startTime.split(":").map(Number);
    const [endHour, endMinute] = endTime.split(":").map(Number);
    
    let currentTime = new Date();
    currentTime.setHours(startHour, startMinute, 0, 0);

    const endTimeDate = new Date();
    endTimeDate.setHours(endHour, endMinute, 0, 0);

    while (currentTime <= endTimeDate) {
        const hour = currentTime.getHours().toString().padStart(2, "0");
        const minute = currentTime.getMinutes().toString().padStart(2, "0");
        result.push(`${hour}:${minute}`);
        currentTime = new Date(currentTime.getTime() + intervalMinutes * 60000); // Increment by intervalMinutes
    }

    return result;
}

  shooseTime(startTime:String)
  {
      this.store.dispatch(addStartTimeInReservation({startTime:startTime}));
  }
}
