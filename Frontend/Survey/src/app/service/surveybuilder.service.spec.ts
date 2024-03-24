import { TestBed } from '@angular/core/testing';

import { SurveybuilderService } from './surveybuilder.service';

describe('SurveybuilderService', () => {
  let service: SurveybuilderService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(SurveybuilderService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
