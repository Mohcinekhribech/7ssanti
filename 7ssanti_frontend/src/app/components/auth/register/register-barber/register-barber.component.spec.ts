import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RegisterBarberComponent } from './register-barber.component';

describe('RegisterBarberComponent', () => {
  let component: RegisterBarberComponent;
  let fixture: ComponentFixture<RegisterBarberComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RegisterBarberComponent]
    });
    fixture = TestBed.createComponent(RegisterBarberComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
