import { ComponentFixture, TestBed } from '@angular/core/testing';

import { DashrboardComponent } from './dashrboard.component';

describe('DashrboardComponent', () => {
  let component: DashrboardComponent;
  let fixture: ComponentFixture<DashrboardComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [DashrboardComponent]
    });
    fixture = TestBed.createComponent(DashrboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
