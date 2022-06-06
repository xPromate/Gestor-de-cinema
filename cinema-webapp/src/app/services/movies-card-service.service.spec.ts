import { TestBed } from '@angular/core/testing';

import { MoviesCardServiceService } from './movies-card-service.service';

describe('MoviesCardServiceService', () => {
  let service: MoviesCardServiceService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MoviesCardServiceService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
