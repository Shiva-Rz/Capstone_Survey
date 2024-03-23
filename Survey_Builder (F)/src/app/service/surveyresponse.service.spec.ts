import { TestBed } from '@angular/core/testing';

import { SurveyresponseService } from './surveyresponse.service';

describe('SurveyresponseService', () => {
  let service: SurveyresponseService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurveyresponseService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
