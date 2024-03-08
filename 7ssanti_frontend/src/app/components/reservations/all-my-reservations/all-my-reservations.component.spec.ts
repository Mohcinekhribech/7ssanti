import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllMyReservationsComponent } from './all-my-reservations.component';

describe('AllMyReservationsComponent', () => {
  let component: AllMyReservationsComponent;
  let fixture: ComponentFixture<AllMyReservationsComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllMyReservationsComponent]
    });
    fixture = TestBed.createComponent(AllMyReservationsComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
