import { TestBed } from '@angular/core/testing';

import { SurveyResponseService } from './survey-response.service';

describe('SurveyResponseService', () => {
  let service: SurveyResponseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurveyResponseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
