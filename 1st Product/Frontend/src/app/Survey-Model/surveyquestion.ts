export class SurveyQuestion {
    constructor(
        public type: string,
        public question: string,
        public answer: string | string[],
        public options: string[] = []
    ) { }
}