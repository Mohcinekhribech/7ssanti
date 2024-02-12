import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestedHairSalonComponent } from './suggested-hair-salon.component';

describe('SuggestedHairSalonComponent', () => {
  let component: SuggestedHairSalonComponent;
  let fixture: ComponentFixture<SuggestedHairSalonComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SuggestedHairSalonComponent]
    });
    fixture = TestBed.createComponent(SuggestedHairSalonComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
