import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MovieCinemaRoomComponent } from './movie-cinema-room.component';

describe('MovieCinemaRoomComponent', () => {
  let component: MovieCinemaRoomComponent;
  let fixture: ComponentFixture<MovieCinemaRoomComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ MovieCinemaRoomComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(MovieCinemaRoomComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});
