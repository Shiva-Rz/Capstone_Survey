import { TestBed } from '@angular/core/testing';

import { ForcePasswordResetService } from './force-password-reset.service';

describe('ForcePasswordResetService', () => {
  let service: ForcePasswordResetService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(ForcePasswordResetService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
