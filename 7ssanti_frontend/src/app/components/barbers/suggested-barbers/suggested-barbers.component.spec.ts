import { ComponentFixture, TestBed } from '@angular/core/testing';

import { SuggestedBarbersComponent } from './suggested-barbers.component';

describe('SuggestedBarbersComponent', () => {
  let component: SuggestedBarbersComponent;
  let fixture: ComponentFixture<SuggestedBarbersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [SuggestedBarbersComponent]
    });
    fixture = TestBed.createComponent(SuggestedBarbersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
