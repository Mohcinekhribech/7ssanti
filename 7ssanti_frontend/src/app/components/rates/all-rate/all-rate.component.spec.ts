import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllRateComponent } from './all-rate.component';

describe('AllRateComponent', () => {
  let component: AllRateComponent;
  let fixture: ComponentFixture<AllRateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllRateComponent]
    });
    fixture = TestBed.createComponent(AllRateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
