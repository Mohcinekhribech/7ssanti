import { ComponentFixture, TestBed } from '@angular/core/testing';

import { BarbersComponent } from './barbers.component';

describe('BarbersComponent', () => {
  let component: BarbersComponent;
  let fixture: ComponentFixture<BarbersComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [BarbersComponent]
    });
    fixture = TestBed.createComponent(BarbersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
