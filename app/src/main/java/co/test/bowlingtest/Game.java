package co.test.bowlingtest;

class Game {
    private int rolls[] = new int[21];
    private int currentRoll = 0;

    void roll(int pins) {
        rolls[currentRoll++] = pins;
    }

    int score() {

        int score = 0;
        for (int frameIndex = 0; frameIndex < 20; frameIndex += 2) {
            if (isSpare(frameIndex)) {
                score += 10 + spareBonus(frameIndex);
            } else if (isStrike(frameIndex)) {
                score += 10 + strikeBonus(frameIndex);
                frameIndex--;
            } else
                score += frameScore(frameIndex);
        }
        return score;
    }

    private int frameScore(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1];
    }

    private int spareBonus(int frameIndex) {
        return rolls[frameIndex + 2];
    }

    private int strikeBonus(int frameIndex) {
        return rolls[frameIndex + 1] + rolls[frameIndex + 2];
    }

    private boolean isStrike(int frameIndex) {
        return rolls[frameIndex] == 10;
    }

    private boolean isSpare(int frameIndex) {
        return rolls[frameIndex] + rolls[frameIndex + 1] == 10;
    }

}
