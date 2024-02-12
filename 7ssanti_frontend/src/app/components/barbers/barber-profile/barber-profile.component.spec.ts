import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarberProfileComponent } from './barber-profile.component';

describe('BarberProfileComponent', () => {
  let component: BarberProfileComponent;
  let fixture: ComponentFixture<BarberProfileComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarberProfileComponent]
    });
    fixture = TestBed.createComponent(BarberProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
