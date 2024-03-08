import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ChooseTimeComponent } from './choose-time.component';

describe('ChooseTimeComponent', () => {
  let component: ChooseTimeComponent;
  let fixture: ComponentFixture<ChooseTimeComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ChooseTimeComponent]
    });
    fixture = TestBed.createComponent(ChooseTimeComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
