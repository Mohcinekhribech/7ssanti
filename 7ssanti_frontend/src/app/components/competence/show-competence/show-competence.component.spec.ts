import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ShowCompetenceComponent } from './show-competence.component';

describe('ShowCompetenceComponent', () => {
  let component: ShowCompetenceComponent;
  let fixture: ComponentFixture<ShowCompetenceComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ShowCompetenceComponent]
    });
    fixture = TestBed.createComponent(ShowCompetenceComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
