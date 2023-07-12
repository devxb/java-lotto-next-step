package lottogame.domain;

import java.util.Arrays;

public enum LottoPrize {

    FIRST(6, MagicNumberSupporter.BONUS_NOT_RELATED, 2_000_000_000) {
        @Override
        boolean isLottoPrize(int matchedCount, boolean isBonusMatched) {
            return matchedCount == 6;
        }
    },
    SECOND(5, MagicNumberSupporter.BONUS_RELATED, 30_000_000) {
        @Override
        boolean isLottoPrize(int matchedCount, boolean isBonusMatched) {
            return matchedCount == 5 && isBonusMatched;
        }
    },
    THIRD(5, MagicNumberSupporter.BONUS_NOT_RELATED, 1_500_000) {
        @Override
        boolean isLottoPrize(int matchedCount, boolean isBonusMatched) {
            return matchedCount == 5 && !isBonusMatched;
        }
    },
    FORTH(4, MagicNumberSupporter.BONUS_NOT_RELATED, 50_000) {
        @Override
        boolean isLottoPrize(int matchedCount, boolean isBonusMatched) {
            return matchedCount == 4;
        }
    },
    FIFTH(3, MagicNumberSupporter.BONUS_NOT_RELATED, 5_000) {
        @Override
        boolean isLottoPrize(int matchedCount, boolean isBonusMatched) {
            return matchedCount == 3;
        }
    },
    NONE(0, MagicNumberSupporter.BONUS_NOT_RELATED, 0) {
        @Override
        boolean isLottoPrize(int matchedCount, boolean isBonusMatched) {
            return matchedCount < 3;
        }
    },
    ;

    private final int matchedCount;
    private final boolean isBonusMatched;
    private final int money;

    LottoPrize(int matchedCount, boolean isBonusMatched, int money) {
        this.matchedCount = matchedCount;
        this.isBonusMatched = isBonusMatched;
        this.money = money;
    }

    public static LottoPrize of(int matchedCount, boolean isBonusMatched) {
        return Arrays.stream(LottoPrize.values()).sequential()
            .filter(lottoPrize -> lottoPrize.isLottoPrize(matchedCount, isBonusMatched))
            .findFirst()
            .orElse(NONE);
    }

    abstract boolean isLottoPrize(int matchedCount, boolean isBonusMatched);

    public int getMoney() {
        return money;
    }

    public int getMatchedCount() {
        return matchedCount;
    }

    public boolean isBonusMatched() {
        return isBonusMatched;
    }

    private static final class MagicNumberSupporter {

        private static final boolean BONUS_NOT_RELATED = false;
        private static final boolean BONUS_RELATED = true;
    }
}
