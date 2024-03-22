import { TestBed } from '@angular/core/testing';

import { ResponseDetailService } from './response-detail.service';

describe('ResponseDetailService', () => {
  let service: ResponseDetailService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ResponseDetailService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
