package lottogame.controller.resultcheck.spi;

import java.util.Set;

public interface ResultCheckInputer {

    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();
    
}
