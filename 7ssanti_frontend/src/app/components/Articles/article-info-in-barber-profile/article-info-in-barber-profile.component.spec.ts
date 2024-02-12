import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleInfoInBarberProfileComponent } from './article-info-in-barber-profile.component';

describe('ArticleInfoInBarberProfileComponent', () => {
  let component: ArticleInfoInBarberProfileComponent;
  let fixture: ComponentFixture<ArticleInfoInBarberProfileComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArticleInfoInBarberProfileComponent]
    });
    fixture = TestBed.createComponent(ArticleInfoInBarberProfileComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
