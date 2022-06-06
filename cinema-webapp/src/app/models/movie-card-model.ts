import { Person } from './cast'
export class Moviecard {
	id: string;
	title: string;
	durationTime: string;
	description: number;
	voiceLanguage: string;
    subtitleLanguage: string;
    trailerUrl: string;
	genre: string[];
	cast: Person[];
	movieImageUrl: string;
	movieScore: number;
}