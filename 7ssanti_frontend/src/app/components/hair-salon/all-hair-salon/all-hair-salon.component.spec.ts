import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllHairSalonComponent } from './all-hair-salon.component';

describe('AllHairSalonComponent', () => {
  let component: AllHairSalonComponent;
  let fixture: ComponentFixture<AllHairSalonComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllHairSalonComponent]
    });
    fixture = TestBed.createComponent(AllHairSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
