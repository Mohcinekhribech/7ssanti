import { ComponentFixture, TestBed } from '@angular/core/testing';

import { RateFormComponent } from './rate-form.component';

describe('RateFormComponent', () => {
  let component: RateFormComponent;
  let fixture: ComponentFixture<RateFormComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [RateFormComponent]
    });
    fixture = TestBed.createComponent(RateFormComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
