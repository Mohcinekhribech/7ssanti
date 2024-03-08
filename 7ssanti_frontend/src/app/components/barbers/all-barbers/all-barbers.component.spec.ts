import { ComponentFixture, TestBed } from '@angular/core/testing';

import { AllBarbersComponent } from './all-barbers.component';

describe('AllBarbersComponent', () => {
  let component: AllBarbersComponent;
  let fixture: ComponentFixture<AllBarbersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [AllBarbersComponent]
    });
    fixture = TestBed.createComponent(AllBarbersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
