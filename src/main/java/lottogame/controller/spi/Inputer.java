package lottogame.controller.spi;

import java.util.List;
import java.util.Set;

public interface Inputer {

    long inputMoney();

    int inputPassiveLottoTicketCount();

    List<Set<Integer>> inputPassiveLottoTickets(int count);

    Set<Integer> inputWinningLottoNumbers();

    Integer inputBonusLottoNumber();

}
