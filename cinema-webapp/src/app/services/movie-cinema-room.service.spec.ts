import { TestBed } from '@angular/core/testing';

import { MovieCinemaRoomService } from './movie-cinema-room.service';

describe('MovieCinemaRoomService', () => {
  let service: MovieCinemaRoomService;

  beforeEach(() => {
    TestBed.configureTestingModule({});
    service = TestBed.inject(MovieCinemaRoomService);
  });

  it('should be created', () => {
    expect(service).toBeTruthy();
  });
});
