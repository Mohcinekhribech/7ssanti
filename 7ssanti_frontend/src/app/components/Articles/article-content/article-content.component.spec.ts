import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ArticleContentComponent } from './article-content.component';

describe('ArticleContentComponent', () => {
  let component: ArticleContentComponent;
  let fixture: ComponentFixture<ArticleContentComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ArticleContentComponent]
    });
    fixture = TestBed.createComponent(ArticleContentComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
