import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ResponseTemplateComponent } from './response-template.component';

describe('ResponseTemplateComponent', () => {
  let component: ResponseTemplateComponent;
  let fixture: ComponentFixture<ResponseTemplateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [ResponseTemplateComponent]
    });
    fixture = TestBed.createComponent(ResponseTemplateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
